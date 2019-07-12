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
		long todoID = Long.parseLong(request.getParameter("id"));
		String status = request.getParameter("type");
		TodoDAO dao = new TodoDAO();

		if (!status.equals("TODO") && !status.equals("DOING")) {
			response.setStatus(400);
			return;
		}

		String nextStatus = (status.equals("TODO")) ? "DOING" : "DONE";

		//		switch (status) {
		//				case "TODO":
		//					nextStatus = "DOING";
		//					break;
		//				case "DOING":
		//					nextStatus = "DONE";
		//					break;
		//				default:
		//					throw new IllegalArgumentException("유효하지 않은 type");
		//			}

		Todo nextTodo = new Todo();
		nextTodo.setId(todoID);
		nextTodo.setType(nextStatus);

		try {
			dao.updateTodo(nextTodo);
		} catch (SQLException e) {
			System.out.println("Error Type: " + e.getClass().getName());
			System.out.println("Error Message: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
