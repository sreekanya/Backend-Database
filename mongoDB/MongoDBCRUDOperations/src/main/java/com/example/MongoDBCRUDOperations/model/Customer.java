package com.example.MongoDBCRUDOperations.model;

import java.util.Date;

import org.bson.Document;

public class Customer {
	String name;
	String phone;
	String email;
	Float temparature;
	Date intime;
	Date outtime;
	
	public Customer() {
		
	}

	public Customer(String name, String phone, String email, Float temparature, Date intime, Date outtime) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.temparature = temparature;
		this.intime = intime;
		this.outtime = outtime;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", email=" + email + ", temparature=" + temparature
				+ ", intime=" + intime + ", outtime=" + outtime + "]";
	}
	
	public Document getDocument() {
		Document document = new Document();
	//	document.append("_id", new.ObjectId());
		document.append("name", name);
		document.append("phone", phone);
		document.append("email", email);
		document.append("temparature", temparature);
		document.append("intime", intime);
		document.append("outtime", outtime);
		return document;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getTemparature() {
		return temparature;
	}

	public void setTemparature(Float temparature) {
		this.temparature = temparature;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Date getOuttime() {
		return outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	
	
}
