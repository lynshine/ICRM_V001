package com.lyn.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.Customer;
import com.lyn.domain.User;

public interface CustomerDao extends BaseDao<Customer> {



	List<User> findUser();


	List<Customer> findAll(DetachedCriteria detachedCriteria);

}
