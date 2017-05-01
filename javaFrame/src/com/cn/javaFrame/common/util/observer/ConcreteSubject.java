package com.cn.javaFrame.common.util.observer;

import java.util.Vector;

public class ConcreteSubject implements ISubject {
	Vector<IObserver> observers=new Vector<IObserver>();
	String state="1";
	@Override
	public void attach(IObserver observer) {
		observers.addElement(observer);
	}

	@Override
	public void detach(IObserver observer) {
		observers.removeElement(observer);
	}

	@Override
	public void inform() {
		Event evt=new Event();
		for(IObserver obs:observers){
			obs.update(evt);
		}
	}

	public void setState(String state){
		this.state=state;
	}
	@Override
	public String getState() {
		return state;
	}

}
