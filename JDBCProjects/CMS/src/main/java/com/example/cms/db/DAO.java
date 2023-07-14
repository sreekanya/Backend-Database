package com.example.cms.db;

import java.util.ArrayList;

import com.example.cms.model.Employee;

public interface DAO {
	//interface for CRUD operations
	
	void createConnection();
	void closeConnection();
	
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int empid);
	ArrayList<Employee> getAllEmployees();

}
