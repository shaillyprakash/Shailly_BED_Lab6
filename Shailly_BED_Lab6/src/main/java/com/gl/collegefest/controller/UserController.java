package com.gl.collegefest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.collegefest.entity.User;

@Controller
@RequestMapping("/regstration")
public class UserController {
	
	@GetMapping
	public String showregistrationForm(Model model ) {
		model.addAttribute("user", new User());
		return"registration";
		
	}
}
