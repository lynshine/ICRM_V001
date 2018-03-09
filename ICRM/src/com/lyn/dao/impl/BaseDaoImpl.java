package com.lyn.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lyn.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class clazz;
	
	public BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public T findById(Long id) {
		T t =  (T) getHibernateTemplate().get(clazz, id);
		return t;
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer index, Integer pageSize) {
		detachedCriteria.setProjection(null);
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, index, pageSize);
		return list;
	}





}
