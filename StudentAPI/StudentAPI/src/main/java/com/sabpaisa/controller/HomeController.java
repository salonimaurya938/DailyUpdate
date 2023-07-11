package com.sabpaisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Student;

@Controller
public class HomeController {
//	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home-Student Management System");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About-Student Management System");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Registration-Student Management System");
		model.addAttribute("student", new Student());
		return "signup";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login-Student Management System");
		return "login";
	}

	// handler for registering user
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("student") Student student,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {
		System.out.println("Agreement" + agreement);
		System.out.println("Student" + student);
		return "signup";
	}




}
