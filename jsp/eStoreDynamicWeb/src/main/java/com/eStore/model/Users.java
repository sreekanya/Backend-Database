package com.eStore.model;

public class Users {
	public int uid;
	public String name;
	public String email;
	public String password;
	
	public Users() {
		
	}

	public Users(int uid, String name, String email, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
