package com.KevinZach.spring.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.KevinZach.spring.orm.Wife;
import com.KevinZach.spring.orm.IWifeService;

public class WifeController extends AbstractController {

	private IWifeService wifeService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String action = request.getParameter("action");

		if ("add".equals(action)) {
			return this.add(request, response);
		}
		return this.list(request, response);
	}

	protected ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Wife> wifeList = wifeService.listWives();

		request.setAttribute("wifeList", wifeList);

		return new ModelAndView("wife/listWife");
	}

	protected ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Wife wife = new Wife();
		wife.setName(request.getParameter("name"));
		wife.setCreatedDate(new Date());

		wifeService.createWife(wife);

		return new ModelAndView("wife/listWife", "wife", wife);
	}

	public IWifeService getWifeService() {
		return wifeService;
	}

	public void setWifeService(IWifeService wifeService) {
		this.wifeService = wifeService;
	}
}
