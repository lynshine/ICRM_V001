package com.lyn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.Customer;
import com.lyn.domain.LinkMan;
import com.lyn.domain.PageBean;

public interface LinkManService {


	void save(LinkMan linkman);

	PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	List<LinkMan> findByCustID(DetachedCriteria detachedCriteria);

	void delete(LinkMan linkman);

	LinkMan findById(Long id);

	void update(LinkMan linkman);

}
