package com.springboot.library.exception;

public class LibraryNotFoundRuntimeException extends RuntimeException {

	public LibraryNotFoundRuntimeException(String message) {
		super(message);
	}
}
