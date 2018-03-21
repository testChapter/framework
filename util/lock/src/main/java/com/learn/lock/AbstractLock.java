package com.learn.lock;

public abstract class AbstractLock implements Lock {
	
	protected LockResource lockResource;
	
	@Override
	public Boolean getLock(String lockKey) {
		return lockResource.getLock(lockKey);
	}

	@Override
	public Boolean unLock(String lockKey) {
		return lockResource.unLock(lockKey);
	}

	public LockResource getLockResource() {
		return lockResource;
	}

	public void setLockResource(LockResource lockResource) {
		this.lockResource = lockResource;
	}

}
