package com.cn.javaFrame.common.util.observer;

public interface ISubject {
	void attach(IObserver observer);
	void detach(IObserver observer);
	void inform();
	String getState();
	void  setState(String state);
}
