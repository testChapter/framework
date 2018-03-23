package com.learn.lock;

public interface LockResource {

	boolean getLock(String lockKey);

	boolean getLock(String lockKey, long waitTimeInMillisecond);

	Boolean unLock(String lockKey);

}
