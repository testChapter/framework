package com.learn.dubbo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.dubbo.bean.Test;
import com.learn.dubbo.exception.BaseException;
import com.learn.dubbo.exception.BaseRuntimeException;
import com.learn.dubbo.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Reference
	TestService testService;

	@RequestMapping("/sayHello")
	public String sayHello(String name) {
		String result = null;
		try {
			long start = System.currentTimeMillis();
			result = testService.sayHello(name);
			System.out.println("cost time is " + (System.currentTimeMillis() - start));
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/welcome")
	public String welcome(String name, String from) {
		String result = null;
		try {
			result = testService.welcome(name, from);
		} catch (BaseRuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/getList")
	public List<Test> getList() {
		return testService.getList();
	}
}
