package com.cn.javaFrame.common.util.lifeCycle;

public interface Lifecycle {
	public static final String BEFORE_START="before_start";
	public static final String AFTER_START="after_start";
	public static final String BEFORE_STOP="before_stop";
	public static final String AFTER_STOP="after_stop";
	
	void addLifecycleListener(LifecycleListener listener);
	
	LifecycleListener[] getLifeCycleListeners();
	
	void start();
	
	void stop();
	
}
