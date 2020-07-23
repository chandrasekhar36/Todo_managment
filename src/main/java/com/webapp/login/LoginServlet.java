package com.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.todo.TodoService;


@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{
	private UserValidationService uservalidationservice =new UserValidationService();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		String pwd=request.getParameter("pwd");
		String mail=request.getParameter("name");
		String name=uservalidationservice.isUserValid(mail,pwd);
		if(!name.equals("Incorrect_SORRY")) {
			request.getSession().setAttribute("name",name);
			request.getSession(false).setAttribute("mail",mail);
			response.sendRedirect("/list-todo.do");
		}
		else {
			request.setAttribute("error","Name or password entered is wrong");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
	}

}
