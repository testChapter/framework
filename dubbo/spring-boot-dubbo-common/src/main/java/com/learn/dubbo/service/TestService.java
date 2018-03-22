package com.learn.dubbo.service;

import com.learn.dubbo.exception.BaseException;

public interface TestService {

	String sayHello(String name) throws BaseException;
	
	String welcome(String name,String from);

}
