package com.cn.javaFrame.common.util.observer.Test;

import com.cn.javaFrame.common.util.observer.Event;
import com.cn.javaFrame.common.util.observer.IObserver;
import com.cn.javaFrame.common.util.observer.ISubject;

public class ObserverImpl2 implements IObserver{
	private ISubject subject;
	public ObserverImpl2(ISubject subject) {
		this.subject=subject;
	}
	@Override
	public void update(Event evt) {
		System.out.println("=====更新2");
		System.out.println("state="+subject.getState());
	}

}
