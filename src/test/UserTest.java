package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testing.model.UserModel;
import com.testing.service.UserService;

public class UserTest {

	@Test
	public void add() {
		UserModel model = new UserModel();
		boolean flag = false;
		for (int i = 1; i < 20; i++) {
			model.setTuid("1" + i);
			model.setName("乔布斯" + i);
			model.setRemark("苹果公司创始人" + i);
			model.setUdate(new Date());
			model.setPhone("18825172408" + i);
			model.setCard("10086" + i);
			model.setMail("18825172408@163.com" + i);

			BeanFactory bf = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
			UserService us = (UserService) bf.getBean("userService");
			flag = us.addUser(model);
		}
		System.out.println("flag:" + flag);

	}

	@Test
	public void query() {
		BeanFactory bf = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		UserService us = (UserService) bf.getBean("userService");
		
		UserModel model = new UserModel();
		//model.setPage(1);
		model.setName("斯");

		model = (UserModel) us.queryPage(model);
		System.out.println("page:"+model.getPage());
		System.out.println("count:"+model.getCount());
		System.out.println("list:"+model.getList());

	}
}
