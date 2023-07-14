package com.example.cms.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.cms.model.Employee;

/*  JDBC Procedure
 	1. Download driver and link to the project. For maven project configure pom.xml
 	2. Load the driver from library i.e. jar file
 	3. Create connection to the database with url, username and password
 	4. Execute CRUD operation
 	5. Close connection 
 */

public class DB implements DAO{
	
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	CallableStatement callableStatement;
	
	final String TAG = getClass().getPackageName();
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(TAG+" Driver Loaded");
		} catch (Exception e) {
			System.out.println("Exception occured "+e);
		}
		
	}

	public void createConnection() {
		try {
			String uname = "sreekanya";
			String password = "Ax23*dVgNOws";
			String url = "jdbc:mysql://localhost/mydb";
			
			connection = DriverManager.getConnection(url,uname,password);
			System.out.println(TAG+" Connected to the database MYDB");
			
		} catch (Exception e) {
			System.out.println("Connection error");
			System.out.println("Exception Occured "+e);
		}
		
	}

	public void closeConnection() {
		try {
			connection.close();
			System.out.println(TAG+" disconnected from the database MYDB");
		} catch (Exception e) {
			System.out.println("not able to disconnect ");
			System.out.println("Exception Occured "+e);
		}
		
	}

	public void createEmployee(Employee employee) {
		try {
			//String sql = "insert into employee values(null, '"+ employee.getFname()+"','"+employee.getLname()+"',"+employee.getAge()+")";
			
			String sql = "insert into employee values(null, ?,?,?)";
			System.out.println(sql);
			
			//statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getFname());
			preparedStatement.setString(2, employee.getLname());
			preparedStatement.setInt(3, employee.getAge());
			
			int val = preparedStatement.executeUpdate();
			//int val = statement.executeUpdate(sql);
			String msg = (val>0) ? "Inseted a employee record successfully " : "Not able to insert";
			System.out.println(TAG+msg);
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		
	}

	public void updateEmployee(Employee employee) {
		try {
//			String sql = "update employee set first_name='"+ employee.getFname()+"',last_name='"+employee.getLname()+"',"
//					+ "age ="+employee.getAge()+" where eid ="+ employee.getEmpid();
			
			String sql = "update employee set first_name= ?,last_name= ?, age =? where eid =?";
			
			System.out.println(sql);
			
			// statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getFname());
			preparedStatement.setString(2, employee.getLname());
			preparedStatement.setInt(3, employee.getAge());
			
			preparedStatement.setInt(4, employee.getEmpid());
			
			//int val = statement.executeUpdate(sql);
			int val = preparedStatement.executeUpdate();
			
			String msg = (val>0) ? "Updated employee record successfully " : "Not able to update employee details";
			System.out.println(TAG+msg);
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		
		
	}

	public void deleteEmployee(int empid) {
		try {
			String sql = "delete from employee where eid="+empid;
			
			statement = connection.createStatement();
			int val = statement.executeUpdate(sql);
			String msg = (val>0) ? "Deleted employee record successfully " : "Not able to delete employee details";
			System.out.println(TAG+msg);
			
			
		} catch (Exception e) {
			System.out.println("Exception Occured "+e);
		}
		
	}

	public ArrayList<Employee> getAllEmployees() {
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			String sql = "select * from employee";
			
			statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				Employee emp = new Employee();
				
				emp.setEmpid(set.getInt(1));
				emp.setFname(set.getString(2));
				emp.setLname(set.getString(3));
				emp.setAge(set.getInt(4));
				
				employees.add(emp);
			}
			
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}
		return employees;
		
	}
	
	public void executeStoredProcedure(String fName,String lName,int age) {
		try {
			String sql = "{ call addemployee(?,?,?)}";
			
			callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, fName);
			callableStatement.setString(2, lName);
			callableStatement.setInt(3, age);
			callableStatement.execute();
			System.out.println("Stored procedure executed");
			
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}
	}

}
