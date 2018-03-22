package com.learn.dubbo.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BaseException(String name,String message) {
		super(message);
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
