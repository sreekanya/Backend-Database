package com.example.Myapp2;

import java.util.Iterator;

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
        System.out.println( "Hello Welcome to MongoDB World!" );
        
        try {
			
        	String mongoDbURI = "mongodb+srv://sreekanya:GamGanapathi@cluster0.kvjxkge.mongodb.net/?retryWrites=true&w=majority";
        	MongoClient client = MongoClients.create(mongoDbURI);
        	System.out.println("Connection created successfully");
        	
        	System.out.println("Some Database Names :");
        	System.out.println(client.listDatabaseNames());
        	
        	Iterator itr = client.listDatabaseNames().iterator();
        	while(itr.hasNext()) {
        		System.out.println(itr.next().toString());
        	}
        	
        	MongoDatabase db = client.getDatabase("estore");
        	System.out.println("Collection names in DB estore");
        	System.out.println(db.listCollectionNames());
        	
        	itr =  db.listCollectionNames().iterator();
        	while(itr.hasNext()) {
        		System.out.println(itr.next().toString());
        	}
        	
        	
		} catch (Exception e) {
			System.out.println("Something went wrong");
			System.out.println("Message"+e.getMessage());
		}
        
    }
}
