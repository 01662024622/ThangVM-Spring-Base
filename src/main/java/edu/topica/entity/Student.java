package edu.topica.entity;

import edu.topica.anotation.Table;

@Table(name="student")
public class Student extends Entity{
	private Integer id;
	private String name;
	private String birthOfDate;
	private Integer gender;
	
//	contructor
	public Student(int id,String name,String birthOfDate,int gender) {
		this.id= id;
		this.name=name;
		this.birthOfDate = birthOfDate;
		this.gender =gender;
	}
	public Student() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthOfDate() {
		return birthOfDate;
	}
	public void setBirthOfDate(String birthOfDate) {
		this.birthOfDate = birthOfDate;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"---"+this.name+"---"+this.birthOfDate+"---"+this.gender;
	}
	
}
