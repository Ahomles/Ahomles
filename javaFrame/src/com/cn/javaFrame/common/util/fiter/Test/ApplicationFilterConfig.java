package com.cn.javaFrame.common.util.fiter.Test;

import java.util.Enumeration;

import com.cn.javaFrame.common.util.fiter.Filter;
import com.cn.javaFrame.common.util.fiter.FilterConfig;
import com.cn.javaFrame.common.util.fiter.servlet.ServletContext;
import com.cn.javaFrame.common.util.fiter.servlet.ServletException;

public class ApplicationFilterConfig implements FilterConfig{
	Filter filter=null;
	
	@Override
	public String getFilterName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInitParameter(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getInitParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Filter getFilter() throws ServletException{
		filter.init(this);
		return filter;
	}
	
	public void  setFilter(Filter filter) throws ServletException{
		this.filter=filter;
	}
}
