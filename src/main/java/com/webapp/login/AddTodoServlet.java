package com.webapp.login;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import webapp.todo.Todo;
import webapp.todo.TodoService;


@WebServlet(urlPatterns="/add-todo.do")
public class AddTodoServlet extends HttpServlet{
	
	public static MongoCollection<Document> collection_todo=InsertDocument.collection_todo;
	private TodoService todoservice=new TodoService();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//System.out.print(request.getParameter("name"));
		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//System.out.print(request.getParameter("name"));
		String new_todo=request.getParameter("newtodo");
		String cat=request.getParameter("category");
		
		FindIterable<Document> cursor = collection_todo.find();
		Iterator<Document> it=cursor.iterator();
		long max=0;
		while(it.hasNext()) {
			Document d=it.next();
			long v=d.getLong("id");
			if(max < v) {
				max=v;
			}
		}
		
		long count=max+1;
		HttpSession s=request.getSession(false);
		String mail=(String) s.getAttribute("mail");
		todoservice.addTodo(new Todo(new_todo,cat,count),mail);
		response.sendRedirect("/list-todo.do");
	}
}
