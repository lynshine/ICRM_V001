package com.lyn.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByType(DetachedCriteria detachedCriteria);

}
