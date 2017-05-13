package com.cn.javaFrame.common.util.order.test;

import com.cn.javaFrame.common.util.order.Command;
import com.cn.javaFrame.common.util.order.SimpleRemoteControl;
import com.cn.javaFrame.common.util.order.commandImpl.GarageDoor;
import com.cn.javaFrame.common.util.order.commandImpl.GarageDoorOpenCommand;
import com.cn.javaFrame.common.util.order.commandImpl.Light;
import com.cn.javaFrame.common.util.order.commandImpl.LightOnCommand;

public class Test2 {
	public static void main(String[] args) {
		SimpleRemoteControl control=new SimpleRemoteControl();
		Light light=new Light();
		GarageDoor garageDoor=new GarageDoor();
		
		Command command=new LightOnCommand(light);
		Command command2=new GarageDoorOpenCommand(garageDoor);
		control.setCommand(command);
		control.buttonWasPressed();
		control.setCommand(command2);
		control.buttonWasPressed();
	}
}
