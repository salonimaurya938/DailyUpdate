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

import com.sabpaisa.dao.AdmissionEnquiryDao;
import com.sabpaisa.entity.AdmissionEnquiry;
import com.sabpaisa.service.AdmissionEnquiryService;

@Controller
public class AdmissionEnquiryController {
	
	@Autowired
	private AdmissionEnquiryService admissionEnquiryService;
	
	@Autowired
	private AdmissionEnquiryDao admissionEnquiryDao;
	
	
	@GetMapping("/viewAdmissionEnquiry")
	public String admissionEnquiry(Model model) {
		model.addAttribute("title", "Admission : Enquiry");
		List<AdmissionEnquiry> data1 = admissionEnquiryService.getAdmissionEnquiry();
		model.addAttribute("enData", data1);
		System.out.println("All data" + data1);		
		return "admin/viewAdmissionEnquiry";
	}

	@RequestMapping("/admissionEnquiry")
	public String addAdmissionEnquiry(AdmissionEnquiry admissionEnquiry, Model model) {
		AdmissionEnquiry as = new AdmissionEnquiry();
		model.addAttribute("admissionEnquiry", as);
		return "admin/admissionEnquiry";
	}
	
	@PostMapping("/admissionEnquiry")
	public String addAdmissionEnquirys(@ModelAttribute("admin/admissionEnquiry") AdmissionEnquiry admissionEnquiry) {
		System.out.println("this is inserting page");
		AdmissionEnquiry as = admissionEnquiryService.addAdmissionEnquiry(admissionEnquiry);
		System.out.println("Inserted successfully" + as);
		return "admin/admissionEnquiry";
	}
	
	@RequestMapping("/updateAdmissionEnquiry{id}")
	public String updateEnquiry(AdmissionEnquiry admissionEnquiry, Model model, @PathVariable("id") int id) {
		System.out.println("this is update page...");
		model.addAttribute("admissionEnquiryData", admissionEnquiry);
		Optional<AdmissionEnquiry> enqdata = admissionEnquiryService.getAdmissionEnquiry(id);
		AdmissionEnquiry sr = enqdata.get();
		model.addAttribute("id", sr.getId());
		model.addAttribute("name", sr.getName());
		model.addAttribute("mob", sr.getMob());
		model.addAttribute("email", sr.getEmail());
		model.addAttribute("address", sr.getAddress());
		model.addAttribute("classes", sr.getClasses());
		model.addAttribute("description", sr.getDescription());
		model.addAttribute("dateTime", sr.getDateTime());
		model.addAttribute("assigned", sr.getAssigned());
		model.addAttribute("reference", sr.getReference());
		model.addAttribute("source", sr.getSource());
		System.out.println("show data Successfully :: " + sr);
		return "admin/updateAdmissionEnquiry";
	}

	@PostMapping("/updateAdmissionEnquiry")
	public String updatesEnquiry(@ModelAttribute("admin/updateAdmissionEnquiry") AdmissionEnquiry admissionEnquiry) {
		System.out.println("test...");
		admissionEnquiryService.updateAdmissionEnquiry(admissionEnquiry);
		System.out.println("Update Successfully"+admissionEnquiryService.updateAdmissionEnquiry(admissionEnquiry));
		return "admin/updateAdmissionEnquiry";
	}
	
	@PostMapping("/deleteEnquiry{id}")
	public String deleteEnquiry(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		admissionEnquiryDao.deleteById(id);
		List<AdmissionEnquiry> data1 = admissionEnquiryService.getAdmissionEnquiry();
		model.addAttribute("enData", data1);
		return "admin/viewAdmissionEnquiry";
	}
	

	
	

}
