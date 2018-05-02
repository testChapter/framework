package com.learn.connector.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.learn.connector.config.ConnectorConfigConfigurationSelector;
import com.learn.connector.constants.ServiceFromEnum;

@Retention(RUNTIME)
@Target(TYPE)
@Inherited
@Documented
@Import(ConnectorConfigConfigurationSelector.class)
public @interface EnableConnectorConfig {

	ServiceFromEnum serviceFrom() default ServiceFromEnum.ANNOTATION;

}
