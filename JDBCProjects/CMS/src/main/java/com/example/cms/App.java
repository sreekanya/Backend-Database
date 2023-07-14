package com.example.cms;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.cms.db.DB;
import com.example.cms.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Welcome to MYDB App" );
//        Employee employee = new Employee();
//        employee.setEmpid(3);
//        employee.setFname("Robinson");
//        employee.setLname("Kardashian");
//        employee.setAge(32);
//        
//        System.out.println("connecting to DB.....");
//        DB db = new DB();
//        
//        db.createConnection();
//        
//        //db.createEmployee(employee);
//        db.updateEmployee(employee);
//        
//        //db.deleteEmployee(2);
//        
//        ArrayList<Employee> employees = db.getAllEmployees();
//        employees.forEach(emp -> System.out.println(emp));
//        
//        db.closeConnection();
    	
    		Scanner scanner = new Scanner(System.in);
    		
    		System.out.println("Eneter First Name : ");
    		String fName = scanner.nextLine();
    		
    		System.out.println("Eneter Last Name : ");
    		String lName = scanner.nextLine();
    		
    		System.out.println("Eneter age : ");
    		int age = Integer.parseInt(scanner.nextLine());
    		
    		scanner.close();
    		
    		DB db = new DB();
    		db.createConnection();
    		db.executeStoredProcedure(fName,lName,age);
    		db.closeConnection();
        
    }
}
