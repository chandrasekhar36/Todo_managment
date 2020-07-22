package webapp.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.todo.Todo;
import webapp.todo.TodoService;


@WebServlet(urlPatterns="/delete-todo.do")
public class DeleteTodo extends HttpServlet{
	
	private TodoService todoservice=new TodoService();
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

		long id=Long.parseLong(request.getParameter("id"));
		System.out.print(id+" detelted");
		todoservice.deleteTodo(id);
		response.sendRedirect("/list-todo.do");
		
	}
	
}
