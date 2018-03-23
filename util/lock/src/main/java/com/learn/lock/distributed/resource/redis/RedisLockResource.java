package com.learn.lock.distributed.resource.redis;

import com.learn.lock.distributed.resource.AbstractDistributedLockResource;

public class RedisLockResource extends AbstractDistributedLockResource {

	@Override
	public boolean getLock(String lockKey, long waitTimeInMillisecond) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
