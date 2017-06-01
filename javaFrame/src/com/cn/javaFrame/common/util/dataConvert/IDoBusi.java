package com.cn.javaFrame.common.util.dataConvert;

import java.util.Map;

public interface IDoBusi {
	String submit4JSON(String busiParams) throws Exception;
	Map submit4Map(Map busiMap) throws Exception;
	String submit4Xml(String busiXml) throws Exception;
}
