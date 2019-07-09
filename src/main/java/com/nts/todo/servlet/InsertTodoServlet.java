package com.nts.todo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.todo.dao.TodoDAO;
import com.nts.todo.dto.Todo;

@WebServlet("/InsertTodoServlet")
public class InsertTodoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		int sequence = Integer.parseInt(req.getParameter("sequence"));

		TodoDAO dao = new TodoDAO();
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setName(name);
		todo.setSequence(sequence);
		try {
			dao.addTodo(todo);
		} catch (SQLException e) {

		}

		resp.sendRedirect("MainServlet");
	}

}
