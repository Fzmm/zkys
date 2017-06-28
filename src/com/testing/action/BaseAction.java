package com.testing.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ServletContextAware {

	/**
	 */
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	/**
	 */
	public Object createBean(String beanName) {
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(application);
		if (wac.containsBean(beanName)) {
			return wac.getBean(beanName);
		}
		return null;
	}
}
