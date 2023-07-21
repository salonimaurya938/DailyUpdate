package com.sabpaisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {

	@RequestMapping("/")
	public String home() {
		System.out.println("Index handler...");
		return "index";
	}
}
