package com.lyn.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.Customer;
import com.lyn.domain.LinkMan;

public interface LinkManDao extends BaseDao<LinkMan> {



	List<LinkMan> findByCustID(DetachedCriteria detachedCriteria);


}
