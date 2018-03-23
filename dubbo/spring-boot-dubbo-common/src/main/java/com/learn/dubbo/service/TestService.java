package com.learn.dubbo.service;

import java.util.List;

import com.learn.dubbo.bean.Test;
import com.learn.dubbo.exception.BaseException;

public interface TestService {

	String sayHello(String name) throws BaseException;
	
	String welcome(String name,String from);
	
	List<Test> getList();

}
