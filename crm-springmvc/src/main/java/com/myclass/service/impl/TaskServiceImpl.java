package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.myclass.dto.TaskDTO;
import com.myclass.entity.Task;
import com.myclass.repository.TaskRepository;
import com.myclass.service.TaskService;
import com.myclass.util.Mapper;

@Service
@Scope("prototype")
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public List<TaskDTO> findAll() {
		List<TaskDTO> tasks = new ArrayList<>();
		try {
			for(Task entity : taskRepository.findAll()) {
				TaskDTO taskDTO = Mapper.mapObjects(entity, TaskDTO.class);
				taskDTO.setCreateUserName(entity.getCreateUser().getFullName());
				taskDTO.setUserName(entity.getUser().getFullName());
				taskDTO.setStatusName(entity.getName());
				taskDTO.setProjectName(entity.getProject().getName());
				tasks.add(taskDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}

}
