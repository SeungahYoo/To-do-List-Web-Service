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

@WebServlet("/update-status")
public class UpdateStatusServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, NullPointerException {
		try {
			long todoID = Long.parseLong(request.getParameter("id"));
			String status = request.getParameter("type");
			if (!status.equals("TODO") && !status.equals("DOING")) {
				System.out.println("유효하지 않은 status");
				response.setStatus(400);
				return;
			}
			TodoDAO dao = new TodoDAO();
			String nextStatus = (status.equals("TODO")) ? "DOING" : "DONE";
			Todo nextTodo = new Todo();

			nextTodo.setId(todoID);
			nextTodo.setType(nextStatus);
			dao.updateTodo(nextTodo);
		} catch (SQLException e) {
			System.out.println("Error Type: " + e.getClass().getName());
			System.out.println("Error Message: " + e.getMessage());
			response.setStatus(400);
			return;
		}
	}
}
