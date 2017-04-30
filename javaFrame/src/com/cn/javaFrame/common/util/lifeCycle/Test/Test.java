package com.cn.javaFrame.common.util.lifeCycle.Test;

import com.cn.javaFrame.common.util.lifeCycle.Lifecycle;
import com.cn.javaFrame.common.util.lifeCycle.LifecycleEvent;
import com.cn.javaFrame.common.util.lifeCycle.LifecycleListener;

public class Test {
	public static void main(String[] args) {
		Engine engine = new Engine();
		// 还可以给上面实现了Lifecycle接口的组件添加监听器
		engine.addLifecycleListener(new LifecycleListener() {
			@Override
			public void lifecycleEvent(LifecycleEvent event) {
				// 只关心AFTER_START事件
				if (Lifecycle.AFTER_START.equals(event.getType())) {
					System.out.println("监听到发动机启动了，轰轰轰。。。");
					// 这里还可以通过event.getLifecycle()获得engin实例对象，然后做一些业务操作
				} else if(Lifecycle.AFTER_STOP.equals(event.getType())) {
					// 这里可以继续判断其他类型的事件，然后做出处理
					System.out.println("监听到发动机停止了。。。");
				}
			}
		});
		Car car = new Car();
		car.setEngine(engine);
		car.addLifecycleListener(new LifecycleListener() {
			@Override
			public void lifecycleEvent(LifecycleEvent event) {
				if(Lifecycle.AFTER_START.equals(event.getType())) {
					System.out.println("监听到桑塔拉启动了，滴滴滴。。。。");
					// 这里还可以通过event.getLifecycle()获得engin实例对象，然后做一些业务操作
				} else if (Lifecycle.AFTER_STOP.equals(event.getType())) {
					System.out.println("监听到桑塔拉停止了,下车吧。。。");
				}
			}
		});
		
		car.run();
		
		car.shutDown();
		
	}
}
