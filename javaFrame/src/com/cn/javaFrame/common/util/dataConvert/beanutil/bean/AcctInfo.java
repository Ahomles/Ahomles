package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by xuxx3 on 2016/5/16.
 */
@XStreamAlias("ACCTINFO")
public class AcctInfo implements Serializable {

	/**
	 * 账户信息Pojo
	 */
	private static final long serialVersionUID = 1L;

	// 账户编号
	@XStreamAlias("ACCTID")
	@JSONField(name="ACCTID")
	public String acctId;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

}
