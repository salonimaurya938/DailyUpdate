package com.sabpaisa.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.dao.AdmissionDao;
import com.sabpaisa.dao.AdmissionEnquiryDao;
import com.sabpaisa.dao.AdmissionReportDao;
import com.sabpaisa.dao.BookDao;
import com.sabpaisa.dao.CategoryDao;
import com.sabpaisa.dao.ChapterDao;
import com.sabpaisa.dao.ComplaintsDao;
import com.sabpaisa.dao.EventsDao;
import com.sabpaisa.dao.HomeWorkDao;
import com.sabpaisa.dao.ImagesDao;
import com.sabpaisa.dao.OptionDao;
import com.sabpaisa.dao.QuizDao;
import com.sabpaisa.dao.QuizDetailsDao;
import com.sabpaisa.dao.StudentDao;
import com.sabpaisa.dao.StudentResultDao;
import com.sabpaisa.dao.TimeTableDao;
import com.sabpaisa.dao.UploadCourseDao;
import com.sabpaisa.dao.UploadDao;
import com.sabpaisa.dao.feeDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Admission;
import com.sabpaisa.entity.AdmissionEnquiry;
import com.sabpaisa.entity.AdmissionReport;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Category;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.Complaints;
import com.sabpaisa.entity.Events;
import com.sabpaisa.entity.Fee;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.Images;
import com.sabpaisa.entity.Option;
import com.sabpaisa.entity.Quiz;
import com.sabpaisa.entity.QuizAttempted;
import com.sabpaisa.entity.QuizDetails;
import com.sabpaisa.entity.Student;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.entity.TimeTable;
import com.sabpaisa.entity.UploadCourses;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.AdmissionEnquiryService;
import com.sabpaisa.service.AdmissionReportService;
import com.sabpaisa.service.AdmissionServices;
import com.sabpaisa.service.BookService;
import com.sabpaisa.service.ChapterService;
import com.sabpaisa.service.ComplaintsService;
import com.sabpaisa.service.EventsService;
import com.sabpaisa.service.FeeService;
import com.sabpaisa.service.HomeWorkService;
import com.sabpaisa.service.QuizAttemptedService;
import com.sabpaisa.service.QuizDetailsServices;
import com.sabpaisa.service.QuizService;
import com.sabpaisa.service.StudentResultService;
import com.sabpaisa.service.StudentService;
import com.sabpaisa.service.TimeTableService;
import com.sabpaisa.service.UploadCourseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerApi {

	@Autowired
	private BookService bookService;

	@Autowired
	private HomeWorkService homeWorkService;

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

	@Autowired
	private BookDao bookDao;

	@Autowired
	private EventsDao eventsDao;

	@Autowired
	private ComplaintsDao complaintsDao;

	@Autowired
	private ComplaintsService complaintsService;

	@Autowired
	private EventsService eventsService;

	@Autowired
	private HomeWorkDao homeWorkDao;

	@Autowired
	private ChapterDao chapterDao;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private UploadCourseService uploadCourseService;

	@Autowired
	private UploadCourseDao uploadCourseDao;

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuizDao quizDao;

	@Autowired
	private FeeService feeService;

	@Autowired
	private feeDao feeDao;

	@Autowired
	private ImagesDao imagesDao;

	@Autowired
	private StudentResultService studentResultService;

	@Autowired
	private AdmissionReportService admissionReportService;

	@Autowired
	private TimeTableService timeTableService;

	@Autowired
	private OptionDao optionDao;

	@Autowired
	public StudentDao studentDao;

	@Autowired
	public UploadDao uploadDao;

	@Autowired
	private QuizDetailsDao quizDetailsDao;

	@Autowired
	private QuizDetailsServices quizDetailsServices;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private AdmissionDao admissionDao;

	@Autowired
	private StudentResultDao studentResultDao;

	@Autowired
	private TimeTableDao timeTableDao;
	
	@Autowired
	private QuizAttemptedService quizAttemptedService;

	// ...........................................Student Admission Controller.......................................................

	@PostMapping("/saveAdmission")
	public Admission addStudent(@RequestBody Admission admission) {
		System.out.println("admission....");
		Admission var = admissionServices.saveAdmission(admission);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/getAdmission")
	public List<Admission> getStudents() {
		List<Admission> var = this.admissionServices.getAdmissions();
		System.out.println("Fetech All Student Data ::" + var);
		return var;
	}

	@GetMapping("/admission/{admissionId}")
	public Optional<Admission> getStudent(@PathVariable("admissionId") int admissionId) {
		return this.admissionServices.getAdmission(admissionId);
	}

	@PutMapping("/admissionUpdate")
	public Admission updateStudent(@RequestBody Admission student) {
		Admission var = this.admissionServices.updateAdmission(student);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/deleteAdmission/{admissionId}")
	public void deleteStudents(@PathVariable int admissionId) {
		this.admissionServices.deleteAdmission(admissionId);
		System.out.println("Deleted Successfully!!!");
	}

//	.................................................. Admin Controller .....................................................
	
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

//	....................................................................login handler.......................................

	@PostMapping("/logins")
	public Admin saveLogin(Model model, @ModelAttribute("login") Admin admin) {
		Admin userData = adminService.adminlogin(admin);
		System.out.println("userData :: " + userData);
		if (userData == null) {
			System.out.println("error");
		} else {
			model.addAttribute("username", userData.getUsername());
			model.addAttribute("email", userData.getEmail());
			return userData;
		}
		return userData;

	}

//	.............................................Subject Controller Handler.........................................

	@GetMapping("/book")
	public List<Book> getBooks(Model model) {
		List<Book> Books = bookService.getBooks();
		model.addAttribute("Books", bookService.getBooks());
		System.out.println("Fetech All Student Data ::" + Books);
		return Books;
	}

	@GetMapping("/book/{bookid}")
	public String getBook(@PathVariable("Bookid") int Bookid, Model model) {
		Optional<Book> BooksDashBoard = this.bookService.getBook(Bookid);
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
//.................................................... End Book controller handler .........................................
//.................................................... Chapter controller handler .........................................

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
		Optional<Chapter> chapter = this.chapterService.getChapter(chapterid);
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
//..........................................................End Chapter Controller  ..............................................
//..........................................................HomeWork controller handler ..........................................

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
	public Optional<HomeWork> getHomeWork(@PathVariable("homeWorkid") int homeWorkid, Model model) {
		Optional<HomeWork> homeWork = this.homeWorkService.gethomeWork(homeWorkid);
		model.addAttribute("homeWork", homeWork);
		return homeWork;
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
//.........................................End HomeWork Controller ............................................
//..........................................Quiz Controller ...................................................

	@GetMapping("/quizss")
	public List<Quiz> getquiz() {
		List<Quiz> quiz = quizDao.findAll();
		System.out.println("Fetech All quiz Data ::" + quiz);
		return quizDao.findAll();
	}

	
	
	@PostMapping("/insertQuiz")
	public Quiz quizInsert(@RequestBody Quiz quiz) {
		System.out.println("HomeWork Panle...");
		Quiz var = this.quizService.addQuiz(quiz);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/quiz/{quizId}")
	public Optional<Quiz> getHomeWork(@PathVariable("homeWorkid") int quizId) {
		Optional<Quiz> quizs = this.quizService.getQuizId(quizId);
		return quizs;
	}

	@PutMapping("/quizUpdate")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		Quiz var = this.quizService.updateQuiz(quiz);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/qdeletes/{quizId}")
	public void quisDelete(@PathVariable int quizId) {
		this.quizService.deleteQuiz(quizId);
		System.out.println("Deleted Successfully!!!");
	}

//..........................................End Quiz Controller .............................................	
//..........................................AdmissionEnquiry Controller......................................
	@GetMapping("/admissionEnquery")
	public List<AdmissionEnquiry> getadmissionEnquiry() {
		List<AdmissionEnquiry> quiz = admissionEnquiryService.getAdmissionEnquiry();
		System.out.println("Fetech All quiz Data ::" + quiz);
		return admissionEnquiryService.getAdmissionEnquiry();
	}

	
	
	@PostMapping("/addAdmissionEnq")
	public AdmissionEnquiry quizadmissionEnquiry(@RequestBody AdmissionEnquiry admissionEnquiry) {
		System.out.println("HomeWork Panle...");
		AdmissionEnquiry var = this.admissionEnquiryService.addAdmissionEnquiry(admissionEnquiry);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/admissionEnquery/{quizId}")
	public Optional<AdmissionEnquiry> getadmissionEnquiry(@PathVariable("id") int Id) {
		Optional<AdmissionEnquiry> var = this.admissionEnquiryService.getAdmissionEnquiry(Id);
		return var;
	}

	@PutMapping("/updateEnqu")
	public AdmissionEnquiry updateadmissionEnquiry(@RequestBody AdmissionEnquiry admissionEnquiry) {
		AdmissionEnquiry var = this.admissionEnquiryService.updateAdmissionEnquiry(admissionEnquiry);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/admissionEnqDel/{enqId}")
	public void quisadmissionEnquiry(@PathVariable int Id) {
		this.admissionEnquiryService.deleteAdmissionEnquiry(Id);
		System.out.println("Deleted Successfully!!!");
	}	
	
//..........................................AdmissionEnquiry Controller.....................................	
	
//..........................................AdmissionReport Controller .....................................	
	
	
	@GetMapping("/admissionReport")
	public List<AdmissionReport> getadmissionReport() {
		List<AdmissionReport> quiz = admissionReportService.getAdmissionReport();
		System.out.println("Fetech All quiz Data ::" + quiz);
		return admissionReportService.getAdmissionReport();
	}	
	
	@PostMapping("/addAdmissionReport")
	public AdmissionReport quizadmissionReport(@RequestBody AdmissionReport admissionReport) {
		System.out.println("HomeWork Panle...");
		AdmissionReport var = this.admissionReportService.addAdmissionReport(admissionReport);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}   

	@GetMapping("/admissionReport/{quizId}")
	public Optional<AdmissionReport> getadmissionReport(@PathVariable("id") int Id) {
		Optional<AdmissionReport> var = this.admissionReportService.getAdmissionReport(Id);
		return var;
	}

	@PutMapping("/updateReport")
	public AdmissionReport updateadmissionReport(@RequestBody AdmissionReport admissionReport) {
		AdmissionReport var = this.admissionReportService.updateAdmissionReport(admissionReport);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/admissionReportDel/{repId}")
	public void quisadmissionReport(@PathVariable int Id) {
		this.admissionReportService.deleteAdmissionReport(Id);
		System.out.println("Deleted Successfully!!!");
	}	
	
	
//..........................................End AdmissionReport Controller .................................
//..........................................Complaints Controller ..........................................
	
	
	@GetMapping("/complaints")
	public List<Complaints> getComplaints() {
		List<Complaints> var = complaintsService.getComplaints();
		System.out.println("Fetech All Data ::" + var);
		return complaintsService.getComplaints();
	}

	@PostMapping("/addComplaintss")
	public Complaints addComplaints(@RequestBody Complaints complaints) {
		System.out.println("Complaints Panle...");
		Complaints var = this.complaintsService.addComplaints(complaints);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}   

	@GetMapping("/complaint/{quizId}")
	public Optional<Complaints> getbyIdComplaints(@PathVariable("id") int Id) {
		Optional<Complaints> var = this.complaintsService.getComplaints(Id);
		return var;
	}

	@PutMapping("/updateComplaints")
	public Complaints updateComplaints(@RequestBody Complaints complaints) {
		Complaints var = this.complaintsService.updateComplaints(complaints);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/complaintsDel/{id}")
	public void ComplaintsDelete(@PathVariable int id) {
		this.complaintsService.deleteComplaints(id);
		System.out.println("Deleted Successfully!!!");
	}	
	
//..........................................End Complaints Controller.......................................
//..........................................QuizDetails Controller........................................
	
	@GetMapping("/quizDetails")
	public List<QuizDetails> getQuizDetails() {
		List<QuizDetails> var = quizDetailsServices.getQuizDetails();
		System.out.println("Fetech All Data ::" + var);
		return quizDetailsServices.getQuizDetails();
	}

	@PostMapping("/addQuizsDetails")
	public QuizDetails addQuizDetails(@RequestBody QuizDetails quizDetails) {
		System.out.println("Complaints Panle...");
		QuizDetails var = this.quizDetailsServices.addQuizDetails(quizDetails);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}   

	@GetMapping("/quizDetails/{quizId}")
	public Optional<QuizDetails> getbyIdQuizDeOptional(@PathVariable("id") int Id) {
		Optional<QuizDetails> var = this.quizDetailsServices.getQuizDetailsId(Id);
		return var;
	}

	@PutMapping("/updateQuizDetails")
	public QuizDetails updateDetails(@RequestBody QuizDetails quizDetails) {
		QuizDetails var = this.quizDetailsServices.updateQuizDetails(quizDetails);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/quizDetailsDel/{id}")
	public void quizDetailsDelete(@PathVariable int id) {
		this.quizDetailsServices.deleteQuizDetails(id);
		System.out.println("Deleted Successfully!!!");
	}	
	
//..........................................End QuizDetails Controller ...................................	
//..........................................QuizAttempted Controller........................................
	@GetMapping("/quizAttempted")
	public List<QuizAttempted> getQuizAttempts() {
		List<QuizAttempted> var = quizAttemptedService.getAttemptedQuiz();
		System.out.println("Fetech All Data ::" + var);
		return var;
	}

	@PostMapping("/addquizAttempted")
	public QuizAttempted addQuizAttDetails(@RequestBody QuizAttempted quizAttempted) {
		System.out.println("Complaints Panle...");
		QuizAttempted var = this.quizAttemptedService.insertQuizAttempt(quizAttempted);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}   

	@GetMapping("/quizAttempts/{quizId}")
	public Optional<QuizAttempted> getbyIdQuizAttemptsOptional(@PathVariable("id") int Id) {
		Optional<QuizAttempted> var = this.quizAttemptedService.getAttemptedQuiz(Id);
		return var;
	}

	@PutMapping("/updateAttempts")
	public QuizAttempted updateAttempts(@RequestBody QuizAttempted quizAttempted) {
		QuizAttempted var = this.quizAttemptedService.updateQuizAttempt(quizAttempted);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/quizAttemptedDel/{id}")
	public void quizAttemptsDelete(@PathVariable int id) {
		this.quizAttemptedService.deleteAttemptQuiz(id);
		System.out.println("Deleted Successfully!!!");	
	}
	
	
//..........................................End QuizAttempted Controller ...................................
//..........................................QuizAttempted Controller........................................
	
	  
	
	
//..........................................End QuizAttempted Controller ...................................
		
	
}
