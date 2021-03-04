package com.myclass.service;

import java.util.List;
import com.myclass.dto.UserDTO;

public interface UserService {
	
	List<UserDTO> findAll();
	int saveOrUpdate(UserDTO userDTO);
	UserDTO findById(int id);
	int delete(int id);
	
}
