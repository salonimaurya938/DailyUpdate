package com.sabpaisa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sabpaisa.dao.HomeWorkDao;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.service.HomeWorkService;
import com.sun.jdi.Method;

@Controller
public class HomeWorkController {
	
	@Autowired 
	private HomeWorkService homeWorkService;
	
	@Autowired
	private HomeWorkDao homeWorkDao;
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
		return "redirect:/admin/addhomework";
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
	
	@GetMapping("/updateQuestion{id}")
	public String  updateQuestion(HomeWork homeWork,@PathVariable("id") int id,Model model) {	
		model.addAttribute("homework", homeWork);	
		Optional<HomeWork> workData= homeWorkService.gethomeWork(id);
		HomeWork  b =workData.get();
	    model.addAttribute("id", b.getId());
		model.addAttribute("question", b.getQuestion());
		model.addAttribute("homework", homeWork);
		return "admin/updateQuestion";
	}
	
	@PostMapping("/updateQuestion")
	public String updateQuestions(@ModelAttribute("admin/updateQuestion")HomeWork homework) {
		System.out.println("updating homework....");
		homeWorkService.updateHomeWork(homework);
		System.out.println("Update successfully .."+homeWorkService.updateHomeWork(homework));
		return "admin/updateQuestion";
	}
	
	@PostMapping("/deleteQuestion{id}")
	public String delete(Model model,@RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		homeWorkDao.deleteById(id);
		List<HomeWork> homework1 = homeWorkService.getHomeWorks();
		model.addAttribute("question", homework1);
		return "admin/viewhomework";
	}
	

}
