package com.learn.lock;

public interface Lock {

	Boolean getLock(String lockKey);

	Boolean unLock(String lockKey);

}
