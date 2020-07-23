package com.webapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.todo.Todo;
import com.webapp.todo.TodoService;


@WebServlet(urlPatterns="/list-todo.do")
public class ListTodoServlet extends HttpServlet{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private TodoService todoservice=new TodoService();
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//System.out.print(request.getParameter("name"));
		HttpSession s=request.getSession(false);
		String user=(String) s.getAttribute("mail");
		request.setAttribute("todos",todoservice.retriveTodos(user));
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
		
	}
}
