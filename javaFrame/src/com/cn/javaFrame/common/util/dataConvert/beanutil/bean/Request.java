package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("REQUEST")
public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("BUSICODE")
	@JSONField(name="BUSICODE")
	public String busiCode;
	@XStreamAlias("BUSIINFO")
	@JSONField(name="BUSIINFO")
	public BusiInfo busiInfo;
	
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public BusiInfo getBusiInfo() {
		return busiInfo;
	}
	public void setBusiInfo(BusiInfo busiInfo) {
		this.busiInfo = busiInfo;
	}
	
}
