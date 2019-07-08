package com.nts.todo;

import java.util.List;

import com.nts.todo.dao.todoDAO;
import com.nts.todo.dto.todo;

public class test {
	public static void main(String[] args) {
		todoDAO dao = new todoDAO();
		List<todo> ret = dao.getTodos("TODO");
		System.out.println(ret);
	}
}
