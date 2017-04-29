package com.cn.javaFrame.common.util.builder.interfaces;


import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.bean.OrdCustData;




//构造器中管理方法
public interface OrdCustDataBuilder {
	
	public OrdCustDataBuilder setCustOrderId(String custOrderId);
	public OrdCustDataBuilder setCreateDate(Timestamp createDate);
	public OrdCustDataBuilder setState(Integer state);
	
	public OrdCustData builder() throws Exception;	
    public OrdBusiDataBuilder ordBusiDataBuilder() throws Exception;
}
