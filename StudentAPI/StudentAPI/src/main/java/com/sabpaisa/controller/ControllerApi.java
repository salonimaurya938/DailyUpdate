package com.sabpaisa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sabpaisa.dao.QuizDao;
import com.sabpaisa.dao.StudentDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.Quiz;
import com.sabpaisa.entity.Student;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.BookService;
import com.sabpaisa.service.ChapterService;
import com.sabpaisa.service.HomeWorkService;
import com.sabpaisa.service.QuizService;
import com.sabpaisa.service.StudentService;

@RestController
public class ControllerApi {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired 
	private HomeWorkService homeWorkService;
	
	@Autowired
	private StudentDao studendDao;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuizDao quizDao;
	
	///////////////////////////// Student Controller //////////////////////////////

	@PostMapping("/studentsadd")
	public Student addStudent(@RequestBody Student student) {
		System.out.println("saloni");
		Student var = this.studentService.addStudent(student);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/studentsApi")
	public List<Student> getStudents() {
		List<Student> var = this.studentService.getStudents();
		System.out.println("Fetech All Student Data ::" + var);
		return var;
	}

	@GetMapping("/students/{studentId}")
	public Optional<Student> getStudent(@PathVariable("studentId") int studentId) {
		return this.studentService.getStudent(studentId);
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		Student var = this.studentService.updateStudent(student);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/sdelete/{studentId}")
	public void deleteStudent(@PathVariable int studentId) {
		this.studentService.deleteStudent(studentId);
		System.out.println("Deleted Successfully!!!");
	}

//	///////////////////////////// Admin Controller //////////////////////////////
//
	@PostMapping("/adminadd")
	public Admin addAdmin(@RequestBody Admin admin) {
		System.out.println("admin Panle...");
		Admin var = this.adminService.addAdmin(admin);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/admins")
	public List<Admin> getAdmins(Model model) {
		List<Admin> admins = this.adminService.getAdmins();
		model.addAttribute("admins", admins);
		System.out.println("Fetech All Student Data ::" + admins);
		return admins;
	}

	@GetMapping("/admins/{adminid}")
	public Optional<Admin> getAdmin(@PathVariable("adminid") int adminid) {
		return this.adminService.getAdmin(adminid);
	}

	@PutMapping("/adminUpdate")
	public Admin updateAdmin(@RequestBody Admin admin) {
		System.out.println("test...");
		Admin var = this.adminService.updateAdmin(admin);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/adelete/{adminId}")
	public void deleteAdmin(@PathVariable int adminId) {
		this.adminService.deleteAdmin(adminId);
		System.out.println("Deleted Successfully!!!");
	}	
	
//	login handler............
	
	@PostMapping("/logins")
	public Admin saveLogin(Model model, @ModelAttribute("login") Admin admin) {      
       Admin userData= adminService.adminlogin(admin);     
       System.out.println("userData :: "+userData);       
   	if (userData == null) {
		System.out.println("error");
	} else {
		model.addAttribute("username", userData.getUsername());
		model.addAttribute("email", userData.getEmail());
		return userData;
	}
	return userData;
	
	}
	
	
//	Subject Controller Handler.........................................

//	@PostMapping("/bookadds")
//	public Book addBook(@RequestBody Book Book,MultipartFile subIcon) {
//		System.out.println("Book Panle...");
//		Book var = this.bookService.addBook(Book,subIcon);
//		System.out.println("Inserted successfully ::" + var);
//		return var;
//	}

	@GetMapping("/book")
	public List<Book> getBooks(Model model) {
		List<Book> Books = bookService.getBooks();
		model.addAttribute("Books", bookService.getBooks());
		System.out.println("Fetech All Student Data ::" + Books);
		return Books;
	}

	@GetMapping("/book/{bookid}")
	public String getBook(@PathVariable("Bookid") int Bookid, Model model) {
	       Optional<Book> BooksDashBoard =this.bookService.getBook(Bookid);
	       model.addAttribute("Book", BooksDashBoard);
		return "BookDashBoard";
	}

	@PutMapping("/booksUpdate")
	public Book updateBook(@RequestBody Book Book) {
		System.out.println("test...");
		Book var = this.bookService.updateBook(Book);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/adeletes/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		this.bookService.deleteBook(bookId);
		System.out.println("Deleted Successfully!!!");
	}
	
//	 Chapter controller handler ....................
	
	
	@PostMapping("/Chapteradd")
	public Chapter addChapter(@RequestBody Chapter chapter) {
		System.out.println("chapter Panle...");
		Chapter var = this.chapterService.addChapter(chapter);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/chapters")
	public List<Chapter> getChapter(Model model) {
		List<Chapter> Chapters = chapterService.getChapters();
		model.addAttribute("Chapters", chapterService.getChapters());
		System.out.println("Fetech All Student Data ::" + Chapters);
		return Chapters;
	}

	@GetMapping("/chapter/{chapterid}")
	public String getChapter(@PathVariable("chapterid") int chapterid, Model model) {
	       Optional<Chapter> chapter =this.chapterService.getChapter(chapterid);
	       model.addAttribute("chapter", chapter);
		return "chapter";
	}

	@PutMapping("/chapterUpdate")
	public Chapter updateChapter(@RequestBody Chapter chapter) {
		System.out.println("test...");
		Chapter var = this.chapterService.updateChapter(chapter);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/cdeletes/{chapterid}")
	public void deleteChapter(@PathVariable int chapterid) {
		this.chapterService.deleteChapter(chapterid);
		System.out.println("Deleted Successfully!!!");
	}
	
	
//	 HomeWork controller handler ....................
	
	
	@PostMapping("/homeWorkadd")
	public HomeWork addHomeWork(@RequestBody HomeWork homeWork) {
		System.out.println("HomeWork Panle...");
		HomeWork var = this.homeWorkService.addHomeWork(homeWork);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/homeWorks")
	public List<HomeWork> getHomeWorks(Model model) {
		List<HomeWork> homeWork = homeWorkService.getHomeWorks();
		model.addAttribute("HomeWork", homeWorkService.getHomeWorks());
		System.out.println("Fetech All Student Data ::" + homeWork);
		return homeWork;
	}

	@GetMapping("/homeWork/{homeWorkid}")
	public String getHomeWork(@PathVariable("homeWorkid") int homeWorkid, Model model) {
	       Optional<HomeWork> homeWork =this.homeWorkService.gethomeWork(homeWorkid);
	       model.addAttribute("homeWork", homeWork);
		return "homeWork";
	}

	@PutMapping("/homeWorkUpdate")
	public HomeWork updateHomeWork(@RequestBody HomeWork homeWork) {
		System.out.println("test...");
		HomeWork var = this.homeWorkService.updateHomeWork(homeWork);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/cdeletes/{homeWorkid}")
	public void deleteHomeWork(@PathVariable int homeWorkid) {
		this.homeWorkService.deleteHomeWork(homeWorkid);
		System.out.println("Deleted Successfully!!!");
	}	
	

	@GetMapping("/quizs")
	public List<Quiz> getquiz(Model model) {
		List<Quiz> quiz = quizDao.findAll();
		model.addAttribute("quiz", quiz);
		System.out.println("Fetech All quz Data ::" + quiz);
		return quizDao.findAll();
	}
	
	

	
}
