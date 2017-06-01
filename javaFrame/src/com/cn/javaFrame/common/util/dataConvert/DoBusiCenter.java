package com.cn.javaFrame.common.util.dataConvert;

import java.util.HashMap;
import java.util.Map;

import com.ai.common.csf.util.JsonUtil;
import com.cn.javaFrame.common.comUtil.StringUtil;
import com.cn.javaFrame.common.util.dataConvert.util.JSONMapXml;

public class DoBusiCenter implements IDoBusi{

	@Override
	public String submit4JSON(String busiParams) throws Exception {
		/**
		 * 缺少对异常的处理，和对日志添加
		 */
		if(StringUtil.isEmpty(busiParams)){
			throw new Exception("The Params of busiParams is Empty!");
		}
		System.out.println("\n 转入的报文："+busiParams);
		Map busiParamsMap=null;
		Map rtnInfoMap=null;
		try{
			busiParamsMap = JSONMapXml.fromJSON2Map(busiParams);//JSON串转Map
			
			long startTime = System.currentTimeMillis();
			/**
			 * dobusi受理业务
			 */
			rtnInfoMap=dobusi(busiParamsMap);//里面什么也没有实现
			
			long endTime = System.currentTimeMillis();
			System.out.println("业务用时：" +(endTime-startTime));
			
			//TODO 保存操作日志
			//saveParamOperLog(busiParams, rtnInfoMap, null)
			if (rtnInfoMap != null) {
				String rtnStr =  JSONMapXml.fromMap2JSON(rtnInfoMap);//Map转化为JSON
				System.out.println("\n 输出的报文："+rtnStr);
				return rtnStr;
			}
			return null;
		}catch (Exception e) {
			String msg = "";
			if(null != e.getCause()){
				msg = e.getCause().getLocalizedMessage();
			}else{
				msg = e.getMessage();
			}
			//TODO 保存异常日志
			//saveParamOperLog(busiParams, null, msg);
			System.out.println("\n 错误信息："+msg);
			throw new Exception(msg);//
		}
	}

	@Override
	public Map submit4Map(Map busiMap) {
		return null;
	}

	@Override
	public String submit4Xml(String busiXml) {
		return null;
	}

	private Map dobusi(Map busiMap){
		Map map=new HashMap();
		return map;
	}
		

	
}
