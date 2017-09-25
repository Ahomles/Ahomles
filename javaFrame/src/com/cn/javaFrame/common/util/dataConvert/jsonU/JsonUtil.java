package com.cn.javaFrame.common.util.dataConvert.jsonU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.util.JSONBuilder;
import net.sf.json.util.JSONUtils;

public class JsonUtil {
	/**
	 * 将jascript类型的array转换成的json字符串转换为java的List数据结构.如果js数组中某个元素为Array,则对应转换为java.util.List.如果为Object,则对应转换为Map
	 * @param pString
	 * @return
	 * @throws Exception
	 */
	public static List getListFromJsArray(String pString) throws Exception{
 	    List reList = new ArrayList();
		if(StringUtils.isNotBlank(pString)){
			if(!JSONUtils.mayBeJSON(pString)){
				//输入参数字符串不符合JSON规范.
				throw new Exception("输入参数字符串不符合JSON规范");
			}
			JSONArray jArray = JSONArray.fromString(pString);
			for (int i = 0; i < jArray.length(); i++) {
				if(JSONUtils.isObject(jArray.get(i))){
					reList.add(getMapFromJsObject(((JSONObject)jArray.get(i)).toString()));
				}
				else{
					reList.add(jArray.get(i));
				}
			}
			
		
			
		}
		return reList;
		
	}
	/**
	 * 将js对象中的Object转换的JSON字符串转换为java的Map对象.如果js中某个对象是Array.则转换为java.util.List;如果是Object.则转换为java.util.Map;
	 * @param pString
	 * @return
	 * @throws Exception
	 */
	public static Map getMapFromJsObject(String pString) throws Exception{
		Map reMap = new HashMap();
		if(StringUtils.isNotBlank(pString)){
			if(!JSONUtils.mayBeJSON(pString)){
				//输入参数字符串不符合JSON规范.
				throw new Exception("输入参数字符串不符合JSON规范");
			}
			JSONObject jObject = JSONObject.fromString(pString);
			if(!jObject.isNullObject() && !jObject.isEmpty()){
				for(Iterator i=jObject.keys();i.hasNext();){
					String key = (String)i.next();
					if(JSONUtils.isArray(jObject.get(key))){
						reMap.put(key, JSONArray.toList((JSONArray)jObject.get(key),HashMap.class));
					}
					else if(JSONUtils.isObject(jObject.get(key))){
						reMap.put(key,getMapFromJsObject(((JSONObject)jObject.get(key)).toString()));
					}
					else{
						reMap.put(key, jObject.get(key));
					}
					
				}
			}
			
			
		}
		return reMap;
	}
	
	/**
	 * 将maps对象转换为json字符串
	 * @param pMap
	 * @return
	 * @throws Exception
	 */
	public static String getJsonFromMap(Map pMap) throws Exception{
		JSONObject jObject = JSONObject.fromMap(pMap);
		return jObject.toString();
	}
	
}
