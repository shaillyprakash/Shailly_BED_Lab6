package com.gl.collegefest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@GetMapping("/")
	public String showHomeDashboard() {
		return "home-dashboard";
	}

	@GetMapping("/edit")
	public String showEditDashboard() {
		System.out.println("edit");
		return "edit";
	}
	@GetMapping("/delete")
	public String showDeleteDashboard() {
		System.out.println("delete");
		return "delete";
	}
	@GetMapping("/save")
	public String showSaveDashboard() {
		System.out.println("save");
		return "save";
	}
}
