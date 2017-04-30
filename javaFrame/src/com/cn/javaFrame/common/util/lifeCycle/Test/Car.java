package com.cn.javaFrame.common.util.lifeCycle.Test;

import com.cn.javaFrame.common.util.lifeCycle.Lifecycle;
import com.cn.javaFrame.common.util.lifeCycle.LifecycleListener;
import com.cn.javaFrame.common.util.lifeCycle.LifecycleSupport;

public class Car implements Lifecycle {
	private LifecycleSupport lifecycle = new LifecycleSupport(this);
	private Engine engine;
	

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

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
		// 先初始化其他组件
		if (engine != null && engine instanceof Lifecycle) {
			((Lifecycle) engine).start();
		}
		System.out.println("桑塔拉正在启动...");
		lifecycle.fireLifecycleEvent(Lifecycle.AFTER_START, null);
	}

	@Override
	public void stop() {
		lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_STOP, null);
		// 先停止其他组件
		if (engine != null && engine instanceof Lifecycle) {
			((Lifecycle) engine).stop();
		}
		System.out.println("桑塔拉正在停止...");
		lifecycle.fireLifecycleEvent(Lifecycle.AFTER_STOP, null);
	}
	
	public void run(){
		start();
		System.out.println("====汽车启动成功。。。。。。。。");
	}
	public void shutDown(){
		stop();
		System.out.println("=====汽车停止下来了。。。。。。。。");
	}

}
