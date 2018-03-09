package com.lyn.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	void save(T t);
	Integer findCount(DetachedCriteria detachedCriteria);
	List<T> findByPage(DetachedCriteria detachedCriteria, Integer index, Integer pageSize);
	void delete(T t);
	T findById(Long id);
	void update(T t);

}
