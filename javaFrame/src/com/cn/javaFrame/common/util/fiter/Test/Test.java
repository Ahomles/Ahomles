package com.cn.javaFrame.common.util.fiter.Test;

import java.io.IOException;

import com.cn.javaFrame.common.util.fiter.FilterChain;
import com.cn.javaFrame.common.util.fiter.servlet.ServletException;
import com.cn.javaFrame.common.util.fiter.servlet.ServletRequest;
import com.cn.javaFrame.common.util.fiter.servlet.ServletResponse;

public class Test {
	
	public static void main(String[] args) throws IOException, ServletException {
		FilterChain  filterChain=init();
		ServletRequest request=new ServletRequest();
		ServletResponse response=new ServletResponse();
		filterChain.doFilter(request, response);
	}
	
	public static ApplicationFilterChain init() throws ServletException{
		ApplicationFilterChain appChain=new ApplicationFilterChain();
		
		ApplicationFilterConfig config1=new ApplicationFilterConfig();
		ApplicationFilterConfig config2=new ApplicationFilterConfig();
		ApplicationFilterConfig config3=new ApplicationFilterConfig();
		config1.setFilter(new HostFilter());
		config2.setFilter(new UserFilter());
		config3.setFilter(new SimpleFilter());
		appChain.addFilter(config1);
		appChain.addFilter(config2);
		appChain.addFilter(config3);
		
		Servlet servlet=new Servlet();
		appChain.setServlet(servlet);
		
		return appChain;
	}
}
