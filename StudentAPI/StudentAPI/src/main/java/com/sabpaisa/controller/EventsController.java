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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sabpaisa.dao.ComplaintsDao;
import com.sabpaisa.dao.EventsDao;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Complaints;
import com.sabpaisa.entity.Events;
import com.sabpaisa.service.ComplaintsService;
import com.sabpaisa.service.EventsService;

@Controller
public class EventsController {
	
	@Autowired
	private EventsDao eventsDao;
	
	@Autowired
	private ComplaintsDao complaintsDao;
	
	@Autowired
	private ComplaintsService complaintsService;
	
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
	
	@RequestMapping("/updateEvents{id}")
	public String updateEvents(Model model,Events events,@PathVariable("id") int id) {
		System.out.println("update method...");	
		model.addAttribute("eventsUpdate", events);	
		Optional<Events> data= eventsService.getEvents(id);
		Events b =data.get();
	    model.addAttribute("id", b.getId());
		model.addAttribute("event", b.getEvent());
		model.addAttribute("dateTime", b.getDateTime());
	    System.out.println("list book :: "+data);		
		return "admin/updateEvents";
	}
	
	@PostMapping("/updateEvents")
	public String update_Event(@ModelAttribute("admin/updateEvents")Events event) {	
		System.out.println("updating data...");	
		eventsService.updateEvents(event);
		System.out.println("update successfully ::"+eventsService.updateEvents(event));
		return "admin/viewEvents";
	}
	
	@PostMapping("/deleteEvents{id}")
	public String deleteBook(Model model,@RequestParam int id, @ModelAttribute("admin/viewEvents") Events events) {
		model.addAttribute("title", "DeleteBook-School Management System");
		System.out.println("delete method.............");
		eventsDao.deleteById(id);
		List<Events> as= eventsService.getEvents();
		model.addAttribute("events", as);
		return "admin/viewEvents";
	}
	
	//......................................Complaints Handler...........................
	
	@GetMapping("/addComplaints")
	public String addComplaints(Model model,Complaints complaints) {		
		model.addAttribute("title", "Holidays Plan-Student Management System");
		model.addAttribute("events", complaints);		
		return "admin/addComplaints";
	}
	
	@PostMapping("/addComplaints")
	public String addComplaints(@ModelAttribute("admin/addComplaints") Complaints complaints) {		
		complaintsDao.save(complaints);		
		System.out.println("Data Insrted Successfully :: "+complaintsDao.save(complaints));		
		return "admin/addComplaints";
	}
		
	@RequestMapping("/viewComplaints")
	public String complaintsView(Model model, Complaints complaints) {
		model.addAttribute("title", "Students Complaints-School Management System");
		List<Complaints> list= complaintsDao.findAll();
		model.addAttribute("lists", list);		
		System.out.println("view complaints.......");
		return "admin/viewComplaints";
	}
	
	@RequestMapping("/updateComplaints{id}")
	public String  complaintsupdate(Model model,Complaints complaints,@PathVariable("id") int id) {
		System.out.println("update method...");	
		model.addAttribute("complaintsUpdate", complaints);	
		Optional<Complaints> data= complaintsService.getComplaints(id);
		Complaints d= data.get();
		model.addAttribute("id", d.getId());
		model.addAttribute("complaint", d.getComplaint());
		System.out.println("list complaints ...");
		return "admin/updateComplaints";
	}
		
	@RequestMapping(value = "/updateComplaints",  method = RequestMethod.POST)
	public String updateComplaints(@ModelAttribute("admin/updateComplaints")Complaints complaints) {
		System.out.println("Updating data...");	
		complaintsService.updateComplaints(complaints);
		System.out.println("update successfully...");
		return "admin/viewComplaints";
	}
	
	@PostMapping("/deleteComplaints{id}")
	public String  deleteComplaints(@ModelAttribute("admin/viewComplaints") Model model, @RequestParam int id)
	{
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		complaintsDao.deleteById(id);
		return "admin/viewComplaints";
	}	
	
	@RequestMapping("/addComplaints")
	public String addComplaints() {
		
		return "admin/addComplaints";
	}


}



