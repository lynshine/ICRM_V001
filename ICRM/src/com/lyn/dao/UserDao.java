package com.lyn.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.User;

public interface UserDao {
	
	void save(User user);

	User findByUser(DetachedCriteria detachedCriteria);

}
