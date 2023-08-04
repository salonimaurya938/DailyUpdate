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
import com.sabpaisa.dao.AdmissionReportDao;
import com.sabpaisa.entity.AdmissionEnquiry;
import com.sabpaisa.entity.AdmissionReport;
import com.sabpaisa.service.AdmissionEnquiryService;
import com.sabpaisa.service.AdmissionReportService;

@Controller
public class AdmissionReportController {
	
	@Autowired
	private AdmissionReportService addReportService;
	
	@Autowired
	private AdmissionReportDao admissionReportDao;
	

	@GetMapping("/viewAdmissionReport")
	public String admission(Model model) {
		model.addAttribute("title", "Admission");
		List<AdmissionReport> as = addReportService.getAdmissionReport();
		System.out.println("All data" + as);
		model.addAttribute("data", as);
		return "admin/viewAdmissionReport";
	}

	@RequestMapping("/admissionReport")
	public String addAdmission(AdmissionReport admissionReport, Model model) {
		AdmissionReport as = new AdmissionReport();
		model.addAttribute("admissionReport", as);
		return "admin/admissionReport";
	}

	@PostMapping("/admissionReport")
	public String addAdmission(@ModelAttribute("admin/admissionReport") AdmissionReport admissionReport) {
		System.out.println("this is inserting page");
		AdmissionReport as = addReportService.addAdmissionReport(admissionReport);
		System.out.println("Inserted successfully" + as);
		return "admin/admissionReport";
	}

	@RequestMapping("/updateAdmissionReport{id}")
	public String update(AdmissionReport admissionReport, Model model, @PathVariable("id") int id) {
		System.out.println("this is update page...");
		model.addAttribute("admissionReportData", admissionReport);
		Optional<AdmissionReport> data = addReportService.getAdmissionReport(id);
		AdmissionReport sr = data.get();
		model.addAttribute("id", sr.getId());
		model.addAttribute("name", sr.getName());
		model.addAttribute("classSection", sr.getClassSection());
		model.addAttribute("fatherName", sr.getFatherName());
		model.addAttribute("motherName", sr.getMotherName());
		model.addAttribute("address", sr.getAddress());
		model.addAttribute("totalFee", sr.getTotalFee());
		model.addAttribute("paidFee", sr.getPaidFee());
		model.addAttribute("remainFee", sr.getRemainFee());
		System.out.println("show data Successfully :: " + sr);
		return "admin/updateAdmissionReport";
	}

	@PostMapping("/updateAdmissionReport")
	public String updates(@ModelAttribute("admin/updateAdmissionReport") AdmissionReport admissionReport) {
		System.out.println("test...");
		addReportService.updateAdmissionReport(admissionReport);
		System.out.println("Update Successfully" + addReportService.updateAdmissionReport(admissionReport));
		return "admin/updateAdmissionReport";
	}

	@PostMapping("/delete/{id}")
	public String delete(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		admissionReportDao.deleteById(id);
		return "admin";
	}
	

}
