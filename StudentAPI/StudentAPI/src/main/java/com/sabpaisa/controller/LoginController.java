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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.Student;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.BookService;
import com.sabpaisa.service.ChapterService;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;


	@Autowired
	private ChapterService chapterService;

	public LoginController(AdminService adminService) {
		super();
		this.adminService = adminService;
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
	public String saveLogin(Model model, @ModelAttribute("login") Admin admin) {
		Admin userData = adminService.adminlogin(admin);
		System.out.println("Loged in data :: " + userData);
		if (userData == null) {
			return "login";
		} else {
			model.addAttribute("id", userData.getId());
			model.addAttribute("username", userData.getUsername());
			model.addAttribute("email", userData.getEmail());
			model.addAttribute("pass", userData.getPassword());
			return "admin/adminDashBoard";
		}
	}

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

	@GetMapping("/adminDashBoard")
	public String adminUpdate(Admin admin) {
		System.out.println("Update Profile runing mood 2332....");
		return "admin/adminDashBoard";
	}

	@PostMapping("/adminDashBoard")
	public String updateAdmin(@ModelAttribute("admin/adminDashBoard")Admin admin) {		
		System.out.println("Updating...");		
		adminService.updateAdmin(admin);
		System.out.println("Updated successfully ::" + adminService.updateAdmin(admin));
		return "admin/adminDashBoard";
	}

	@DeleteMapping("/adeletes/{adminId}")
	public void deleteAdmin(@PathVariable int adminId) {
		this.adminService.deleteAdmin(adminId);
		System.out.println("Deleted Successfully!!!");
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

// ........................End Chapter handler............................	

//	@RequestMapping("/signup")
//	public String signup(Model model) {
//		model.addAttribute("title", "Registration-Student Management System");
//		model.addAttribute("student", new Student());
//		return "signup";
//	}
	
}
