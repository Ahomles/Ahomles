package com.cn.javaFrame.common.util1.json;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by zpwq on 2017/4/6.
 */
public class StringConverter implements JsonSerializer<String>,
        JsonDeserializer<String> {
    public JsonElement serialize(String src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        if (src == null) {
            return new JsonPrimitive("@N@U@L@L@");
        } else if ("".equals(src)) {
            return new JsonPrimitive("@K@O@N@G@");
        } else {
            return new JsonPrimitive(String.valueOf(src));
        }
    }
    public String deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context)
            throws JsonParseException {
        String src = json.getAsJsonPrimitive().getAsString();
        if("@N@U@L@L@".equals(src)){
            return null;
        }else if("@K@O@N@G@".equals(src)){
            return "";
        }else{
            return src;
        }
    }
}