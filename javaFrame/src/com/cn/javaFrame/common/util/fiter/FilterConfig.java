package com.cn.javaFrame.common.util.fiter;

import java.util.Enumeration;

import com.cn.javaFrame.common.util.fiter.servlet.ServletContext;

public interface FilterConfig {
	// 返回web．xml部署文件中定义的该过滤器的名称。	
	public abstract String getFilterName();
	// 返回调用者所处的servlet上下文。
	public abstract ServletContext getServletContext();
	// 返回过滤器初始化参数值的字符串形式，当参数不存在时，返回nul1．name是初始化参数名。
	public abstract String getInitParameter(String s);
	// 以Enumeration形式返回过滤器所有初始化参数值，如果没有初始化参数，返回为空。
	public abstract Enumeration getInitParameterNames();
}
