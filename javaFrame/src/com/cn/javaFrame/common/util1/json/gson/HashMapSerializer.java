package com.cn.javaFrame.common.util1.json.gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class HashMapSerializer implements JsonSerializer<HashMap<String,Object>>{

	public JsonElement serialize(HashMap<String,Object> paramT, Type paramType,
			JsonSerializationContext paramJsonSerializationContext) {
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").create();
		
		JsonObject obj = new JsonObject();
		Map<String,String> types = new HashMap<String,String>();
		for(Entry<String,Object> entry : paramT.entrySet()){
			obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()));
			Object value = entry.getValue();
			types.put(entry.getKey(), value==null?"@N@U@L@L@":value.getClass().getName());
		}
		obj.add("@MapType@", gson.toJsonTree(types));
		return obj;
	}
}
