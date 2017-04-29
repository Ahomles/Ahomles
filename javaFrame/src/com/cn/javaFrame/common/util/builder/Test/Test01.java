package com.cn.javaFrame.common.util.builder.Test;

import java.sql.Timestamp;

import com.cn.javaFrame.common.util.builder.DefaultOrdCustDataBuilder;
import com.cn.javaFrame.common.util.builder.bean.OrdCustData;
import com.cn.javaFrame.common.util.builder.interfaces.OrdBusiDataBuilder;
import com.cn.javaFrame.common.util.builder.interfaces.OrdCustDataBuilder;
import com.cn.javaFrame.common.util.builder.interfaces.OrdUserBuilder;

public class Test01 {
	public static void main(String[] args) throws Exception {
		OrdCustDataBuilder ordCustDataBuilder=new DefaultOrdCustDataBuilder();
		createOrdCustBuilder(ordCustDataBuilder);//构建ordCust
		createOrdBusiDataBuilder(ordCustDataBuilder);//构建ordBusiData
		createOrdBusiDataBuilder(ordCustDataBuilder);//构建ordBusiData
		createOrdBusiDataBuilder(ordCustDataBuilder);//构建ordBusiData
		OrdCustData ordCustData=ordCustDataBuilder.builder();//构建生成大对象
		System.out.println(ordCustData);
	}
	public static void createOrdCustBuilder(OrdCustDataBuilder ordCustDataBuilder){
		Timestamp currentTime=new Timestamp(System.currentTimeMillis());
		ordCustDataBuilder.setCreateDate(currentTime);
		ordCustDataBuilder.setCustOrderId("123456");
	}
	public static void createOrdBusiDataBuilder(OrdCustDataBuilder ordCustDataBuilder) throws Exception{
		OrdBusiDataBuilder ordBusiDataBuilder=ordCustDataBuilder.ordBusiDataBuilder();
		createOrdBusiBuilder(ordBusiDataBuilder);//构建ordBusi
		createOrdUserBuilder(ordBusiDataBuilder);//构建ordUser
		createOrdUserBuilder(ordBusiDataBuilder);//构建ordUser
	}
	public static void createOrdBusiBuilder(OrdBusiDataBuilder ordBusiDataBuilder) throws Exception{
		Timestamp currentTime=new Timestamp(System.currentTimeMillis());
		ordBusiDataBuilder.setCreateDate(currentTime);
		ordBusiDataBuilder.setBusiOrderId("1111111");
	}
	public static void createOrdUserBuilder(OrdBusiDataBuilder ordBusiDataBuilder) throws Exception{
		OrdUserBuilder ordUserBuilder=ordBusiDataBuilder.ordUserBuilder();
		Timestamp currentTime=new Timestamp(System.currentTimeMillis());
		ordUserBuilder.setCreateDate(currentTime);
		ordUserBuilder.setUserOrderId("66666666");
	}
}
