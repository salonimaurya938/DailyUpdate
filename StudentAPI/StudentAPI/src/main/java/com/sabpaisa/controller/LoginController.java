package com.sabpaisa.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.dao.ChapterDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.Student;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.ChapterService;
import com.sabpaisa.service.StudentService;

@Controller
public class LoginController {

	@Autowired
	private ChapterDao chapterDao;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private StudentService studentService;

	public LoginController(AdminService adminService, StudentService studentService) {
		super();
		this.adminService = adminService;
		this.studentService = studentService;
	}

// .........................End login Controller..................................
	@GetMapping("/login")
	public ModelAndView login() {
		System.out.println("Project runing mood....");
		ModelAndView ma = new ModelAndView("login");
		ma.addObject("login", new Admin());
		return ma;
	}

	@PostMapping("/login")
	public String saveLogin(Model model, @ModelAttribute("login") Admin admin, Student student) {
		Admin userData = adminService.adminlogin(admin);
		Student userData1 = studentService.studentLogin(student);
	    
//	    Student std = studentData.get(id);
//	    System.out.println("email"+ std.getEmail());

		System.out.println("Loged in data :: " + userData);
		System.out.println("Student login data :: " + userData1);
		if (userData != null) {
			model.addAttribute("id", userData.getId());
			model.addAttribute("username", userData.getUsername());
			model.addAttribute("email", userData.getEmail());
			model.addAttribute("pass", userData.getPassword());
			return "admin/adminDashBoard";
		}
//		} else if (studentData != null) {
//			System.out.println("student part" + studentData);
//			model.addAttribute("name", studentData.getStudentName());
//			model.addAttribute("email", studentData.getEmail());
//			return "student/studentDashboard";
//		} 
		else {
			return "login";
		}
	}

//	@PostMapping("/login")
//	public String saveLogin(Model model, @ModelAttribute("login") Admin admin, Student student) {
//		Admin userData = adminService.adminlogin(admin);
//		Student studentData= studentService.StudentLogin(student);
//		System.out.println("Loged in data :: " + userData);
//		if (userData == null) {
//			return "login";
//		}else if(studentData!=null){
//			model.addAttribute("name", studentData.getStudentName());
//			return "student/studentDashboard";
//		}
//		else {
//			model.addAttribute("id", userData.getId());
//			model.addAttribute("username", userData.getUsername());
//			model.addAttribute("email", userData.getEmail());
//			model.addAttribute("pass", userData.getPassword());
//			return "admin/adminDashBoard";
//		}
//	}

//	@RequestMapping("/adminDashBoard{id}")
//	public String adminDashBoard(Model model, Admin admin, @RequestParam int id) {
//		Optional<Admin> data = adminService.getAdmin(id);
//		Admin userData = data.get();
//		model.addAttribute("id", userData.getId());
//		model.addAttribute("username", userData.getUsername());
//		model.addAttribute("email", userData.getEmail());
//		model.addAttribute("pass", userData.getPassword());
//		System.out.println("Admin Profile....");
//		return "admin/adminDashBoard";
//	}
//
//	@RequestMapping(value = "/adminDashBoard", method = RequestMethod.POST)
//	public String updateAdmin(@ModelAttribute("admin/bupdate") Admin admin) {
//		System.out.println("updating data...");
//		adminService.updateAdmin(admin);
//		System.out.println("update successfully ::" + adminService.updateAdmin(admin));
//		return "admin/adminDashBoard";
//	}

	@GetMapping("/showLogin")
	public ModelAndView showLogin() {
		List<Admin> loginList = adminService.fetchAdmin();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("loginList", loginList);
		return mv;
	}
// .........................End login Controller....................................
// ........................Start DashBoard Controller ...............................

	@PostMapping("/adminadds")
	public Admin addAdmin(@RequestBody Admin admin) {
		System.out.println("admin Panle...");
		Admin var = this.adminService.addAdmin(admin);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/admin")
	public List<Admin> getAdmins(Model model) {
		List<Admin> admins = adminService.getAdmins();
		model.addAttribute("admins", adminService.getAdmins());
		System.out.println("Fetech All Student Data ::" + admins);
		return admins;
	}

	@GetMapping("/admin/{adminid}")
	public String getAdmin(@PathVariable("adminid") int adminid, Model model) {
		Optional<Admin> adminsDashBoard = this.adminService.getAdmin(adminid);
		model.addAttribute("admin", adminsDashBoard);
		return "adminDashBoard";
	}

//	@GetMapping("/adminDashBoard")
//	public String adminUpdate(Admin admin) {
//		System.out.println("Update Profile runing mood 2332....");
//		return "admin/adminDashBoard";
//	}

	@PostMapping("/adminDashBoard")
	public String updateAdmin(@ModelAttribute("admin/adminDashBoard") Admin admin,Model model) {
		System.out.println("Updating...");
		adminService.updateAdmin(admin);
		List<Admin> admins = adminService.getAdmins();
		model.addAttribute("admins", adminService.getAdmins());
		System.out.println("Updated successfully ::" + adminService.updateAdmin(admin));
		return "admin/adminDashBoard";
	}

	@DeleteMapping("/adeletes/{adminId}")
	public void deleteAdmin(@PathVariable int adminId, Model model) {
		this.adminService.deleteAdmin(adminId);
		List<Admin> admins = adminService.getAdmins();
		model.addAttribute("admins", adminService.getAdmins());
		System.out.println("Deleted Successfully!!!");
	}

	@GetMapping("/changePassword/{id}")
	public String changePasswords(Admin admin) {
		System.out.println("Update password runing mood....");
		return "adminDashBoard";
	}

	@RequestMapping("/changePassword/{id}")
	public String ChangePassword(@ModelAttribute("adminDashBoard") Admin admin) {
		System.out.println("Updating...");
		adminService.changePassword(admin);
		System.out.println("Change Password successfully ::" + adminService.updateAdmin(admin));

		return "admin/adminDashBoard";
	}

//........................End DashBoard Controller ..........................

// ........................Start Chapter handler............................

	@RequestMapping(value = "/addchapter", method = RequestMethod.GET)
	public String addChapter(Model model) {
		model.addAttribute("title", "AddChapter-Student Management System");
		Chapter chapter = new Chapter();
		model.addAttribute("chapter", chapter);
		return "admin/addchapter";
	}

	@RequestMapping(value = "/addchapter", method = RequestMethod.POST)
	public String insertChapter(@ModelAttribute("admin/addchapter") Chapter chapter) {
		System.out.println("Chapter Adding...");
		chapterService.addChapter(chapter);
		System.out.println("data inserted value ::" + chapterService.addChapter(chapter));
		return "redirect:/admin/profile";
	}

	@RequestMapping("/viewchapter")
	public String viewChapter(Model model, Chapter chapter) {
		model.addAttribute("title", "View Chapter-Student Management System");
		System.out.println("Showing..........Chapter data");
		List<Chapter> chapter1 = chapterService.getChapters();
		model.addAttribute("chapter", chapter1);
		return "admin/viewchapter";
	}

	@RequestMapping("/updateChapter{id}")
	public String updateChapter(Model model, Chapter chapter, @PathVariable("id") int id) {
		System.out.println("update method...");
		model.addAttribute("chapter", chapter);
		Optional<Chapter> data = chapterService.getChapter(id);

		Chapter as = data.get();
		model.addAttribute("id", as.getId());
		model.addAttribute("chapName", as.getChapName());
		model.addAttribute("chapDescription", as.getChapDescription());
		model.addAttribute("subid", as.getSubid());
		return "admin/updateChapter";
	}

	@PostMapping("/updateChapter")
	public String updateChaters(@ModelAttribute("admin/updateChapter") Chapter chapter) {
		System.out.println("updating data...");
		chapterService.updateChapter(chapter);
		System.out.println("update successfully ::" + chapterService.updateChapter(chapter));
		return "admin/viewchapter";
	}

	@PostMapping("/deleteChapter/{id}")
	public void deleteChapter(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		chapterDao.deleteById(id);
		List<Chapter> chapter1 = chapterService.getChapters();
		model.addAttribute("chapter", chapter1);
		System.out.println("Delete successfully...");
	}

//	@RequestMapping("/frontAdmin")
//	public String frontAdmin(){
//		
//		System.out.println("Actual Admin DashBoard....");
//		return "admin/frontAdmin";
//	}

// ........................End Chapter handler............................	

//	@RequestMapping("/signup")
//	public String signup(Model model) {
//		model.addAttribute("title", "Registration-Student Management System");
//		model.addAttribute("student", new Student());
//		return "signup";
//	}

}
