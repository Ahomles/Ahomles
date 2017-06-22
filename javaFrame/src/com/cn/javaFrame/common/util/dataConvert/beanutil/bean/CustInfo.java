package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by xuxx3 on 2016/5/13.
 */
@XStreamAlias("CUSTINFO")
public class CustInfo implements Serializable {

	/**
	 * 客户信息
	 */
	private static final long serialVersionUID = 1L;

	// 客户编号
	@XStreamAlias("CUSTID")
	@JSONField(name="CUSTID")
	public String custId;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	
}
