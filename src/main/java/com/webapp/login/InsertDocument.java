package com.webapp.login;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import webapp.todo.Todo;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class InsertDocument {
	public static MongoClient mongo = new MongoClient( "localhost" , 27017 );
	public static MongoDatabase database = mongo.getDatabase("todos");
	public static MongoCollection<Document> collection_user = database.getCollection("user");
	public static MongoCollection<Document> collection_todo = database.getCollection("todo");
	
	public boolean insertDataUser(User user) {
		//System.out.println("Collection user selected successfully");
		 BasicDBObject whereQuery = new BasicDBObject();
		 whereQuery.put("mail",user.getMail());
		FindIterable<Document> cursor = collection_user.find(whereQuery);
		Iterator<Document> it=cursor.iterator();
		if(it.hasNext()) {
			return false;
		}
		Document document = new Document("fname",user.getFname())
		.append("lname",user.getLname())
		.append("mail",user.getMail())
		.append("pwd", user.getPassword());
		collection_user.insertOne(document);
		System.out.println("Document inserted successfully");
		return true;
	}
	
	public boolean insertDataTodo(Todo todo,String s) {
		
		Document document = new Document("id",todo.getId())
				.append("category",todo.getCategory())
				.append("name",todo.getName())
				.append("mail",s);
		collection_todo.insertOne(document);
		
		return true;
		
	}
	
	
	
}
