package com.learn.lock.local.resource;

import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.learn.lock.LockResource;

public class LocalLockResource implements LockResource {

	private static Map<String, Object> lockObjectMap = new ConcurrentHashMap<>();

	@Override
	public boolean getLock(String lockKey) {
		Object object = new Object();
		Object mapObject = lockObjectMap.putIfAbsent(lockKey, object);
		if (mapObject == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean unLock(String lockKey) {
		try {
			Object mapObject = lockObjectMap.get(lockKey);
			mapObject.notifyAll();
			mapObject = null;
			lockObjectMap.remove(lockKey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean getLock(String lockKey, long waitTimeInMillisecond) {
		boolean flag = true;
		Object object = new Object();
		Object mapObject = lockObjectMap.putIfAbsent(lockKey, object);
		if (mapObject == null) {
			return true;
		} else {
			synchronized (mapObject) {
				
			}
		}
		try {
			
			object.wait(waitTimeInMillisecond);
			return false;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
