package com.example.MongoDBCRUDOperations;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.MongoDBCRUDOperations.dao.DBOperations;
import com.example.MongoDBCRUDOperations.model.Customer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "MongoDB CRUD Operations" );
        DBOperations operations = new DBOperations();
        
//        Customer customer = new Customer("John Watson","2341234534","john@example.com",98.4F,new Date(), new Date());
//        System.out.println("Details of Customer");
//        System.out.println(customer);
        
//        List<Customer> customers = new ArrayList<Customer>();
//        customers.add(new Customer("Fiona","2341234534","fiona@example.com",98.4F,new Date(), new Date()));
//        customers.add(new Customer("Mike","4082348909","mike@example.com",98.4F,new Date(), new Date()));
//        customers.add(new Customer("Anna","4086572345","anna@example.com",98.4F,new Date(), new Date()));
//        
//        operations.insertCustomer(customers);
        
        
          List<Customer> customers = operations.getAllCustomers();

          customers.forEach(customer ->{
        	  System.out.println(customer);
          });
          
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Fetching customer with email: fiona@example.com ");
//          Customer customer = operations.getCustomerByEmail("fiona@example.com");
//          System.out.println(customer);

//          operations.updateCustomer("fiona@example.com", "points", '100');
//          operations.updateCustomer("fiona@example.com", "phone", "408-111-9999");
//          operations.updateCustomer("fiona@example.com", "address", "500, Homestead Road, Santa Clara, CA");
          
//          operations.upsertCustomer("mike@example.com", "feedback", "A Wonderful learning");
//          operations.upsertCustomer("leo@example.com", "feedback", "A Wonderful learning experience");
        
//          	operations.upsertOffersToCustomers();
          
//          operations.updateCustomer("fiona@example.com", "promocode", "JUMBO");
          
//          operations.deleteCustomer("leo@example.com");
          
//          	operations.deleteCustomers();
  //        	operations.deleteCollection("users");
          
    }
}
