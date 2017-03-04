package com.KevinZach.spring.orm;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class OrmRun {

	public static void main(String[] args) {

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

		IWifeDao wifeDao = (IWifeDao) factory.getBean("wifeDao");

		Wife wife = new Wife();
		wife.setName("ÖìÊ«Âþ");
		wife.setCreatedDate(new Date());

		wifeDao.createWife(wife);

		List<Wife> wifeList = wifeDao.listWives();

		for (Wife c : wifeList) {
			System.out.println("Name: " + c.getName());
		}

	}

}
