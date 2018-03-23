package com.learn.lock.local;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.learn.lock.AbstractLock;
import com.learn.lock.local.resource.LocalLockResource;

public class LocalStoreLock extends AbstractLock {

	public LocalStoreLock(LocalLockResource resource) {
		this.lockResource = resource;
	}

	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet get =new HttpGet("http://www.google.com/");
		//执行请求
		CloseableHttpResponse response =httpClient.execute(get);
		//取响应的结果
		int statusCode =response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity =response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
}
