package com.myclass.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.myclass.dto.UserDTO;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

@Controller
@Scope("prototype")
@RequestMapping("user")
public class UserController {
	
	private UserService userService;
	private RoleService roleService;
	
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("USERS", userService.findAll());
		return "user/index";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("ROLES", roleService.findAll());
		return "user/add";
	}
	
	@PostMapping("add")
	public String addUser(@RequestParam("email") String email, 
			@RequestParam("password") String password,
			@RequestParam("fullName") String fullName,
			@RequestParam("roleId") int roleId,
			@RequestParam("avatar") String avatar) {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		userDTO.setFullName(fullName);
		userDTO.setPassword(password);
		userDTO.setRoleId(roleId);
		userDTO.setAvatar(avatar);
		if(userService.saveOrUpdate(userDTO) != 1) {
			return "user/add";
		}else {
			return "redirect:/user";
		}
	}
	
	@GetMapping("edit")
	public String edit(ModelMap model, @RequestParam("id") int id) {
		model.addAttribute("USER", userService.findById(id));
		model.addAttribute("ROLES", roleService.findAll());
		return "user/edit";
	}
	
	@PostMapping("edit")
	public String editUser(@RequestParam("id") int id, @RequestParam("email") String email, 
			@RequestParam("password") String password,
			@RequestParam("fullName") String fullName,
			@RequestParam("roleId") int roleId,
			@RequestParam("avatar") String avatar) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setEmail(email);
		userDTO.setFullName(fullName);
		userDTO.setPassword(password);
		userDTO.setRoleId(roleId);
		userDTO.setAvatar(avatar);
		if(userService.saveOrUpdate(userDTO) != 1) {
			return "user/edit";
		}else {
			return "redirect:/user";
		}
	}
	
	@GetMapping("remove")
	public String remove(@RequestParam("id") int id) {
		if(userService.delete(id) != 1) {
			return "user/index";
		}else {
			return "redirect:/user";
		}
	}
	
}
