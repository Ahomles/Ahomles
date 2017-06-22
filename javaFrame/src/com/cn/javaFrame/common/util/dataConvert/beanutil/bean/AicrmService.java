package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("AICRMSERVICE")
public class AicrmService   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("PUBINFO")
	@JSONField(name="PUBINFO")
	private PubInfo pubInfo = new PubInfo();
	@XStreamAlias("REQUEST")
	@JSONField(name="REQUEST")
	private Request request = new Request();

	public PubInfo getPubInfo() {
		return pubInfo;
	}

	public void setPubInfo(PubInfo pubInfo) {
		this.pubInfo = pubInfo;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
}
