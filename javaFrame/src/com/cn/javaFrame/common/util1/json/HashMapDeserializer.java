package com.cn.javaFrame.common.util1.json;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class HashMapDeserializer implements JsonDeserializer<HashMap<String,Object>>{

	public HashMap<String,Object> deserialize(JsonElement paramJsonElement, Type paramType,
			JsonDeserializationContext paramJsonDeserializationContext)
			throws JsonParseException {
		
		Gson gson = new GsonBuilder().registerTypeAdapter(java.sql.Date.class, new DateDeserializer()).create();
		
		JsonObject obj = (JsonObject)paramJsonElement;
		Map types = gson.fromJson(obj.get("@MapType@"),Map.class);
		obj.remove("@MapType@");
		HashMap<String,Object> map = new HashMap<String,Object>();
		for(Entry<String,JsonElement> entry : obj.entrySet()){
			String clazz = String.valueOf(types.get(entry.getKey()));
			try {
				JsonElement value = entry.getValue();
				map.put(entry.getKey(), "@N@U@L@L@".equals(String.valueOf(value))?null:gson.fromJson(value, Class.forName(clazz)));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

}
