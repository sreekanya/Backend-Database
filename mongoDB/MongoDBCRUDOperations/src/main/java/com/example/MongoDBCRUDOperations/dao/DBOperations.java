package com.example.MongoDBCRUDOperations.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.MongoDBCRUDOperations.model.Customer;
import com.example.MongoDBCRUDOperations.util.*;

public class DBOperations {
	
	MongoClient client;
	MongoDatabase database;
	MongoCollection collection;
	
	public DBOperations() {
		try {
			String connenctionString = "mongodb+srv://sreekanya:GamGanapathi@cluster0.kvjxkge.mongodb.net/?retryWrites=true&w=majority";
			client = MongoClients.create(connenctionString);
			System.out.println("[DB Operations] connection created");
			
			database =client.getDatabase(Util.DB_NAME);
			System.out.println("[DB Operations] Database selected as estore");
			
			collection = database.getCollection(Util.COLLECTION_NAME);
			System.out.println("[DB Operations] collectins from estore selected as eustomer");
		}
		catch(Exception e){
			System.out.println("something went wrong"+e);
		}
	}
	
	public void insertCustomer(Customer customer) {
		try {
			Document document = customer.getDocument();
			collection.insertOne(document);
			System.out.println("[DB Operations] "+customer.getName()+" inserted into "+Util.COLLECTION_NAME);
			
		} catch (Exception e) {
			System.out.println("something went wrong"+e);
		}
		
	}
	
	public void insertCustomer(List<Customer> customers) {
		try {
			List <Document> documents = new ArrayList<Document>(); 
			
			for(Customer customer : customers) {
				
				documents.add(customer.getDocument());
			}
			
			collection.insertMany(documents);
			System.out.println("[DB Operations] "+customers.size()+" inserted into "+Util.COLLECTION_NAME);
			
		} catch (Exception e) {
			System.out.println("something went wrong"+e);
		}
		
	}
	
	public Customer converDocumentToCustomer(Document doc) {
		Customer customer = new Customer();
		
		customer.setName(doc.get("name").toString());
		customer.setPhone(doc.get("phone").toString());
		customer.setEmail(doc.get("email").toString());
		
		
		return customer;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			List <Document> documents = (List <Document>) collection
					.find()
					.sort(Sorts.ascending("name"))
					.into(new ArrayList<Document>());
			
			for(Document doc : documents) {
				
//				System.out.println(doc.toJson());
//				System.out.println(doc.get("name"));
//				System.out.println(doc.get("intime"));
				
				customers.add(converDocumentToCustomer(doc));
				
			}
			
		} catch (Exception e) {
			System.out.println("something went wrong"+e);
		}
		return customers;
		
	}
	
	public Customer getCustomerByEmail(String email){
		Document filter = new Document("email",email);
		Document document = (Document) collection.find(filter).first();
	//	Document document = (Document) collection.find(Filters.eq("email")).first();
		Customer customer = converDocumentToCustomer(document);
		
		return customer;
		
	}
	
	public void updateCustomer(String email, String key, String value) {
		try {
			
			Bson filter = Filters.eq("email",email);
//			Bson updateFilterOperations = Updates.set(key, value);
			Bson updateFilterOperations = Updates.push(key, value);
			collection.updateOne(filter, updateFilterOperations);
			
			FindOneAndUpdateOptions options = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
			Document updateDocument = (Document) collection.findOneAndUpdate(filter, updateFilterOperations,options);
			
			System.out.println("Document updated for the email "+email);
			System.out.println("Updated version of document is : "+updateDocument.toJson());
			
		} catch (Exception e) {
			System.out.println("something went wrong in Updation "+e);
		}
		
	}
	
	public void upsertCustomer(String email, String key, String value) {
		try {
			
			Bson filter = Filters.eq("email",email);
//			Bson updateFilterOperations = Updates.set(key, value);
			Bson updateFilterOperations = Updates.push(key, value);
			UpdateOptions options = new UpdateOptions();
			options.upsert(true);
			UpdateResult result = collection.updateOne(filter, updateFilterOperations, options);
			
			System.out.println("Result is "+result);
			System.out.println("Document updated for the email "+email);
			
		} catch (Exception e) {
			System.out.println("something went wrong in Updation "+e);
		}
		
	}
	
	public void upsertOffersToCustomers() {
		
		try {
			Bson filter = Filters.gte("points", 70);
			Bson updateOperations = Updates.push("promoCode", "CASHBACK20");
			UpdateResult result = collection.updateMany(filter, updateOperations);
			System.out.println("Result is "+result);
			
		} catch (Exception e) {
			System.out.println("something went wrong in Upsert many customers "+e);
		}
	}
	
	public void deleteCustomer(String email) {
		try {
			
			Bson filter = Filters.eq("email",email);
			DeleteResult result = collection.deleteOne(filter);
			
			if(result.getDeletedCount()>0) {
				System.out.println("Document Deleted"+result);
			}
			else {
				System.out.println("Document not found");
			}
			
		} catch (Exception e) {
			System.out.println("something went wrong in Deleting customer "+e);
		}
	}
	public void deleteCustomers() {
		try {
			
			Bson filter = Filters.lte("points",70);
			DeleteResult result = collection.deleteMany(filter);
			
			System.out.println("Document Deleted"+result);
			
			
		} catch (Exception e) {
			System.out.println("something went wrong in Deleting many customers "+e);
		}
	}
	
	public void deleteCollection(String collectionName) {
		try {
			collection = database.getCollection(collectionName);
			collection.drop();
			System.out.println(collectionName+" has been Deleted");
			
			
		} catch (Exception e) {
			System.out.println("something went wrong in Deleting collections "+e);
		}
		
	}
}
