package com.learn.lock.distributed;

import com.learn.lock.AbstractLock;
import com.learn.lock.distributed.resource.redis.RedisLockResource;

public class RedisLock extends AbstractLock {
	
	public RedisLock(RedisLockResource resource) {
		this.lockResource = resource;
	}
	

}
