package com.KevinZach.spring.orm;

import java.util.List;

public interface IWifeDao {

	public void createWife(Wife wife);

	public Wife findWifeByName(String name);

	public List<Wife> listWives();

	public int getWivesCount();

}
