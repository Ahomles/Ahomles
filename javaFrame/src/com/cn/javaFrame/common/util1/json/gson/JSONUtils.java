package com.cn.javaFrame.common.util1.json.gson;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils {
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
			.registerTypeAdapter(java.util.Date.class, new DateDeserializer())
            .registerTypeAdapter(HashMap.class, new HashMapConverter())
            .create();
	
	public static <T> T json2Obj(String json,Class<T> classOfT){
		return (T)gson.fromJson(json, classOfT);
	}
	
	public static String obj2JSon(Object obj){
		return gson.toJson(obj);
	}
}
