package com.quiz.service.exp;

public class ResourceNotFoundException extends RuntimeException{
	private String status;

	public ResourceNotFoundException(String status) {
		super();
		this.status = status;
	}

	
	

}
