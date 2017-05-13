package com.cn.javaFrame.common.util.complex.observer;


public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
