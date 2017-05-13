package com.cn.javaFrame.common.util.order.test;

import com.cn.javaFrame.common.util.order.Command;
import com.cn.javaFrame.common.util.order.SimpleRemoteControl;
import com.cn.javaFrame.common.util.order.commandImpl.Light;
import com.cn.javaFrame.common.util.order.commandImpl.LightOnCommand;

public class Test1 {
	public static void main(String[] args) {
		SimpleRemoteControl control=new SimpleRemoteControl();
		Light light=new Light();
		Command command=new LightOnCommand(light);
		
		control.setCommand(command);
		
		control.buttonWasPressed();
	}
}
