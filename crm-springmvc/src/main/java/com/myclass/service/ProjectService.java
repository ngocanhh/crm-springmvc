package com.myclass.service;

import java.util.List;

import com.myclass.dto.ProjectDTO;

public interface ProjectService {
	
	List<ProjectDTO> findAll();
	boolean saveOrUpdate(ProjectDTO projectDTO);
	ProjectDTO findById(int id);
	
}
