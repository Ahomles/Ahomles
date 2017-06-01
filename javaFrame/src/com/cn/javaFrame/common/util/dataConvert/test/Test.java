package com.cn.javaFrame.common.util.dataConvert.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
    	String key="OFFER_123_SV_456_AT_23";
    	String offerId=getPartOfKey(key,"OFFER");
    	System.out.println(offerId);
    	String serviceId = getPartOfKey(key,"SV");
    	System.out.println(serviceId);
        String attrId = getPartOfKey(key,"AT");
        System.out.println(attrId);
    	
    	
    		
	}
    private static String getPartOfKey(String key,String partionFlag){
        String s = "";
        Pattern p = Pattern.compile(partionFlag+"_\\d+");
        Matcher m = p.matcher(key);
        if(m.find()){
            s = m.group();
            s = s.replace(partionFlag + "_", "");
        }
        return s.toUpperCase();
    }

}
