package edu.topica.entity;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Entity {
	public abstract int getId();
	
	/**
	 * parse Result of mysql connection to object
	 * check exist prefix for result. When result for multi table 
	 * @param ResultSet res, boolean
	 * @throws SQLException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void parseToObject(ResultSet res,boolean check) throws SQLException, IllegalArgumentException, IllegalAccessException {
		Field[] fields = this.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String name="";
			boolean accessible = fields[i].isAccessible();
			fields[i].setAccessible(true);
			name = fields[i].getName();
			if (name!="") {
				fields[i].set(this, getValField(fields[i].getType(), res, name));
			}
			fields[i].setAccessible(accessible);
		}
	}
	/**
	 * get data for other fields
	 * @param clazz
	 * @param res
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	private Object getValField(Class<?> clazz, ResultSet res, String name) throws SQLException {
		if (clazz == Integer.class)
			return res.getInt(name);
		if (clazz == BigDecimal.class)
			return res.getBigDecimal(name);
		if (clazz == Boolean.class)
			return res.getBoolean(name);
		if (clazz == Long.class)
			return res.getLong(name);
		if (clazz == Date.class)
			return res.getDate(name);
		if (clazz == Short.class)
			return res.getShort(name);
		if(clazz==String.class) return res.getString(name);
		return null;
	}
}
