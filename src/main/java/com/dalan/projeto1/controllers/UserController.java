package com.dalan.projeto1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dalan.projeto1.repository.UserRepository;

@Controller
public class UserController {

	private UserRepository repository;
	
	public UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		model.addAttribute("usersList", repository.findAll());
		
		return "user";
	}
}
