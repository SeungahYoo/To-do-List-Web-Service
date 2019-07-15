package com.nts.todo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nts.todo.dao.TodoDAO;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext servletContext = this.getServletContext();

		try {
			TodoDAO dao = (TodoDAO)servletContext.getAttribute("dao");

			request.setAttribute("todos", dao.getTodos("TODO"));
			request.setAttribute("doings", dao.getTodos("DOING"));
			request.setAttribute("dones", dao.getTodos("DONE"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getOutputStream().println("<script>alert('데이터 로드 실패');</script>");
		}

	}
}
