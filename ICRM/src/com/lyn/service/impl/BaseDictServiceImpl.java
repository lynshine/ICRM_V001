package com.lyn.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.dao.BaseDictDao;
import com.lyn.domain.BaseDict;
import com.lyn.service.BaseDictService;
import com.lyn.utils.GsonUtils;

public class BaseDictServiceImpl implements BaseDictService {

	
	private BaseDictDao dao;
	@Override
	public List<BaseDict> findByType(DetachedCriteria detachedCriteria) {
		List<BaseDict> list = dao.findByType(detachedCriteria);
		
		return list;
	}
	public void setDao(BaseDictDao dao) {
		this.dao = dao;
	}
	
	

}
