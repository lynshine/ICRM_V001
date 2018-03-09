package com.lyn.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.dao.LinkManDao;
import com.lyn.domain.Customer;
import com.lyn.domain.LinkMan;
import com.lyn.domain.PageBean;
import com.lyn.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao dao;
	public void setDao(LinkManDao dao) {
		this.dao = dao;
	}
	@Override
	public void save(LinkMan linkman) {
		dao.save(linkman);
		
	}
	@Override
	public PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		Integer count = dao.findCount(detachedCriteria);
		
		int index = (currentPage-1)*pageSize;
		List<LinkMan> list = dao.findByPage(detachedCriteria,index,pageSize);
		
		Integer totalPage = (int) Math.ceil(1.0*count/pageSize);
		
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		pageBean.setCount(count);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	@Override
	public List<LinkMan> findByCustID(DetachedCriteria detachedCriteria) {
		return dao.findByCustID(detachedCriteria);
	}
	@Override
	public void delete(LinkMan linkman) {
		dao.delete(linkman);
		
	}
	@Override
	public LinkMan findById(Long id) {
		return dao.findById(id);
	}
	@Override
	public void update(LinkMan linkman) {
		dao.update(linkman);
		
	}
	
	

}
