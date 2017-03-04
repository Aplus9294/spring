package com.KevinZach.spring.orm;

import java.util.List;

public class WifeServiceImpl implements IWifeService {

	private IWifeDao wifeDao;

	public IWifeDao getWifeDao() {
		return wifeDao;
	}

	public void setWifeDao(IWifeDao wifeDao) {
		this.wifeDao = wifeDao;
	}

	public void createWife(Wife wife) {

		if (wifeDao.findWifeByName(wife.getName()) != null)
			throw new RuntimeException("����" + wife.getName() + "�Ѿ����ڡ�");

		wifeDao.createWife(wife);
	}

	public int getWivesCount() {
		return wifeDao.getWivesCount();
	}

	public List<Wife> listWives() {
		return wifeDao.listWives();
	}

}
