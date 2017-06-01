package com.cn.javaFrame.common.util.dataConvert.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.javaFrame.common.util.dataConvert.util.JSONMapXml;

public class MapTest {
	public static void main(String[] args) {
		Map busiMap=new HashMap();
		Map pubParamMap=new HashMap();
		Map busiParamMap =new HashMap();
		busiMap.put("PUB_PARAM", pubParamMap);
		busiMap.put("BUSI_PARAM", busiParamMap);
		createPubMap(pubParamMap);
		createbusiMap(busiParamMap);
		
		String jsonStr=JSONMapXml.fromMap2JSON(busiMap);
		System.out.println(jsonStr);
		
		Map newMap=JSONMapXml.fromJSON2Map(jsonStr);
		System.out.println(newMap);
		
	}
	public static void createPubMap(Map pubParamMap){
		pubParamMap.put("sys_id", 123);
		pubParamMap.put("sys_age", 34);
		pubParamMap.put("sys_name", "znb");
	}
	public static void createbusiMap(Map busiParamMap){
		busiParamMap.put("ADDRESS", "漯河市");
		
		Map ruleList=new HashMap();
		List list=new ArrayList();
		busiParamMap.put("RULELIST",ruleList);
		ruleList.put("RULEINFO", list);
		
		Map ruleInfo=new HashMap();
		Map ruleInfo2=new HashMap();
		list.add(ruleInfo);
		list.add(ruleInfo2);
		
		ruleInfo.put("list11", "list11");
		ruleInfo.put("list12", "list12");
		ruleInfo.put("list13", "list13");
		ruleInfo2.put("list21", "list21");
		ruleInfo2.put("list22", "list22");
		ruleInfo2.put("list23", "list23");
	}
}
