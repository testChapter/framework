package com.learn.lock.distributed;

import com.learn.lock.AbstractLock;
import com.learn.lock.distributed.resource.zookeeper.ZookeeperLockResource;

public class ZookeeperLock extends AbstractLock {

	public ZookeeperLock(ZookeeperLockResource resource) {
		this.lockResource = resource;
	}
}
