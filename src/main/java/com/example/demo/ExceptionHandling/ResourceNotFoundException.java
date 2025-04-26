package com.example.demo.ExceptionHandling;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
