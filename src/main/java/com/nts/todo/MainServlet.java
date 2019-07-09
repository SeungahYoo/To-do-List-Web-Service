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
		List<Todo> doings = null;
		List<Todo> dones = null;

		try {
			todos = dao.getTodos("TODO");
			doings = dao.getTodos("DOING");
			dones = dao.getTodos("DONE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("todos", todos);
		request.setAttribute("doings", doings);
		request.setAttribute("dones", dones);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		requestDispatcher.forward(request, response);
	}

}
