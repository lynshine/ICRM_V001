package com.lyn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> findByType(DetachedCriteria detachedCriteria);

}
