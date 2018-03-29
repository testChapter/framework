package com.learn.lock.local;

import com.learn.lock.AbstractLock;
import com.learn.lock.local.resource.LocalLockResource;

public class LocalStoreLock extends AbstractLock {

	public LocalStoreLock(LocalLockResource resource) {
		this.lockResource = resource;
	}

}
