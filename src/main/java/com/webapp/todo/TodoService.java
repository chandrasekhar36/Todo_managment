package com.webapp.todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.webapp.login.InsertDocument;

public class TodoService {

	public static MongoCollection<Document> collection_todo = InsertDocument.collection_todo;

	public List<Todo> retriveTodos(String user) {

		List<Todo> todos = new ArrayList<Todo>();

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("mail", user);
		FindIterable<Document> cursor = collection_todo.find(whereQuery);
		Iterator<Document> it = cursor.iterator();
		while (it.hasNext()) {
			Document d = it.next();

			String name = (String) d.get("name");
			String cat = (String) d.get("category");
			long id = (long) d.get("id");
			System.out.print("ID is here " + id);
			Todo t = new Todo(name, cat, id);
			todos.add(t);
			// System.out.println("data is: "+d.get("name"));
		}

		return todos;
	}

	public void addTodo(Todo x, String s) {

		if (InsertDocument.insertDataTodo(x, s)) {
			System.out.print("Todo added");
		}

	}

	public void deleteTodo(long x) {

		// collection_todo.deleteOne(Filters.and(Filters.eq("name",x.name),Filters.eq("category",x.category)));
		collection_todo.deleteOne(Filters.eq("id", x));
	}

}
