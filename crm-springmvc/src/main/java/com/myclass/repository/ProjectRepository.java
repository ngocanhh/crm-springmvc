package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Project;

public interface ProjectRepository {
	
	List<Project> findAll();
	void saveOrUpdate(Project project);
	Project findById(int id);
	
}
