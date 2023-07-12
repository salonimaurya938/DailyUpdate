package com.sabpaisa.controller;

import java.util.HashMap;
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

import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.dao.BookDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Book;

import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.BookService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	BookService bookService;
	
//	@Autowired
//	private BookDao bookDao;

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
	
	
//	.......................Book handler................
	
	@RequestMapping("/admin/addBook")
	public String bookBook(Model model) {
		model.addAttribute("title", "AddBook-Student Management System");
		Book book = new Book();		
		model.addAttribute("book", book);
		return "admin/addBook";
	}	
	
	@PostMapping("/admin/addBook")
	public String insertBook(@ModelAttribute("admin/addBook") Book book)
	{
		System.out.println("inserting data..");		
		bookService.addBook(book);
		System.out.println("data inserted value ::"+bookService.addBook(book));
		return "redirect:/admin/profile";
	}
	
	@RequestMapping("/admin/aupdate")
	public String aupdate(Model model) {
		System.out.println("update category......");
		model.addAttribute("title", "Update-Student Management System");
		Optional<Book> book1= bookService.getBook(1);
		Book b=book1.get();
		System.out.println("value of book:: "+b);
		model.addAttribute("subName", b.getSubName());
		model.addAttribute("subIcon", b.getSubIcon());
		model.addAttribute("substatus", b.getSubstatus());
		model.addAttribute("subTitle", b.getSubTitle());
		Book book = new Book();		
		model.addAttribute("update", book);
		return "admin/aupdate";
	}
	
	@PutMapping("/admin/aupdate")
	public String updateBook(@ModelAttribute("admin/aupdate") Book book)
	{
		System.out.println("updating data...");		
		bookService.updateBook(book);
		System.out.println("data update value ::"+bookService.updateBook(book));
		return "redirect:/admin/profile";
	}	
	
	@RequestMapping("/admin/downloadBook")
	public String downloadBook(Model model, Book book) {
		model.addAttribute("title", "Download-Student Management System");
		System.out.println("Showing..........book data");
		model.addAttribute("update", book);
		List<Book> book1= bookService.getBooks();					 
			 model.addAttribute("book", book1);				
		return "admin/downloadBook";
	}
	
	@RequestMapping("/admin/deleteBook")
	public String deleteBook(Model model, Book book) {
		System.out.println("delete.............");
		model.addAttribute("title", "DeleteBook-Student Management System");
//		System.out.println("Deleted data..."+bookService.getBook(delete_id));
//		bookService.deleteBook(1);
//		model.addAttribute("delete_id", );
		return "admin/downloadBook";
	}

	
	
//	Optional<Admin> userdata = adminService.getAdmin(2);
//	Admin admin3 = userdata.get();
//	System.out.println("Username :: " + admin3.getUsername() + "   Password ::" + admin3.getPassword());
//	model.addAttribute("username", admin3.getUsername());
//	model.addAttribute("email", admin3.getEmail());
//	mv.setViewName("admin/adminDashBoard");
	
//	@PostMapping("/addBook")
//	public String bookSave(@ModelAttribute("addBook") Book book, @RequestParam("subIcon")MultipartFile multipartFile) throws IOException {
//		System.out.println("switching...");
//		ModelAndView mv = new ModelAndView("admin/addBook");
//		if(!multipartFile.isEmpty()) {
//			System.out.println("if column...");
//			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
//			book.setSubIcon(fileName);
//			Book bookSave = bookService.addBook(book);
//			String uplaod= "/img/"+ book.getId();
//			Fileuploading.saveFile(uplaod, fileName, multipartFile);
//			
//		}else {
//			System.out.println("else column...");
//			if(book.getSubIcon().isEmpty()) {}
//			book.getSubIcon();
//			bookService.addBook(book);
//			
//		}
//		System.out.println("return column...");
//		bookService.addBook(book);
//		return "admin/saveBook";
//		
//	}


}
