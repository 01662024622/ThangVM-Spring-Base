package edu.topica.DAO.abstracts;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import edu.topica.anotation.Table;
import edu.topica.connect.Connect;
import edu.topica.entity.Entity;


public abstract class IDAO<T extends Entity> {
	
	private Connection conn;
	private String lent="";
	private String ofset="";
	private Set<String> condition=new HashSet<String>();
	private String table="";
	private Class<T> classes;
	public IDAO(Class<T> clazz) throws ClassNotFoundException, SQLException {
		this.classes=clazz;
		this.table = clazz.getAnnotation(Table.class).name();
		this.conn= Connect.getIntanse().getConnection();
	}
	
	
	
	/**
	 * get student after set condition or ofset or limmit
	 * @param Class generic
	 * @return list generic
	 * @throws Exception
	 */
	public List<T> get() throws Exception {
		List<T> lists = new ArrayList<T>();
		String query = String.join(" ", "SELECT * FROM", table, this.getCondition(), this.ofset, this.lent);
		Statement stmt = this.conn.createStatement();
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			T object = createGenericClass();
			object.parseToObject(res,false);
			lists.add(object);
		}
		this.clear();
		return lists;
	}
	
	/**
	 * create student to db
	 * @throws Exception
	 */
	public void create(T t) throws Exception {
		Field[] fields = t.getClass().getDeclaredFields();
		List<String> col=new ArrayList<String>();

		List<String> val=new ArrayList<String>();
		
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			col.add("`"+fields[i].getName()+"`");
			val.add("'"+fields[i].get(t).toString()+"'");
		}
		String clauseCol = col.stream().map(Object::toString).collect(Collectors.joining(", "));
		String clauseVal = val.stream().map(Object::toString).collect(Collectors.joining(", "));
		String query = String.join(" ", "INSERT INTO", table, "("+clauseCol+")","VALUES","("+clauseVal+")");
		System.out.println(query);
		Statement stmt = this.conn.createStatement();
		stmt.executeLargeUpdate(query);
		this.clear();
	}
	/**
	 * create list student to db
	 * @throws Exception
	 */
	public void create(List<T> t) throws Exception {
		for (int i = 0; i < t.size(); i++) {
			create(t.get(i));
		}
		this.clear();
	}
	/**
	 * set condition for clause
	 * @param col
	 * @param cond
	 * @param id
	 * @return
	 */
	
	public IDAO<T> setCondition(String col,String cond,String id){
		this.condition.add(String.join("", col,cond,id));
		return this;
	};
	
	/**
	 * set ofset for clause
	 * @param ofset
	 * @return
	 */
	public IDAO<T> setOfset(int ofset){
		this.ofset= String.join(" ", "OFSET",String.valueOf(lent));
		return this;
	};
	
	/**
	 * set limmit for result
	 * @param lent
	 * @return
	 */
	public IDAO<T> setLent(int lent) {
		this.lent= String.join(" ", "LIMIT",String.valueOf(lent));
		return this;
	}
	
	/**
	 * get condition right for clause Query DB
	 * @return
	 */
	private String getCondition() {
		if (this.condition.size()==0) {
			return "";
		}
		return "WHERE " + String.join(" AND ", this.condition);
	}
	
	
	/**
	 * clear all property of clause
	 */
	private void clear() {
		this.lent="";
		this.condition.clear();
		this.ofset="";
	}
	/**
	 * Create new generic class
	 * @param <T>
	 * @return T
	 * @throws Exception
	 */
	
	@SuppressWarnings("unchecked")
	private T createGenericClass() throws Exception {
		@SuppressWarnings("rawtypes")
		Constructor[]  newObject = this.classes.getDeclaredConstructors();
		@SuppressWarnings("rawtypes")
		Constructor ctor = null;
		for (int i = 0; i < newObject.length; i++) {
			ctor = newObject[i];
		    if (ctor.getGenericParameterTypes().length == 0)
			break;
		}
	    ctor.setAccessible(true);
		T object = null;
		object= (T) ctor.newInstance();
 	    return object;
	}
	
}
