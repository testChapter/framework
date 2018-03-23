package com.learn.dubbo.starter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class SpringBootDubboStarter {

	@Value("${spring.dubbo.applicationName:dubboApplication}")
	private String applicationName;

	@Value("${spring.dubbo.registry.type:zookeeper}")
	private String registryType;

	@Value("${spring.dubbo.registry.ip:127.0.0.1}")
	private String registryIp;

	@Value("${spring.dubbo.registry.port:2181}")
	private String registryPort;

	@Value("${spring.dubbo.protocol.port:20880}")
	private int protocolPort;

	private static String SEPARATOR_BETWEEN_TYPE_AND_IP = "://";

	private static String SEPARATOR_BETWEEN_IP_AND_PORT = ":";

	@Bean
	ApplicationConfig dubboApplicationConfig() {
		return new ApplicationConfig(applicationName);
	}

	@Bean
	RegistryConfig dubboRegistryConfig() {
		StringBuilder registryUriBuilder = new StringBuilder(registryType);
		registryUriBuilder.append(SEPARATOR_BETWEEN_TYPE_AND_IP).append(registryIp)
				.append(SEPARATOR_BETWEEN_IP_AND_PORT).append(registryPort);
		return new RegistryConfig(registryUriBuilder.toString());
	}

	@Bean
	ProtocolConfig dubboProtocolConfig() {
		ProtocolConfig config = new ProtocolConfig(applicationName, protocolPort);
		return config;
	}

}
