package com.lyn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.Customer;
import com.lyn.domain.PageBean;
import com.lyn.domain.User;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> find(DetachedCriteria detachedCriteria, PageBean<Customer> pageBean);

	List<User> findUser();

	void delete(Customer customer);

	Customer findByid(Long cust_id);

	void update(Customer customer);

	List<Customer> findAll(DetachedCriteria detachedCriteria);

}
