package com.sabpaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.service.HomeWorkService;

@Controller
@RequestMapping("/admin")
public class HomeWorkController {
	
	@Autowired 
	private HomeWorkService homeWorkService;
//	.......................Start Book handler.................................

	@RequestMapping("/addhomework")
	public String homework(Model model) {
		model.addAttribute("title", "Add HomeWork-School Management System");
		HomeWork homeWork = new HomeWork();
		model.addAttribute("homework", homeWork);
		return "admin/addhomework";
	}

	@PostMapping("/addhomework")
	public String inserthomework(@ModelAttribute("admin/addhomework") HomeWork homeWork) {
		System.out.println("Inserting data..");
		homeWorkService.addHomeWork(homeWork);
		System.out.println("data inserted value ::" + homeWorkService.addHomeWork(homeWork));
		return "redirect:/admin/viewhomework";
	}
	
	@RequestMapping("/viewhomework")
	public String viewhomework(Model model, HomeWork homework) {
		model.addAttribute("title", "View HomeWork-School Management System");
		System.out.println("Showing..........homeWork data");
		List<HomeWork> homework1 = homeWorkService.getHomeWorks();
		System.out.println("homework data ::"+homework1);
		model.addAttribute("question", homework1);
		return "admin/viewhomework";
	}

}
