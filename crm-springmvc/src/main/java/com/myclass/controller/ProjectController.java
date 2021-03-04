package com.myclass.controller;

import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.ProjectDTO;
import com.myclass.service.ProjectService;

@Controller
@Scope("prototype")
@RequestMapping("project")
public class ProjectController {
	
	private ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("PROJECTS", projectService.findAll());
		return "project/index";
	}
	
	@GetMapping("add")
	public String add() {
		return "project/add";
	}
	
	@PostMapping("add")
	public String addProject(@RequestParam("name") String name,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setName(name);
		projectDTO.setStartDate(startDate);
		projectDTO.setEndDate(endDate);
		projectDTO.setCreateUserId(1);
		if(projectService.saveOrUpdate(projectDTO)) {
			return "redirect:/project";
		}else {
			return "project/add";
		}
	}
	
	@GetMapping("edit")
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("PROJECT", projectService.findById(id));
		return "project/edit";
	}
	
	@PostMapping("edit")
	public String editProject(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(id);
		projectDTO.setName(name);
		projectDTO.setStartDate(startDate);
		projectDTO.setEndDate(endDate);
		projectDTO.setCreateUserId(1);
		if(projectService.saveOrUpdate(projectDTO)) {
			return "redirect:/project";
		}else {
			return "project/edit";
		}
	}
	
	
	
}
