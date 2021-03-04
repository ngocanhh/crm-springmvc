package com.myclass.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.service.TaskService;

@Controller
@Scope("prototype")
@RequestMapping("task")
public class TaskController {
	
	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("TASKS", taskService.findAll());
		return "task/index";
	}
	
}
