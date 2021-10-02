package com.springboot.library.exception;

public class LibraryNotFoundException extends Exception {

	public LibraryNotFoundException(String message) {
		super(message);
	}
}
