package com.sabpaisa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.sabpaisa.dao.AdmissionEnquiryDao;
import com.sabpaisa.dao.AdmissionReportDao;
import com.sabpaisa.entity.Admission;
import com.sabpaisa.entity.AdmissionEnquiry;
import com.sabpaisa.entity.AdmissionReport;
import com.sabpaisa.service.AdmissionEnquiryService;
import com.sabpaisa.service.AdmissionReportService;
import com.sabpaisa.service.AdmissionServices;

@Controller
public class AdmissionController {
	
	@Autowired
	private AdmissionEnquiryService admissionEnquiryService;
	
	@Autowired
	private AdmissionEnquiryDao admissionEnquiryDao;
	
	@Autowired
	private AdmissionReportService addReportService;
	
	@Autowired
	private AdmissionReportDao admissionReportDao;
	
	@Autowired
	private AdmissionServices admissionServices;
	
	//.........................New Admission Controller...........................
	
	@RequestMapping("/newAdmission")
	public String newAdmission(Model model) {
		model.addAttribute("title", "Admission : Enquiry");
		
		List<Admission> abc= admissionServices.getAdmissions();
		System.out.println("Admission All Data !!!");
		System.out.println(abc);
		model.addAttribute("admission", abc);
		
		return "admin/newAdmission";
	}	
	
	@PostMapping("/newAdmission")
	public ResponseEntity<String> insertNewAdmission(
			@ModelAttribute("admin/newAdmission") 
			@RequestParam("stdProfile") MultipartFile stdProfile,
			@RequestParam("fProfile") MultipartFile fProfile,
			@RequestParam("mProfile") MultipartFile mProfile,
			String admissionNo, String name, String fname, String mname, String dob, String gender, String bloodGroup,
			String classes, String address, String gmail, String district, String state, String pincode,
			String aadharNo, String fqulification, String mqulification, String foccupation, String pmob,
			String receiptNo, String amount, String registrationNo, String classAdmittedinto, String rollNo,String userId, String pass) {

		Admission admission = new Admission();
		Admission newData = admissionServices.saveAdmission(admission);
		newData.setAdmissionNo(admissionNo);
		newData.setName(name);
		newData.setFname(fname);
		newData.setMname(mname);
		newData.setDob(dob);
		newData.setGender(gender);
		newData.setBloodGroup(bloodGroup);
		newData.setClasses(classes);
		newData.setAddress(address);
		newData.setGmail(gmail);
		newData.setDistrict(district);
		newData.setState(state);
		newData.setPincode(pincode);
		newData.setAadharNo(aadharNo);
		newData.setFqulification(fqulification);
		newData.setMqulification(mqulification);
		newData.setFoccupation(foccupation);
		newData.setPmob(pmob);
		newData.setReceiptNo(receiptNo);
		newData.setAmount(amount);
		newData.setRegistrationNo(registrationNo);
		newData.setClassAdmittedinto(classAdmittedinto);
		newData.setRollNo(rollNo);
		newData.setUserId(userId);
		newData.setPass(pass);
		if (newData != null) {
			try {
				newData.setStdProfile(admission.getStdProfile());
				newData.setfProfile(admission.getfProfile());
				newData.setmProfile(admission.getmProfile());
			} catch (Exception e) {
				return ResponseEntity.badRequest().body("Image upload failed: " + e.getMessage());
			}
		}
		newData = admissionServices.saveAdmission(newData);
		System.out.println("Insert successFully Admission Data !!!");
		System.out.println(newData);

		return ResponseEntity.ok("admin/newAdmission");
	}	
	
	//..........................Admission EnquiryController........................
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
		System.out.println("Successfully Inserted Admission Enquery Data!!!");
		System.out.println(as);
		
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
	

	//...................Admission ReportController.............................
	
	
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
		List<AdmissionReport> as = addReportService.getAdmissionReport();
		model.addAttribute("data", as);
		return "admin";
	}
	
	
	

}
