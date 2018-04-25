package com.learn.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.learn.dubbo.mapper")
@EnableMethodCache(basePackages = "com.learn.dubbo")
@EnableCreateCacheAnnotation
public class SpringBootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDubboProviderApplication.class, args);
	}
	
}
