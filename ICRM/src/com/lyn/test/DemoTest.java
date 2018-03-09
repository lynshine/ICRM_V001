package com.lyn.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyn.dao.UserDao;
import com.lyn.domain.User;
import com.lyn.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DemoTest {
	@Resource(name="userService")
	private UserService service;
	@Test
	public void test02(){
		User user = new User();
		user.setNickname("圣枪游侠");
		user.setPassword("123456");
		user.setUname("aobama");
		service.save(user );
	}

}
