package com.learn.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication
public class SpringBootDubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboConsumerApplication.class, args);
	}

}
