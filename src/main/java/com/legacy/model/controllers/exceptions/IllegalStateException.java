package com.legacy.model.controllers.exceptions;

public class IllegalStateException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public IllegalStateException(String msg) {
		super(msg);
	}
}
