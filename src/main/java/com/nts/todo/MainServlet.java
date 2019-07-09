package com.nts.todo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.todo.dao.TodoDAO;
import com.nts.todo.dto.Todo;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		TodoDAO dao = new TodoDAO();
		List<Todo> todos = null;

		try {
			todos = dao.getTodos("TODO");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(todos);
		request.setAttribute("todos", todos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		requestDispatcher.forward(request, response);
	}

}
