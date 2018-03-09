package com.lyn.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lyn.dao.CustomerDao;
import com.lyn.domain.Customer;
import com.lyn.domain.User;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/*@Override
	public void save(Customer customer) {
		getHibernateTemplate().save(customer);

	}

	@Override
	public List<Customer> findByPage(DetachedCriteria detachedCriteria,Integer index,Integer pageSize) {
		
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria, index, pageSize);
		return list;
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		detachedCriteria.setProjection(null);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}*/

	@Override
	public List<User> findUser() {
		String hql = "select distinct cust_user_id from Customer";
		List<User> list = (List<User>) getHibernateTemplate().find(hql);
		return list;
	}

	/*@Override
	public void delete(Customer customer) {
		getHibernateTemplate().delete(customer);
		
	}

	@Override
	public Customer findById(Long cust_id) {
		Customer customer = getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}

	@Override
	public void update(Customer customer) {
		getHibernateTemplate().update(customer);
		
	}*/

	@Override
	public List<Customer> findAll(DetachedCriteria detachedCriteria) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
