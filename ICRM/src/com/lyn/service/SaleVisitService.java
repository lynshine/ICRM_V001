package com.lyn.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lyn.domain.PageBean;
import com.lyn.domain.SaleVisit;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, int currentPage, int pageSize);

}
