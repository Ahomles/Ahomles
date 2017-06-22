package com.cn.javaFrame.common.util.dataConvert.beanutil.bean1;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("City")
public class City {
	@XStreamAlias("ADDRESS")
	private String address;
	@XStreamAlias("ADDADDRESS")
	private String addAddress;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddAddress() {
		return addAddress;
	}
	public void setAddAddress(String addAddress) {
		this.addAddress = addAddress;
	}
	@Override
	public String toString() {
		return "City [address=" + address + ", addAddress=" + addAddress + "]";
	}
	
	
}
