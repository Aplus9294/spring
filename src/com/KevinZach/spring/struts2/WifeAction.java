package com.KevinZach.spring.struts2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.KevinZach.spring.orm.Wife;
import com.KevinZach.spring.orm.IWifeService;

public class WifeAction {

	private IWifeService wifeService;

	private Wife wife;

	private List<Wife> wifeList = new ArrayList<Wife>();

	public String add() {

		wife.setCreatedDate(new Date());

		wifeService.createWife(wife);

		return list();
	}

	public String list() {

		wifeList = wifeService.listWives();

		return "list";
	}

	public Wife getWife() {
		return wife;
	}

	public void setCat(Wife wife) {
		this.wife = wife;
	}

	public List<Wife> getWifeList() {
		return wifeList;
	}

	public void setWifeList(List<Wife> wifeList) {
		this.wifeList = wifeList;
	}

	public IWifeService getWifeService() {
		return wifeService;
	}

	public void setWifeService(IWifeService wifeService) {
		this.wifeService = wifeService;
	}
}
