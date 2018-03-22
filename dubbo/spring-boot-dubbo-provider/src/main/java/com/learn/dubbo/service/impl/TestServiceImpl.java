package com.learn.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.dubbo.exception.BaseException;
import com.learn.dubbo.exception.BaseRuntimeException;
import com.learn.dubbo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public String sayHello(String name) throws BaseException {
		if ("exception".equals(name)) {
			throw new BaseException("baseException","数据错误");
		}
		return "hello " + name + "!";
	}

	@Override
	public String welcome(String name, String from) {
		if ("exception".equals(name)) {
			throw new BaseRuntimeException("baseRuntimeException","数据错误");
		}
		return "welcome " + name + " from " +from+"!";
	}

}
