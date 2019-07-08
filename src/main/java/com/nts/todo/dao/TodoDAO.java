package com.nts.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.nts.todo.dto.Todo;

public class TodoDAO {
	private static String DB_URL = "jdbc:mysql://10.113.116.52:13306/user10?useSSL=false";
	private static String DB_USER = "user10";
	private static String DB_PASSWORD = "user10";
	private static Connection CONN = null;

	public TodoDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public List<Todo> getTodos(String type) throws SQLException {
		System.out.println(type);
		ArrayList<Todo> todos = new ArrayList<>();
		String sql = "SELECT * FROM todo WHERE type = ?";

		try (PreparedStatement ps = CONN.prepareStatement(sql);) {
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Todo selectedTodo = new Todo();
				selectedTodo.setId(rs.getLong("id"));
				selectedTodo.setTitle(rs.getString("title"));
				selectedTodo.setName(rs.getString("name"));
				selectedTodo.setSequence(rs.getInt("sequence"));
				selectedTodo.setType(rs.getString("type"));

				//Timestamp -> LocalDateTime type casting
				Timestamp tmpDate = rs.getTimestamp("regdate");
				LocalDateTime dateTime = tmpDate.toLocalDateTime();
				selectedTodo.setRegdate(dateTime);

				todos.add(selectedTodo);
			}
		}
		return todos;
	}

	public int addTodo(Todo todo) throws SQLException {
		int result = 0;

		String sql = "INSERT INTO todo(title, name, sequence) VALUES(?, ?, ?)";
		try (PreparedStatement ps = CONN.prepareStatement(sql);) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			result = ps.executeUpdate();
		}
		return result;
	}

	public int updateTodo(Todo todo) throws SQLException {
		int result = 0;
		String currentType = todo.getType();
		String sql = "UPDATE todo SET type = 'DOING' WHERE id = ?";
		//sql = "update todo set type = 'DONE' where id = ?";
		try (PreparedStatement ps = CONN.prepareStatement(sql);) {
			ps.setLong(1, todo.getId());
			result = ps.executeUpdate();
		}
		return result;
	}

}
