package com.myclass.repository;

import java.util.List;

import com.myclass.entity.User;

public interface UserRepository {
	
	List<User> findAll();
	void saveOrUpdate(User user);
	User findById(int id);
	void delete(int id);
	
}
