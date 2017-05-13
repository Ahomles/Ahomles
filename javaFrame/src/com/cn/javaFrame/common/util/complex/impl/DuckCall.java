package com.cn.javaFrame.common.util.complex.impl;

import com.cn.javaFrame.common.util.complex.interfaces.Quackable;
import com.cn.javaFrame.common.util.complex.observer.Observable;
import com.cn.javaFrame.common.util.complex.observer.Observer;

public class DuckCall implements Quackable {
	Observable observable;
	public DuckCall() {
		this.observable = new Observable(this);
	}
	//委托类即代理
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
	@Override
	public void quack() {
		System.out.println("Kwak");
		notifyObservers();
	}

}
