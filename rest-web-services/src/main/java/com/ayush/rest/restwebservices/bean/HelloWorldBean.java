package com.ayush.rest.restwebservices.bean;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message){
		this.message=message;
		
	}

	//getter is mandatory for automatic conversion to happen

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
