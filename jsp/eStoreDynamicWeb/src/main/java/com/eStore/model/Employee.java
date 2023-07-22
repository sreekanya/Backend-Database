package com.eStore.model;

public class Employee {
	public int eid;
	public String first_name;
	public String last_name;
	public int age;
	
	public Employee() {
		
	}
	
	public Employee(int eid, String first_name, String last_name, int age) {
		super();
		this.eid = eid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "employee [eid=" + eid + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ "]";
	}
	
	
}
