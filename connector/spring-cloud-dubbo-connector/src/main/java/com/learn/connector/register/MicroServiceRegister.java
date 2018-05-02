package com.learn.connector.register;


import org.springframework.context.SmartLifecycle;

public class MicroServiceRegister implements SmartLifecycle  {

	@Override
	public void start() {
		
	}

	@Override
	public void stop() {
		
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return false;
	}

	@Override
	public void stop(Runnable callback) {
		
	}

	
	//InstanceInfoReplicator

}
