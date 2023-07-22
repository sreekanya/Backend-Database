package com.eStore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	public Connection connection;
	//public PreparedStatement preparedStatement;
	
	public static DB db = new DB();
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String uname = "sreekanya";
			String password = "Ax23*dVgNOws";
			String url = "jdbc:mysql://localhost/mydb";
			
			connection = DriverManager.getConnection(url,uname,password);
			System.out.println(" Connected to the database MYDB");
			
		} catch (Exception e) {
			System.out.println("Connection error");
			System.out.println("Exception Occured "+e);
		}
		
		
	}
	
	public int executeUpdate(PreparedStatement statement) {
		int result = 0;
		try {
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet executeQuery(PreparedStatement statement) {
		ResultSet set = null;
		try {
			set = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}
	
	public static DB getDB() {
		return db;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
