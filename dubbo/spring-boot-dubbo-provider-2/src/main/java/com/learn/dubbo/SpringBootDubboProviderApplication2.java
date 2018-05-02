package com.learn.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.DispatcherServlet;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
//import com.learn.connector.annotation.EnableCloudDubboConnector;

@EnableDubbo
@SpringBootApplication
//@EnableCloudDubboConnector
@MapperScan("com.learn.dubbo.mapper")
public class SpringBootDubboProviderApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboProviderApplication2.class, args);
	}

}
