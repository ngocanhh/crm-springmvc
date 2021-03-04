package com.myclass.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.myclass.dto.RoleDTO;
import com.myclass.service.RoleService;

@Controller
@Scope("prototype")
@RequestMapping("role")
public class RoleController {
	
	private RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("ROLES", roleService.findAll());
		return "role/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "role/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addRole(@RequestParam("name") String name, @RequestParam("description") String description) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setName(name);
		roleDTO.setDescription(description);
		if(roleService.save(roleDTO) != 1) {
			return "role/add";
		}else {
			return "redirect:/role";
		}
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("ROLE", roleService.findById(id));
		return "role/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editRole(@RequestParam("id") int id, @RequestParam("name") String name, 
			@RequestParam("description") String description) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(id);
		roleDTO.setName(name);
		roleDTO.setDescription(description);
		if(roleService.update(roleDTO) != 1) {
			return "role/edit";
		}else {
			return "redirect:/role";
		}
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String remove(@RequestParam("id") int id) {
		if(roleService.delete(id) != 1) {
			return "role/index";
		}else {
			return "redirect:/role";
		}
	}
	
}
