package com.cn.javaFrame.common.util.observer.Test;

import com.cn.javaFrame.common.util.observer.Event;
import com.cn.javaFrame.common.util.observer.IObserver;
import com.cn.javaFrame.common.util.observer.ISubject;

public class ObserverImpl1 implements IObserver{
	private ISubject subject;
	public ObserverImpl1(ISubject subject) {
		this.subject=subject;
	}
	@Override
	public void update(Event evt) {
		System.out.println("=====更新1");
		System.out.println(subject.getState());
	}

}
