package com.learn.connector.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Retention(RUNTIME)
@Target(TYPE)
@DubboServiceScan
@EnableConnectorConfig
public @interface EnableCloudDubboConnector {

	@AliasFor(annotation = DubboServiceScan.class, attribute = "basePackages")
	String[] scanBasePackages() default {};

}
