package com.learn.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
public class SpringBootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboProviderApplication.class, args);
	}

}
