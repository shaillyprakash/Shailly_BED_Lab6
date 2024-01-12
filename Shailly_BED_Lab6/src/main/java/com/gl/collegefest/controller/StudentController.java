package com.gl.collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.collegefest.entity.Student;
import com.gl.collegefest.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "student/student-list";
	}

	@GetMapping("/showStudentFormForAdd")
	public String showStudentFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student/student-form";
	}
		@GetMapping("/showStudentFormForEdit/{id}")
		public String showStudentFormForUpdate(Model model, @PathVariable int id ) {
			Student student = studentService.findById(id);
			model.addAttribute("student", student);
			return "student/student-form";
		
	}
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable int id ) {
			studentService.deleteById(id);
			return "redirect:/student/list";
		
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute ("student") Student student) {
		
		studentService.save(student);
		System.out.println("in save method......");
		return "redirect:student/student/list";
	}
	
}