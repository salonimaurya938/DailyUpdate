package com.sabpaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sabpaisa.dao.ComplaintsDao;
import com.sabpaisa.entity.Complaints;
import com.sabpaisa.entity.Events;

import com.sabpaisa.service.EventsService;

@Controller
public class EventsController {
	
	@Autowired
	private ComplaintsDao complaintsDao;
	
	@Autowired 
	private EventsService eventsService;
// ...............................................Holidays Controllers........................................................
	
	@GetMapping("/addEvents")
	public String addEvents(Model model,Events events) {		
		model.addAttribute("title", "Holidays Plan-Student Management System");
		model.addAttribute("events", events);		
		return "admin/addEvents";
	}
	
	@PostMapping("/addEvents")
	public String addevents(@ModelAttribute("admin/addEvents") Events events) {		
		eventsService.addEvents(events);		
		System.out.println("Data Insrted Successfully :: "+eventsService.addEvents(events));		
		return "admin/addEvents";
	}
		
	@RequestMapping("/viewEvents")
	public String viewEvents(Model model) {
		List<Events> as= eventsService.getEvents();
		model.addAttribute("events", as);
		return "admin/viewEvents";
	}
	
	//......................................Complaints Handler...........................
	
	@RequestMapping("/viewComplaints")
	public String complaintsView(Model model, Complaints complaints) {
		model.addAttribute("title", "Students Complaints-School Management System");
		List<Complaints> list= complaintsDao.findAll();
		model.addAttribute("lists", list);		
		System.out.println("view complaints.......");
		return "admin/viewComplaints";
	}
	
	


}
