package com.cn.javaFrame.common.util.complex.adapter;

import com.cn.javaFrame.common.util.complex.interfaces.Goose;
import com.cn.javaFrame.common.util.complex.interfaces.Quackable;
import com.cn.javaFrame.common.util.complex.observer.Observable;
import com.cn.javaFrame.common.util.complex.observer.Observer;

public class GooseAdapter implements Quackable {
	public Goose goose;
	Observable observable;
	//将鹅适配成鸭子
	public GooseAdapter(Goose goose) {
		this.goose = goose;
		observable=new Observable(this);
	}


	@Override
	public void quack() {
		goose.honk();
		notifyObservers();
	}


	@Override
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}
}
