package com.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.todo.TodoService;


@WebServlet(urlPatterns="/register.do")
public class RegisterServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
		
	}
	
protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		String pwd=request.getParameter("pwd");
		String mail=request.getParameter("mail");
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String pwd1=request.getParameter("pwd-1");
		
		boolean isvalid= true;
		if(!pwd.contentEquals(pwd1)) {
			isvalid=false;
		}
		
		if(isvalid) {
			//System.out.print(name);
			InsertDocument in=new InsertDocument();
			if(in.insertDataUser(new User(fname,lname,mail,pwd))) {
				request.getSession().setAttribute("name",fname);
				response.sendRedirect("/list-todo.do");
			}
			else {
				request.setAttribute("error","Sory! Email Already Registered");
				request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
			}
			
			
		}
		else {
			request.setAttribute("error","Re Enter Password correctly");
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
		}
		
	}

	
}
