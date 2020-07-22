package com.webapp.login;
import com.mongodb.client.MongoCollection;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoDatabase;

public class UserValidationService {
	static MongoCollection<Document> collection = InsertDocument.collection_user;
	
	public String isUserValid(String mail,String pwd) {
		
		 BasicDBObject whereQuery = new BasicDBObject();
		    whereQuery.put("mail",mail);
		    String fname="Incorrect_SORRY";
		    FindIterable<Document> cursor = collection.find(whereQuery);
		    Iterator<Document> it=cursor.iterator();
		    //System.out.print(cursor);
		    while (it.hasNext()) {
		    	Document d=it.next();
		    	//System.out.print(d);
		    	if(d.get("pwd").equals(pwd)) {
		    		fname=(String) d.get("fname");
		    		return fname;
		    	}
		    }
		return fname;
	}

}
