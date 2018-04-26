package com.learn.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.learn.dubbo.bean.Test;
import com.learn.dubbo.exception.BaseException;
import com.learn.dubbo.exception.BaseRuntimeException;
import com.learn.dubbo.mapper.TestMapper;
import com.learn.dubbo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestMapper testMapper;
	
	@CreateCache(expire = 3600)
	private Cache<Long,String> stringCache;

	@Override
	@Cached(name = "TestService.sayHello", expire = 3600)
	public String sayHello(String name) throws BaseException {
		System.out.println(name);
		if ("exception".equals(name)) {
			throw new BaseException("baseException", "数据错误");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello " + name + "!";
	}

	@Override
	public String welcome(String name, String from) {
		if ("exception".equals(name)) {
			throw new BaseRuntimeException("baseRuntimeException", "数据错误");
		}
		return "welcome " + name + " from " + from + "!";
	}

	@Override
	public List<Test> getList() {
		return testMapper.selectTest();
	}

}
