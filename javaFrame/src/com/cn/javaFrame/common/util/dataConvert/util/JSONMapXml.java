package com.cn.javaFrame.common.util.dataConvert.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONMapXml {
	/**
	 * 简单的Map2Bean,1.没有考虑Map中的value都是字符串2.没有考虑对像属性
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object fromMap2Bean(Map<String,Object> map,Class<?> beanClass) throws Exception{
		if(map.isEmpty()){
			return null;
		}
		Object obj=beanClass.newInstance();
		Field[] fields = obj.getClass().getDeclaredFields();   
		
		for (Field field : fields) {    
            int mod = field.getModifiers();    
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                continue;    
            }    
            field.setAccessible(true);    
            field.set(obj, map.get(field.getName()));   
        }   
		return obj;
	}
	/**
	 * 简单的Bean2Map,1.没有考虑Map中的value都是字符串2.没有考虑对像属性
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> fromBean2Map(Object obj) throws Exception{
		if(obj == null){    
            return null;    
        }   
  
        Map<String, Object> map = new HashMap<String, Object>();    
  
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            map.put(field.getName(), field.get(obj));  
        }    
        return map;  
	}
	
	public static Map fromXML2Map(String xmlStr){
		try {
			Document document=DocumentHelper.parseText(xmlStr);
			Element rootElement=document.getRootElement();
			if(null==rootElement){
				throw new Exception("根元素为null！");
			}
			Map map=new HashMap();
			Element element;
			for(Iterator it = rootElement.elementIterator(); it.hasNext(); map.put(element.getName(), element.getData().toString()))
				element = (Element)it.next();
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static String fromMap2XML(){
		
		
		
		return null;
	}
	
	public static String fromMap2JSON(Map map) {
		return JSON.toJSONString(map);
	}

	/**
	 * JSON字符串转化为Map对象
	 = =========================================================
	   {	
	  		"id":123,
	  		"name":{ "firstName":"John" , "lastName":"Doe"},
			"employees": [
				{ "firstName":"John" , "lastName":"Doe" },
				{ "firstName":"Anna" , "lastName":"Smith" },
				{ "firstName":"Peter" , "lastName":"Jones" }
			],
			"data":"hello"
	   }
	 = ==========================================================
	 * @param jsonStr
	 * @return
	 */
	public static Map fromJSON2Map(String jsonStr) {
		HashMap jsonMap = JSON.parseObject(jsonStr, HashMap.class);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		for (Iterator iter = jsonMap.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			if (jsonMap.get(key) instanceof JSONObject) {
				JSONObject jsonObject = (JSONObject) jsonMap.get(key);
				Map map = handleJSONObeject(jsonObject);
				resultMap.put(key, map);
			} else if (jsonMap.get(key) instanceof JSONArray) {
				JSONArray jsonArray = (JSONArray) jsonMap.get(key);
				List list = handleJSONArray(jsonArray);
				resultMap.put(key, list);
			} else {
				resultMap.put(key, jsonMap.get(key));
			}
		}
		return resultMap;
	}

	/**
	 * 处理JSON对象转化为一个新的Map
	 = =============================================
	   {
	   		"name"：{ "firstName":"John" , "lastName":"Doe"}
	   },
	   var name = { "firstName":"John" , "lastName":"Doe"};
	 = =============================================
	 * @param jsonObject
	 * @return
	 */
	private static HashMap<String, Object> handleJSONObeject(
			JSONObject jsonObject) {
		HashMap map = new HashMap<String, Object>();
		for (Map.Entry entry : jsonObject.entrySet()) {
			if (entry.getValue() instanceof JSONObject) {
				JSONObject tJsonObject = (JSONObject) entry.getValue();
				map.put((String) entry.getKey(), handleJSONObeject(tJsonObject));
			} else if (entry.getValue() instanceof JSONArray) {
				map.put((String) entry.getKey(),
						handleJSONArray((JSONArray) entry.getValue()));
			} else {
				map.put((String) entry.getKey(), entry.getValue());
			}
		}
		return map;
	}

	/**
	 * 处理JSON数组，将JSON数组转化为List<Map>
	 = ===========================================================
	   {
			"employees": [
				{ "firstName":"John" , "lastName":"Doe" },
				{ "firstName":"Anna" , "lastName":"Smith" },
				{ "firstName":"Peter" , "lastName":"Jones" }
			]
	   },
	   var employees = [
			{ "firstName":"Bill" , "lastName":"Gates" },
			{ "firstName":"George" , "lastName":"Bush" },
			{ "firstName":"Thomas" , "lastName": "Carter" }
	   ];
	 = ===========================================================
	 * @param jsonArray
	 * @return
	 */
	private static List<HashMap<String, Object>> handleJSONArray(
			JSONArray jsonArray) {
		List list = new ArrayList();
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			HashMap map = new HashMap<String, Object>();
			for (Map.Entry entry : jsonObject.entrySet()) {
				if (entry.getValue() instanceof JSONObject) {
					JSONObject tJsonObject = (JSONObject) entry.getValue();
					map.put((String) entry.getKey(),
							handleJSONObeject(tJsonObject));
				} else if (entry.getValue() instanceof JSONArray) {
					map.put((String) entry.getKey(),
							handleJSONArray((JSONArray) entry.getValue()));
				} else {
					map.put((String) entry.getKey(), entry.getValue());
				}
			}
			list.add(map);
		}
		return list;
	}
	
	
	
}
