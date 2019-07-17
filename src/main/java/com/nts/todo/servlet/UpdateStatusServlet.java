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
		throws ServletException, IOException {

		try {
			long todoID = Long.parseLong(request.getParameter("id"));
			String status = request.getParameter("type");

			if (status == null || (status.equals("TODO") == false && status.equals("DOING") == false)) {//status가 "TODO"도 아니고, "DOING"도 아닐 때.
				System.out.println("유효하지 않은 status");
				response.setStatus(406); //406(허용되지 않음): 요청한 페이지가 요청한 콘텐츠 특성으로 응답할 수 없다.
				return;
			}

			String nextStatus = (status.equals("TODO")) ? "DOING" : "DONE";

			Todo nextTodo = new Todo();
			nextTodo.setId(todoID);
			nextTodo.setType(nextStatus);

			TodoDAO dao = TodoDAO.getInstance();
			dao.updateTodo(nextTodo);
		} catch (SQLException e) {
			e.printStackTrace();
			response.setStatus(500); //500(내부 서버 오류): 서버에 오류가 발생하여 요청을 수행할 수 없다.
			return;
		}
	}
}
