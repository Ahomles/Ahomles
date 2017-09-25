package com.cn.javaFrame.common.util1.json;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class DateDeserializer implements JsonDeserializer<java.util.Date> 
{
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	
	public java.sql.Date deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext jsondeserializationcontext) throws JsonParseException {
		   if (!(json instanceof JsonPrimitive))
	   		{
		      throw new JsonParseException("The date should be a string value");
		    }
	   		try {
	   			Date date = df.parse(json.getAsString());
				return new java.sql.Date(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		throw new IllegalArgumentException(super.getClass() + " cannot deserialize to " + typeOfT);
	}

}
