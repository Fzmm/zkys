package com.testing.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;
import com.testing.model.UserModel;
import com.testing.service.UserService;

public class UserAction extends BaseAction implements ModelDriven<UserModel>{

	private Log log = LogFactory.getLog(getClass());
	private UserModel model = new UserModel();

	

	public UserModel getModel() {
		return model;
	}



	public void setModel(UserModel model) {
		this.model = model;
	}



	public String query() {
		log.info("执行查询,传入的model:" + model);

		BeanFactory bf = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		UserService us = (UserService) bf.getBean("userService");
		model = (UserModel) us.queryPage(model);

		return "query";

	}
}
