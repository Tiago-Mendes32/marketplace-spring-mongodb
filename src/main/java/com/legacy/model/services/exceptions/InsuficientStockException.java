package com.legacy.model.services.exceptions;

public class InsuficientStockException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsuficientStockException(String msg) {
		super(msg);
	}
}
