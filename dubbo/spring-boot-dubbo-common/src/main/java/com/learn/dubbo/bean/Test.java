package com.learn.dubbo.bean;

import java.io.Serializable;

public class Test implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
