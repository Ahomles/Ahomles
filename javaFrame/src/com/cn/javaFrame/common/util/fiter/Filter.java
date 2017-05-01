package com.cn.javaFrame.common.util.fiter;

import java.io.IOException;

import com.cn.javaFrame.common.util.fiter.servlet.ServletException;
import com.cn.javaFrame.common.util.fiter.servlet.ServletRequest;
import com.cn.javaFrame.common.util.fiter.servlet.ServletResponse;
/**
 * filter的实质就是拦截器(interceptor)
 * 参见代理模式
 * @author zhunb3
 *
 */
public interface Filter {
	public abstract void init(FilterConfig paramFilterConfig)
			throws ServletException;

	public abstract void doFilter(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse, FilterChain paramFilterChain)
			throws IOException, ServletException;

	public abstract void destroy();
}
