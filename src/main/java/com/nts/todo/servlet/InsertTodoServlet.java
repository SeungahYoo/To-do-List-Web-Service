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

@WebServlet("/insert-todo")
public class InsertTodoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			TodoDAO dao = TodoDAO.getInstance();
			dao.addTodo(createTodo(request));
			response.sendRedirect("main");
		} catch (SQLException e) {
			e.printStackTrace();

			response.getOutputStream()
				.println("<script>alert('등록에 실패했습니다. 다시 시도해주세요'); location.href='main';</script>");
		}

	}

	private Todo createTodo(HttpServletRequest request) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setName(name);
		todo.setSequence(sequence);
		return todo;
	}
}
