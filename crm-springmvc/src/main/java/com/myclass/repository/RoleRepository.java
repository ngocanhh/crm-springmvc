package com.myclass.repository;

import java.util.List;
import com.myclass.entity.Role;

public interface RoleRepository {
	
	List<Role> findAll();
	void saveOrUpdate(Role role);
	Role findById(int id);
	void delete(int id);
	
}
