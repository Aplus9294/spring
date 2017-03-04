package com.KevinZach.spring.orm;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WifeDaoImpl extends HibernateDaoSupport implements IWifeDao {

	public void createWife(Wife wife) {
		this.getHibernateTemplate().persist(wife);
	}

	public Wife findWifeByName(String name) {
		List<Wife> wifeList = this.getHibernateTemplate().find(" select w from Wife w where w.name = ? ", name);
		if (wifeList.size() > 0)
			return wifeList.get(0);
		return null;
	}

	public int getWivesCount() {
		return (Integer) this.getSession(true).createQuery(" select count(w) from Wife w ").uniqueResult();
	}

	public List<Wife> listWives() {
		return this.getHibernateTemplate().find(" select w from Wife w ");
	}

}
