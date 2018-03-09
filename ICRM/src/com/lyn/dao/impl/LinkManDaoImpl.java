package com.lyn.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lyn.dao.LinkManDao;
import com.lyn.domain.Customer;
import com.lyn.domain.LinkMan;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {


/*	@Override
	public void save(LinkMan linkman) {
		getHibernateTemplate().save(linkman);
		
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		detachedCriteria.setProjection(null);
		if (list!=null && list.size()>0) {
			return list.get(0).intValue();
		}
		
		return null;
	}

	@Override
	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer index, Integer pageSize) {
		List<LinkMan> list = (List<LinkMan>) getHibernateTemplate().findByCriteria(detachedCriteria, index, pageSize);
		System.out.println(list);
		return list;
	}*/

	@Override
	public List<LinkMan> findByCustID(DetachedCriteria detachedCriteria) {
		List<LinkMan> list = (List<LinkMan>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

	/*@Override
	public void delete(LinkMan linkman) {
		getHibernateTemplate().delete(linkman);
		
	}

	@Override
	public LinkMan findById(Long id) {
		LinkMan linkMan = getHibernateTemplate().get(LinkMan.class, id);
		return linkMan;
	}

	@Override
	public void update(LinkMan linkman) {
		getHibernateTemplate().update(linkman);
		
	}*/

}
