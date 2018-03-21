package com.learn.lock.distributed.resource;

import com.learn.lock.LockResource;

public abstract class AbstractDistributedLockResource implements LockResource {
	
	@Override
	public boolean getLock(String lockKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean unLock(String lockKey) {
		// TODO Auto-generated method stub
		return null;
	}
}
