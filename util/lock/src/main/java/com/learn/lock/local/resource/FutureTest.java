package com.learn.lock.local.resource;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();

		Future<Integer> result = es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				Thread.sleep(16000);
				return 55;
			}
		});

		try {
			System.out.println("begin get result at " + String.valueOf(System.currentTimeMillis()));
			Integer x = result.get(18000, TimeUnit.MILLISECONDS);
			System.out.println("get result at " + String.valueOf(System.currentTimeMillis()));
			System.out.println(x);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdownNow();
	}

}
