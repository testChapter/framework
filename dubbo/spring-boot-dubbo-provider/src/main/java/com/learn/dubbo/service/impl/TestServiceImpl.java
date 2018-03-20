package com.learn.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.dubbo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public String sayHello(String name) {
		return "hello " + name + "!";
	}

}
