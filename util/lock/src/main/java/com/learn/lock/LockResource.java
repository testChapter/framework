package com.learn.lock;

public interface LockResource {

	boolean getLock(String lockKey);

	Boolean unLock(String lockKey);

}
