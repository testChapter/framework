package com.learn.lock.local.resource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(200));
			}
		});
		t1.start();
		int i = 0;
		while (i++ < 15) {
			System.out.println(t1.getState());
			try {
				Thread.sleep(10);
				if (i == 4) {
					System.out.println("unpark");
					LockSupport.unpark(t1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
