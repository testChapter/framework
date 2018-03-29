package com.learn.lock.local.resource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import com.learn.lock.LockResource;

public class LocalLockResource implements LockResource {

	private static Map<String, ReentrantLock> lockObjectMap = new ConcurrentHashMap<>();

	@Override
	public boolean getLock(String lockKey) {
		ReentrantLock lock = new ReentrantLock(true);
		ReentrantLock mapObject = lockObjectMap.putIfAbsent(lockKey, lock);
		if (mapObject == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean unLock(String lockKey) {
		try {
			ReentrantLock mapObject = lockObjectMap.get(lockKey);
			if (mapObject.isHeldByCurrentThread()) {
				mapObject.unlock();
				if (mapObject.getQueueLength() == 0) {
					lockObjectMap.remove(lockKey);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean getLock(String lockKey, long waitTimeInMillisecond) {
		ReentrantLock object = new ReentrantLock(true);
		ReentrantLock mapObject = lockObjectMap.putIfAbsent(lockKey, object);
		if (mapObject == null) {
			return object.tryLock();
		} else {
			try {
				return mapObject.tryLock(waitTimeInMillisecond, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public static void main(String[] args) {
		final String lockKey = "getKey";
		LocalLockResource lock = new LocalLockResource();
		CountDownLatch latch = new CountDownLatch(3);
		new Thread(new Runnable() {
			@Override
			public void run() {
				latch.countDown();
				try {
					latch.await();
					if (lock.getLock(lockKey, 300)) {
						Thread.sleep(200);
						lock.unLock(lockKey);
					} else {
						System.out.println("Thread " + Thread.currentThread().getName() + " get lock failed");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "T1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				latch.countDown();
				try {
					latch.await();
					if (lock.getLock(lockKey, 300)) {
						Thread.sleep(200);
						lock.unLock(lockKey);
					} else {
						System.out.println("Thread " + Thread.currentThread().getName() + " get lock failed");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "T2").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				latch.countDown();
				try {
					latch.await();
					if (lock.getLock(lockKey, 300)) {
						Thread.sleep(200);
						lock.unLock(lockKey);
					} else {
						System.out.println("Thread " + Thread.currentThread().getName() + " get lock failed");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "T3").start();
	}

}
