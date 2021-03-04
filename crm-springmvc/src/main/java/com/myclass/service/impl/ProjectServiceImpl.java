package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.myclass.dto.ProjectDTO;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;
import com.myclass.service.ProjectService;
import com.myclass.util.Mapper;
@Service
@Scope("prototype")
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public List<ProjectDTO> findAll() {
		List<ProjectDTO> projects = new ArrayList<>();
		try {
			for(Project entity : projectRepository.findAll()) {
				ProjectDTO projectDTO = Mapper.mapObjects(entity, ProjectDTO.class);
				projectDTO.setLeaderName(entity.getCreateUser().getFullName());
				projects.add(projectDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public boolean saveOrUpdate(ProjectDTO projectDTO) {
		try {
			Project project = Mapper.mapObjects(projectDTO, Project.class);
			projectRepository.saveOrUpdate(project);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ProjectDTO findById(int id) {
		try {
			Project project = projectRepository.findById(id);
			return Mapper.mapObjects(project, ProjectDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProjectDTO();
	}

}
