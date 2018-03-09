package com.lyn.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.lyn.dao.CustomerDao;
import com.lyn.domain.Customer;
import com.lyn.domain.PageBean;
import com.lyn.domain.User;
import com.lyn.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao;
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	@Override
	public void save(Customer customer) {
		dao.save(customer);

	}
	@Override
	public PageBean<Customer> find(DetachedCriteria detachedCriteria,PageBean<Customer> pageBean) {
		//其他参数:list,总页数,总条数,客户名称
		Integer count =  dao.findCount(detachedCriteria);
		
		Integer index = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
		Integer pageSize = pageBean.getPageSize();
		List<Customer> list = dao.findByPage(detachedCriteria,index,pageSize);
		Integer totalPage = (int) Math.ceil(count*1.0/pageBean.getPageSize());
		
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list );
		pageBean.setCount(count);
		
		
		return pageBean;
	}
	@Override
	public List<User> findUser() {
		
		return dao.findUser();
	}
	@Override
	public void delete(Customer customer) {
		dao.delete(customer);
		
	}
	@Override
	public Customer findByid(Long cust_id) {
		
		return dao.findById(cust_id);
	}
	@Override
	public void update(Customer customer) {
		dao.update(customer);
		
	}
	@Override
	public List<Customer> findAll(DetachedCriteria detachedCriteria) {
		return dao.findAll(detachedCriteria);
	}
	
	
	

}
