package com.nts.todo.exception;

import javax.servlet.ServletException;

public class DBInsertionException extends ServletException {
	private String errorMessage;

	public DBInsertionException(String errorMeessage) {
		this.errorMessage = errorMeessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
