package com.lyn.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.dao.SaleVisitDao;
import com.lyn.domain.PageBean;
import com.lyn.domain.SaleVisit;
import com.lyn.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao dao;
	@Override
	public void save(SaleVisit saleVisit) {
		dao.save(saleVisit);

	}
	
	public void setDao(SaleVisitDao dao) {
		this.dao = dao;
		
	}

	@Override
	public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, int currentPage, int pageSize) {
		int count = dao.findCount(detachedCriteria);
		
		int index = (currentPage-1)*pageSize;
		List<SaleVisit> list = dao.findByPage(detachedCriteria,index,pageSize);
		
		int totalPage = (int) Math.ceil(1.0*count/pageSize);
		
		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
		pageBean.setCount(count);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

}
