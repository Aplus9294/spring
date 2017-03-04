package com.KevinZach.spring.orm;

import java.util.List;

public interface IWifeService {

	public void createWife(Wife wife);

	public List<Wife> listWives();

	public int getWivesCount();

}
