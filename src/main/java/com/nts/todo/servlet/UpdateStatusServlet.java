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

@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		long todoID = Long.parseLong(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		String status = request.getParameter("type");
		TodoDAO dao = new TodoDAO();
		String nextStatus = "";
		if (status != null && status.equals("TODO")) {
			nextStatus = "DOING";
		} else if (status != null && status.equals("DOING")) {
			nextStatus = "DONE";
		}
		Todo nextTodo = new Todo();
		nextTodo.setId(todoID);
		nextTodo.setType(nextStatus);
		try {
			dao.updateTodo(nextTodo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
