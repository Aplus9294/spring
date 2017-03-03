package com.KevinZach.spring.orm;

import java.util.List;

public interface ICatService {

	public void createCat(Cat cat);

	public List<Cat> listCats();

	public int getCatsCount();

}
