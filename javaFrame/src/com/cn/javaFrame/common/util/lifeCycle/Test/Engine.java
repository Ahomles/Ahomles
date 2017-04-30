package com.cn.javaFrame.common.util.lifeCycle.Test;

import com.cn.javaFrame.common.util.lifeCycle.Lifecycle;
import com.cn.javaFrame.common.util.lifeCycle.LifecycleListener;
import com.cn.javaFrame.common.util.lifeCycle.LifecycleSupport;

public class Engine implements Lifecycle{
	 private LifecycleSupport lifecycle = new LifecycleSupport(this);  
	
	@Override
	public void addLifecycleListener(LifecycleListener listener) {
		lifecycle.addLifecycleListener(listener);
	}

	@Override
	public LifecycleListener[] getLifeCycleListeners() {
		lifecycle.getLifeCycleListeners();
		return null;
	}

	@Override
	public void start() {
		lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_START, null);
		System.out.println("启动发动机器");
		lifecycle.fireLifecycleEvent(Lifecycle.AFTER_START, null);
	}

	@Override
	public void stop() {
		lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_STOP, null);
		System.out.println("停止发动机器");
		lifecycle.fireLifecycleEvent(Lifecycle.AFTER_STOP, null);		
	}

}
