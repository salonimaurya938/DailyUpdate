package com.sabpaisa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Book;
import com.sabpaisa.fileuploading.Fileuploading;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.BookService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired BookService bookService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		System.out.println("Project runing mood....");
		ModelAndView ma = new ModelAndView("login");
		ma.addObject("login", new Admin());
		return ma;
	}

	@PostMapping("/login")
	public ModelAndView saveLogin(@ModelAttribute("login") Admin admin, Model model) {
		System.out.println("admin :: " + admin);
		ModelAndView mv = new ModelAndView("admin/adminDashBoard");
		Admin a = adminService.adminlogin(admin);
		if (a == null) {
			ModelAndView modelAndView = new ModelAndView("admin/output1");
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("invalid", "Error: please use valid Credential");
			modelAndView.addObject("hashMapObject", hashMap);
			return modelAndView;

		} else {
			Optional<Admin> userdata = adminService.getAdmin(2);
			Admin admin3 = userdata.get();
			System.out.println("Username :: " + admin3.getUsername() + "   Password ::" + admin3.getPassword());
			model.addAttribute("username", admin3.getUsername());
			model.addAttribute("email", admin3.getEmail());
			mv.setViewName("admin/adminDashBoard");
			return mv;
		}
	}

	@GetMapping("/showLogin")
	public ModelAndView showLogin() {
		List<Admin> loginList = adminService.fetchAdmin();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("loginList", loginList);
		return mv;
	}

	@RequestMapping("/admin/addBook")
	public ModelAndView addBook(Model model) {
		model.addAttribute("title", "AddBook-Student Management System");
		System.out.println("first block..");
		Book book = new Book();
		model.addAttribute("book", book);
		ModelAndView mv = new ModelAndView("admin/addBook");
		mv.addObject("admin/addBook", new Admin());
		return mv;
	}
	
	@PostMapping("/admin/addBook")
	public String bookSave(Book book, @RequestParam("image")MultipartFile multipartFile) throws IOException {
		System.out.println("switching...");
		ModelAndView mv = new ModelAndView("admin/addBook");
		if(!multipartFile.isEmpty()) {
			System.out.println("if column...");
			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
			book.setSubIcon(fileName);
			Book bookSave = bookService.addBook(book);
			String uplaod= "img/"+ book.getId();
			Fileuploading.saveFile(uplaod, fileName, multipartFile);
			
		}else {
			System.out.println("else column...");
			if(book.getSubIcon().isEmpty()) {}
			book.getSubIcon();
			bookService.addBook(book);
			
		}
		System.out.println("return column...");
		bookService.addBook(book);
		return "admin/saveBook";
		
	}

	@RequestMapping("/admin/downloadBook")
	public String downloadBook(Model model) {
		model.addAttribute("title", "Download-Student Management System");
		return "admin/downloadBook";
	}

	@RequestMapping("/admin/deleteBook")
	public String deleteBook(Model model) {
		model.addAttribute("title", "DeleteBook-Student Management System");
		return "admin/deleteBook";
	}

	@RequestMapping("/admin/aupdate")
	public String aupdate(Model model) {
		model.addAttribute("title", "Update-Student Management System");
		return "admin/aupdate";
	}

	///////////////////////////// Admin Controller //////////////////////////////

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

	@PutMapping("/adminsUpdate")
	public Admin updateAdmin(@RequestBody Admin admin) {
		System.out.println("test...");
		Admin var = this.adminService.updateAdmin(admin);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/adeletes/{adminId}")
	public void deleteAdmin(@PathVariable int adminId) {
		this.adminService.deleteAdmin(adminId);
		System.out.println("Deleted Successfully!!!");
	}

}
