package com.lyn.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lyn.dao.UserDao;
import com.lyn.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	
	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);

	}

	@Override
	public User findByUser(DetachedCriteria detachedCriteria) {
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(detachedCriteria);
		
		if (list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	

	

}
