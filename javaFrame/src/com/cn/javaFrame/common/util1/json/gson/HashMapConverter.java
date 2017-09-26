package com.cn.javaFrame.common.util1.json.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpwq on 2017/4/6.
 */
public class HashMapConverter implements JsonSerializer<HashMap<String,Object>>,JsonDeserializer<HashMap<String,Object>>{

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
    							 .registerTypeAdapter(java.sql.Date.class, new DateDeserializer())
    							 .registerTypeAdapter(HashMap.class, new HashMapDeserializer())
    							 .registerTypeAdapter(HashMap.class, new HashMapSerializer())
    							 .create();
    public HashMap<String,Object> deserialize(JsonElement paramJsonElement, Type paramType,
                                              JsonDeserializationContext paramJsonDeserializationContext)
            throws JsonParseException {
    	
        JsonObject obj = (JsonObject)paramJsonElement;
        Map types = gson.fromJson(obj.get("@MapType@").toString(),Map.class);
        obj.remove("@MapType@");
        HashMap<String,Object> map = new HashMap<String,Object>();
        for(Map.Entry<String,JsonElement> entry : obj.entrySet()){
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
    public JsonElement serialize(HashMap<String,Object> paramT, Type paramType,
                                 JsonSerializationContext paramJsonSerializationContext) {
        JsonObject obj = new JsonObject();
        Map<String,String> types = new HashMap<String,String>();
        for(Map.Entry<String,Object> entry : paramT.entrySet()){
            obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()));
            Object value = entry.getValue();
            types.put(entry.getKey(), value==null?"@N@U@L@L@":value.getClass().getName());
        }
        obj.add("@MapType@", new GsonBuilder().create().toJsonTree(types));
        return obj;
    }

}
