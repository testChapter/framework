package com.learn.lock.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.lock.distributed.RedisLock;
import com.learn.lock.distributed.ZookeeperLock;
import com.learn.lock.distributed.resource.redis.RedisLockResource;
import com.learn.lock.distributed.resource.zookeeper.ZookeeperLockResource;
import com.learn.lock.local.LocalStoreLock;
import com.learn.lock.local.resource.LocalLockResource;

@Configuration
public class LockStarter {

	@Bean
	@ConditionalOnProperty(name = "lock.redis.enabled", havingValue = "true")
	RedisLock redisLock(RedisLockResource lockResource) {
		return new RedisLock(lockResource);
	}
	
	@Bean
	@ConditionalOnProperty(name = "lock.zookeeper.enabled", havingValue = "true")
	ZookeeperLock zookeeperLock(ZookeeperLockResource lockResource) {
		return new ZookeeperLock(lockResource);
	}
	
	@Bean
	@ConditionalOnProperty(name = "lock.local.enabled", havingValue = "true")
	LocalStoreLock localStoreLock(LocalLockResource lockResource) {
		return new LocalStoreLock(lockResource);
	}

}
