package com.learn.lock.local.resource;

import com.learn.lock.LockResource;

public class LocalLockResource implements LockResource {

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
