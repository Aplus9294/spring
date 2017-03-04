package com.KevinZach.spring.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.util.Assert;
import org.springframework.web.struts.ActionSupport;

import com.KevinZach.spring.form.WifeForm;
import com.KevinZach.spring.orm.Wife;
import com.KevinZach.spring.orm.IWifeService;

public class WifeAction extends ActionSupport {

	public IWifeService getWifeService() {
		return (IWifeService) getWebApplicationContext().getBean("wifeService");
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		WifeForm wifeForm = (WifeForm) form;

		if ("add".equals(wifeForm.getAction()))
			return this.add(mapping, form, request, response);
			return this.list(mapping, form, request, response);
	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		WifeForm wifeForm = (WifeForm) form;

		Assert.hasLength(wifeForm.getName(), "名字不能为 null");

		Wife wife = new Wife();
		wife.setName(wifeForm.getName());
		wife.setCreatedDate(new Date());

		IWifeService wifeService = getWifeService();
		wifeService.createWife(wife);

		return this.list(mapping, form, request, response);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		IWifeService wifeService = getWifeService();
		List<Wife> wifeList = wifeService.listWives();
		request.setAttribute("wifeList", wifeList);
		return mapping.findForward("list");
	}
}