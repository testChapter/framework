package com.learn.lock.local.resource;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		CountDownLatch latch = new CountDownLatch(3);
		new TestReentrantLock(lock, latch, "t1").start();
		new TestReentrantLock(lock, latch, "t2").start();
		new TestReentrantLock(lock, latch, "t3").start();
	}

	public static class TestReentrantLock extends Thread {

		private Lock lock;
		private CountDownLatch latch;

		public TestReentrantLock(Lock lock, CountDownLatch latch, String name) {
			super.setName(name);
			this.lock = lock;
			this.latch = latch;
		}

		@Override
		public void run() {
			latch.countDown();
			try {
				latch.await();
				System.out.println("Thread " + Thread.currentThread().getName() + " start trylock at "
						+ String.valueOf(System.currentTimeMillis()));
				if (lock.tryLock(800, TimeUnit.MILLISECONDS)) {
					System.out.println("Thread " + Thread.currentThread().getName() + " trylock success at "
							+ String.valueOf(System.currentTimeMillis()));
					lock.lock();
					System.out.println("Thread " + Thread.currentThread().getName() + " lock success at "
							+ String.valueOf(System.currentTimeMillis()));
					Thread.sleep(200);
					System.out.println("Thread " + Thread.currentThread().getName() + " unlock success at "
							+ String.valueOf(System.currentTimeMillis()));
					lock.unlock();
				}else {
					System.out.println("Thread " + Thread.currentThread().getName() + " trylock failed at "
							+ String.valueOf(System.currentTimeMillis()));
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public Lock getLock() {
			return lock;
		}

		public void setLock(Lock lock) {
			this.lock = lock;
		}

		public CountDownLatch getLatch() {
			return latch;
		}

		public void setLatch(CountDownLatch latch) {
			this.latch = latch;
		}

	}

}
