package com.cn.javaFrame.common.util.lifeCycle;

public class LifecycleEvent {
	private Lifecycle lifeCycle;
	private String type;
	private Object data;
	public LifecycleEvent(Lifecycle lifeCycle, String type, Object data) {
		this.lifeCycle = lifeCycle;
		this.type = type;
		this.data = data;
	}
	public Lifecycle getLifeCycle() {
		return lifeCycle;
	}
	public void setLifeCycle(Lifecycle lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
