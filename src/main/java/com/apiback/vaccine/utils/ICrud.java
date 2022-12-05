package com.apiback.vaccine.utils;

import java.util.List;

public interface ICrud<T, ID> {
	
	List<T> findAll();

	T save(T t);

	T update(T t);

	T findById(ID id);

	void delete(ID id);
}
