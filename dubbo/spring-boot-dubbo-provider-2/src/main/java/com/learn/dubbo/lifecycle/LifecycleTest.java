package com.learn.dubbo.lifecycle;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.spring.ServiceBean;

@Component
public class LifecycleTest implements SmartLifecycle, BeanFactoryAware {

	private DefaultListableBeanFactory beanFactory;

	@Override
	public void start() {
		String[] beanNames = beanFactory.getBeanNamesForType(ServiceBean.class);
		for (String name : beanNames) {
			ServiceBean<?> object = (ServiceBean<?>) beanFactory.getBean(name);
			try {
				System.out.println(object.getRef().getClass());
				Class<?> clazz = object.getRef().getClass();
				Method[] methodList = clazz.getDeclaredMethods();
				for (Method method : methodList) {
					DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
					System.out.println(discoverer.getParameterNames(method) == null ? null
							: Arrays.asList(discoverer.getParameterNames(method)).toString());

				}
			} catch (LinkageError e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (DefaultListableBeanFactory) beanFactory;
	}

	public DefaultListableBeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(DefaultListableBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

}
