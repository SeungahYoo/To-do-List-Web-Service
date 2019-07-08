package com.nts.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.nts.todo.dto.todo;

public class todoDAO {
	private static String DB_URL = "jdbc:mysql://localhost:3306/nts?useSSL=false";
	private static String DB_USER = "yoo";
	private static String DB_PASSWORD = "1234";
	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public List<todo> getTodos(String type) {
		ArrayList<todo> todos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT * FROM todo WHERE type = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();

			while (rs.next()) {
				todo selectedTodo = new todo();
				selectedTodo.setId(rs.getLong("id"));
				selectedTodo.setTitle(rs.getString("title"));
				selectedTodo.setName(rs.getString("name"));
				selectedTodo.setSequence(rs.getInt("sequence"));
				selectedTodo.setType(rs.getString("type"));

				//String -> LocalDateTime type casting
				String tmpDate = rs.getString("regdate");
				LocalDateTime dateTime = LocalDateTime.parse(tmpDate.substring(0, tmpDate.length() - 2), FORMATTER);
				selectedTodo.setRegdate(dateTime);

				todos.add(selectedTodo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return todos;
	}

	public int addTodo(todo todo) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			rs = ps.executeQuery();

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int updateTodo(todo todo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String currentType = todo.getType();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "";
			if (currentType.equals("TODO")) {
				sql = "update todo set type = 'DOING' where id = ?";
			} else if (currentType.equals("DOING")) {
				sql = "update todo set type = 'DONE' where id = ?";
			}
			ps = conn.prepareStatement(sql);
			ps.setLong(1, todo.getId());
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

}
