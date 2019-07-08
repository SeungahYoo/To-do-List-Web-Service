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

import com.nts.todo.dto.Todo;

public class TodoDAO {
	private static String DB_URL = "jdbc:mysql://10.113.116.52:13306/user10?useSSL=false";
	private static String DB_USER = "user10";
	private static String DB_PASSWORD = "user10";
	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static Connection CONN = null;
	private static PreparedStatement PS = null;
	private static ResultSet RS = null;

	public TodoDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public List<Todo> getTodos(String type) {
		ArrayList<Todo> todos = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT * FROM todo WHERE type = ?";
			PS = CONN.prepareStatement(sql);
			PS.setString(1, type);
			RS = PS.executeQuery();

			while (RS.next()) {
				Todo selectedTodo = new Todo();
				selectedTodo.setId(RS.getLong("id"));
				selectedTodo.setTitle(RS.getString("title"));
				selectedTodo.setName(RS.getString("name"));
				selectedTodo.setSequence(RS.getInt("sequence"));
				selectedTodo.setType(RS.getString("type"));

				//String -> LocalDateTime type casting
				String tmpDate = RS.getString("regdate");
				LocalDateTime dateTime = LocalDateTime.parse(tmpDate.substring(0, tmpDate.length() - 2), FORMATTER);
				selectedTodo.setRegdate(dateTime);

				todos.add(selectedTodo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (RS != null) {
				try {
					RS.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (PS != null) {
				try {
					PS.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (CONN != null) {
				try {
					CONN.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return todos;
	}

	public int addTodo(Todo todo) {
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
			PS = CONN.prepareStatement(sql);
			PS.setString(1, todo.getTitle());
			PS.setString(2, todo.getName());
			PS.setInt(3, todo.getSequence());
			RS = PS.executeQuery();

			result = PS.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (RS != null) {
				try {
					RS.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (PS != null) {
				try {
					PS.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (CONN != null) {
				try {
					CONN.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int updateTodo(Todo todo) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String currentType = todo.getType();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			CONN = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "";
			if (currentType.equals("TODO")) {
				sql = "update todo set type = 'DOING' where id = ?";
			} else if (currentType.equals("DOING")) {
				sql = "update todo set type = 'DONE' where id = ?";
			}
			ps = CONN.prepareStatement(sql);
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
			if (CONN != null) {
				try {
					CONN.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

}
