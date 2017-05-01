package com.cn.javaFrame.common.util.fiter.Test;

import java.io.IOException;

import com.cn.javaFrame.common.util.fiter.Filter;
import com.cn.javaFrame.common.util.fiter.FilterChain;
import com.cn.javaFrame.common.util.fiter.FilterConfig;
import com.cn.javaFrame.common.util.fiter.servlet.ServletException;
import com.cn.javaFrame.common.util.fiter.servlet.ServletRequest;
import com.cn.javaFrame.common.util.fiter.servlet.ServletResponse;

public class SimpleFilter implements Filter{
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		this.filterConfig = paramFilterConfig;
		System.out.println("初始化简单过滤器！");
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse, FilterChain paramFilterChain)
			throws IOException, ServletException {
		try{
			//将过滤器传递到下一个过滤器
			System.out.println("第3个过滤器SimpleFilter");
			paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void destroy() {	
		System.out.println("销毁过滤器！");
	}
}
