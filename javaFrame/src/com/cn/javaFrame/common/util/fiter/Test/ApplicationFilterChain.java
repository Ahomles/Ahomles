package com.cn.javaFrame.common.util.fiter.Test;

import java.io.IOException;
import java.security.PrivilegedActionException;
import java.util.ArrayList;
import java.util.Iterator;

import com.cn.javaFrame.common.util.fiter.Filter;
import com.cn.javaFrame.common.util.fiter.FilterChain;
import com.cn.javaFrame.common.util.fiter.servlet.ServletException;
import com.cn.javaFrame.common.util.fiter.servlet.ServletRequest;
import com.cn.javaFrame.common.util.fiter.servlet.ServletResponse;

public class ApplicationFilterChain implements FilterChain {

	private ArrayList filters = new ArrayList();
	private Iterator iterator = null;
	private Servlet servlet;

	@Override
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse) throws IOException,
			ServletException {

		if (System.getSecurityManager() != null) {
			final ServletRequest req = servletrequest;
			final ServletResponse res = servletresponse;
			try {
				java.security.AccessController
						.doPrivileged(new java.security.PrivilegedExceptionAction() {
							public Object run() throws ServletException,
									IOException {
								internalDoFilter(req, res);
								return null;
							}
						});
			} catch (PrivilegedActionException pe) {
				Exception e = pe.getException();
				if (e instanceof ServletException)
					throw (ServletException) e;
				else if (e instanceof IOException)
					throw (IOException) e;
				else if (e instanceof RuntimeException)
					throw (RuntimeException) e;
				else
					throw new ServletException(e.getMessage(), e);
			}
		} else {
			internalDoFilter(servletrequest, servletresponse);
		}

	}

	private void internalDoFilter(ServletRequest req, ServletResponse res)
			throws IOException, ServletException {
		if (this.iterator == null)
			this.iterator = filters.iterator();

		if (this.iterator.hasNext()) {
			ApplicationFilterConfig filterConfig = (ApplicationFilterConfig) iterator
					.next();
			Filter filter = null;
			try {
				//获取过滤器
				filter = filterConfig.getFilter();
				// 调用下一个过滤器
				filter.doFilter(req, res, this);
			} catch (Throwable e) {
				throw new ServletException("filterChain.filter", e);
			}
			return;
		}

		try {
			// 调用servlet方法
			servlet.service("request", "response");
		} catch (Throwable e) {
			throw new ServletException("filterChain.servlet", e);
		}
	}
	void setServlet(Servlet servlet){
		this.servlet=servlet;
	}
	
	// 添加过滤器配置
	void addFilter(ApplicationFilterConfig filterConfig) {
		this.filters.add(filterConfig);
	}
	
	//清空数据
	void release() {
		this.filters.clear();
		this.iterator = iterator;
		this.servlet = null;
	}
}
