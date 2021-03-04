package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDTO;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;
import com.myclass.util.Mapper;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> users = new ArrayList<>();
		try {
			for(User entity : userRepository.findAll()) {
				UserDTO user = Mapper.mapObjects(entity, UserDTO.class);
				user.setRoleDescription(entity.getRole().getDescription());
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int saveOrUpdate(UserDTO userDTO) {
		try {
			User user = Mapper.mapObjects(userDTO, User.class);
			userRepository.saveOrUpdate(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public UserDTO findById(int id) {
		try {
			return Mapper.mapObjects(userRepository.findById(id), UserDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UserDTO();
	}

	@Override
	public int delete(int id) {
		try {
			userRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
