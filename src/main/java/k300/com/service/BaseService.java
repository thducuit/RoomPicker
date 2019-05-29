package k300.com.service;

import java.util.List;

public interface BaseService<T> {
	
	List<T> findAll();
	
	T getById(Integer id);
	
	T add(T t);
	
	void delete(Integer id);
	
	T update(T t);

}
