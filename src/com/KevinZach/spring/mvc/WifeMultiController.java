package com.KevinZach.spring.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.KevinZach.spring.orm.Wife;
import com.KevinZach.spring.orm.IWifeService;

public class WifeMultiController extends MultiActionController {

	private IWifeService wifeService;

	public IWifeService getWifeService() {
		return wifeService;
	}

	public void setWifeService(IWifeService wifeService) {
		this.wifeService = wifeService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {

		Wife wife = new Wife();
		wife.setName(request.getParameter("name"));
		wife.setCreatedDate(new Date());

		wifeService.createWife(wife);

		return this.list(request, response);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

		List<Wife> wifeList = wifeService.listWives();

		request.setAttribute("wifeList", wifeList);

		return new ModelAndView("wife/listWife");
	}
}
