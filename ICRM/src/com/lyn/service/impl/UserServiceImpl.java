package com.lyn.service.impl;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.dao.UserDao;
import com.lyn.domain.User;
import com.lyn.service.UserService;
import com.lyn.utils.MD5Utils;

public class UserServiceImpl implements UserService {

	private UserDao dao;
	@Override
	public void save(User user) {
		user.setState('1');
		String password = user.getPassword();
		user.setPassword(MD5Utils.encrypt(password));
		dao.save(user);
	}
	@Override
	public User findByUser(DetachedCriteria detachedCriteria) {
		User user1 =  dao.findByUser(detachedCriteria);
		return user1;
	}
	
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

}
