package com.cn.javaFrame.common.util.observer.Test;

import javax.print.attribute.standard.MediaSize.ISO;

import com.cn.javaFrame.common.util.observer.ConcreteSubject;
import com.cn.javaFrame.common.util.observer.IObserver;
import com.cn.javaFrame.common.util.observer.ISubject;

public class Test {
	public static void main(String[] args) {
		ISubject subject=new ConcreteSubject();
		
		IObserver obs1=new ObserverImpl1(subject);
		IObserver obs2=new ObserverImpl2(subject);
		subject.attach(obs1);
		subject.attach(obs2);
		subject.setState("3");
		subject.inform();
	}
}
