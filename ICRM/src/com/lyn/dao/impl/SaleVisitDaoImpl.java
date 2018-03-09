package com.lyn.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lyn.dao.SaleVisitDao;
import com.lyn.domain.SaleVisit;

public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements SaleVisitDao {

	/*@Override
	public void save(SaleVisit saleVisit) {
		getHibernateTemplate().save(saleVisit);
	}

	@Override
	public int findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		detachedCriteria.setProjection(null);
		if (list!=null && list.size()>0) {
			return list.get(0).intValue();
		}
		
		return 0;
	}

	@Override
	public List<SaleVisit> findByPage(DetachedCriteria detachedCriteria, int index, int pageSize) {
		List<SaleVisit> list = (List<SaleVisit>) getHibernateTemplate().findByCriteria(detachedCriteria, index, pageSize);
		return list;
	}*/

}
