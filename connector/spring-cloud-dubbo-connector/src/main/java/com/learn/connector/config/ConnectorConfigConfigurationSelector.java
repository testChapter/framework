package com.learn.connector.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import com.learn.connector.annotation.EnableConnectorConfig;
import com.learn.connector.constants.ServiceFromEnum;

public class ConnectorConfigConfigurationSelector implements ImportSelector, Ordered {

	private static String SERVICE_FROM = "serviceFrom";

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		AnnotationAttributes attributes = AnnotationAttributes
				.fromMap(importingClassMetadata.getAnnotationAttributes(EnableConnectorConfig.class.getName()));
		ServiceFromEnum serviceFromEnum = attributes.getEnum(SERVICE_FROM);
		if (serviceFromEnum == ServiceFromEnum.ANNOTATION) {
			return of(AnnotationConnectorConfig.class.getName());
		}
		if (serviceFromEnum == ServiceFromEnum.XML_DEFINATION) {
			return of(XmlDefinationConnectorConfig.class.getName());
		}
		if (serviceFromEnum == ServiceFromEnum.BOTH) {
			return of(AnnotationConnectorConfig.class.getName(), XmlDefinationConnectorConfig.class.getName());
		}
		return null;
	}

	private String[] of(String... names) {
		return names;
	}

	@Override
	public int getOrder() {
		return HIGHEST_PRECEDENCE - 10;
	}

}
