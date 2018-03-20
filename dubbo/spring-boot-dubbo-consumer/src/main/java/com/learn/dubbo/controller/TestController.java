package com.learn.dubbo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.dubbo.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Reference
	TestService testService;

	@RequestMapping("/sayHello")
	public String sayHello(String name) {
		return testService.sayHello(name);
	}

}
