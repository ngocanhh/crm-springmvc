package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.myclass.dto.RoleDTO;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;
import com.myclass.util.Mapper;

@Service
@Scope("prototype")
public class RoleServiceImpl implements RoleService{
	
	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> roles = new ArrayList<>();
		try {
			for(Role role : roleRepository.findAll()) {
				roles.add(new RoleDTO(role.getId(), role.getName(), role.getDescription()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public int save(RoleDTO roleDTO) {
		try {
			Role role = Mapper.mapObjects(roleDTO, Role.class);
			roleRepository.saveOrUpdate(role);
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public RoleDTO findById(int id) {
		try {
			Role role = roleRepository.findById(id);
			return Mapper.mapObjects(role, RoleDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RoleDTO();
	}

	@Override
	public int update(RoleDTO roleDTO) {
		try {
			Role role = Mapper.mapObjects(roleDTO, Role.class);
			roleRepository.saveOrUpdate(role);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int delete(int id) {
		try {
			
			roleRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
