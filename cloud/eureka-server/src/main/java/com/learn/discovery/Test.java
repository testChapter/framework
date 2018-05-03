package com.learn.discovery;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://218.0.106.223:8086/queueSysinterface.aspx");
		post.setHeader("Content-type", "application/json; charset=utf-8");
		// 构建消息实体
		Map<String, String> map = new HashMap<String, String>();
		map.put("interfacename", "getnumberlistforallserial");
		StringEntity entity = new StringEntity(JSONObject.toJSONString(map), Charset.forName("UTF-8"));
		entity.setContentEncoding("UTF-8");
		// 发送Json格式的数据请求
		entity.setContentType("application/json");
		post.setEntity(entity);
		HttpResponse response = client.execute(post);
		response.getEntity().getContent();
		System.out.println(IOUtils.toString(response.getEntity().getContent(), "UTF-8"));
	}

}
