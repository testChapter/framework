package com.learn.lock.local.resource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		TimeLock tl = new TimeLock();
		Thread t1 = new Thread(tl, "T1");
		Thread t2 = new Thread(tl, "T2");
		Thread t3 = new Thread(tl, "T3");
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		try {
			
			if (lock.tryLock(8, TimeUnit.SECONDS)) {
				System.out.println("Thread " + Thread.currentThread().getName() + " get lock object at "
						+ String.valueOf(System.currentTimeMillis()) + lock);
				Thread.sleep(2000);
			} else {
				System.out.println("get lock failed");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

}
