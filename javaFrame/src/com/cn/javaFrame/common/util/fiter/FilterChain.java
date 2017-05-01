package com.cn.javaFrame.common.util.fiter;

import java.io.IOException;

import com.cn.javaFrame.common.util.fiter.servlet.ServletException;
import com.cn.javaFrame.common.util.fiter.servlet.ServletRequest;
import com.cn.javaFrame.common.util.fiter.servlet.ServletResponse;
public interface FilterChain {
	public abstract void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse) throws IOException,
			ServletException;
}
