package com.lyn.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lyn.dao.BaseDictDao;
import com.lyn.domain.BaseDict;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@Override
	public List<BaseDict> findByType(DetachedCriteria detachedCriteria) {
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
