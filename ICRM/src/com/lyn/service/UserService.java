package com.lyn.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.User;

public interface UserService {
	
	void save(User user);

	User findByUser(DetachedCriteria detachedCriteria);

}
