package com.learn.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Import;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication

public class SpringBootDubboConsumerApplication {

	public static void main(String[] args) {
		
		//AutowiredAnnotationBeanPostProcessor
		//CommonAnnotationBeanPostProcessor
//		AnnotationConfigUtils.registerAnnotationConfigProcessors(registry);
		SpringApplication.run(SpringBootDubboConsumerApplication.class, args);
	}

}
