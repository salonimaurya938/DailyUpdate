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
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.session.SessionRepository;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.sabpaisa.dao.CategoryDao;
import com.sabpaisa.dao.ChapterDao;
import com.sabpaisa.dao.ImagesDao;
import com.sabpaisa.dao.OptionDao;
import com.sabpaisa.dao.QuizDao;
import com.sabpaisa.dao.UploadCourseDao;
import com.sabpaisa.dao.feeDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Admission;
import com.sabpaisa.entity.AdmissionEnquiry;
import com.sabpaisa.entity.AdmissionReport;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Category;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.Events;
import com.sabpaisa.entity.Fee;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.Images;
import com.sabpaisa.entity.Option;
import com.sabpaisa.entity.Quiz;
import com.sabpaisa.entity.QuizDetails;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.entity.TimeTable;
import com.sabpaisa.entity.UploadCourses;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.AdmissionEnquiryService;
import com.sabpaisa.service.AdmissionReportService;
import com.sabpaisa.service.AdmissionServices;
import com.sabpaisa.service.BookService;
import com.sabpaisa.service.ChapterService;
import com.sabpaisa.service.EventsService;
import com.sabpaisa.service.FeeService;
import com.sabpaisa.service.HomeWorkService;
import com.sabpaisa.service.QuizDetailsServices;
import com.sabpaisa.service.QuizService;
import com.sabpaisa.service.StudentResultService;
import com.sabpaisa.service.StudentService;
import com.sabpaisa.service.TimeTableService;
import com.sabpaisa.service.UploadCourseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	private QuizDetailsServices quizDetailsServices;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private AdmissionEnquiryService admissionEnquiryService;

	@Autowired
	private AdmissionServices admissionServices;

	@Autowired
	private BookService bookService;

	@Autowired
	private ImagesDao imagesDao;

	@Autowired
	private HomeWorkService homeWorkService;

	@Autowired
	private StudentResultService studentResultService;

	@Autowired
	private AdmissionReportService admissionReportService;

	@Autowired
	private EventsService eventsService;

	@Autowired
	private TimeTableService timeTableService;
	
	@Autowired
	private OptionDao optionDao;

	public LoginController(AdminService adminService, StudentService studentService) {
		super();
		this.adminService = adminService;
		this.studentService = studentService;
	}

// .........................End login Controller..................................
	@GetMapping("/adminlogin")
	public ModelAndView login() {
		System.out.println("Project runing mood....");
		ModelAndView ma = new ModelAndView("adminlogin");
		ma.addObject("adminlogin", new Admin());
		return ma;
	}

	@PostMapping("/adminlogin")
	public String saveLogin(Model model, @ModelAttribute("adminlogin") Admin admin,HttpSession session) {
		Admin userData = adminService.adminlogin(admin);
		System.out.println("Admin login :: " + userData);
		// Admin userData =
		// adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());

		if (userData != null) {
			session.setAttribute("email", userData.getEmail());
			session.setAttribute("username", userData.getUsername());
			model.addAttribute("id", userData.getId());
			model.addAttribute("username", userData.getUsername());
			model.addAttribute("email", userData.getEmail());
			model.addAttribute("pass", userData.getPassword());
			
			List<AdmissionEnquiry> a = admissionEnquiryService.getAdmissionEnquiry();
			System.out.println("enqury details ..." + a);
			model.addAttribute("enq", a);

			List<Admission> b = admissionServices.getAdmissions();
			System.out.println("Admission Details..." + b);
			model.addAttribute("admission", b);

			List<Book> c = bookService.getBooks();
			System.out.println("Book Details..." + c);
			model.addAttribute("addBook", c);

			List<Chapter> d = chapterService.getChapters();
			System.out.println("Chapter Details..." + d);
			model.addAttribute("chapter", d);

			List<UploadCourses> e = uploadCourseService.getUploadCourse();
			System.out.println("Course Details..." + e);
			model.addAttribute("course", e);

			List<Category> f = categoryDao.findAll();
			System.out.println("Category Details..." + f);
			model.addAttribute("cate", f);

			List<Images> g = imagesDao.findAll();
			System.out.println("Images Details..." + g);
			model.addAttribute("img", g);

			List<HomeWork> h = homeWorkService.getHomeWorks();
			System.out.println("HomeWork Details..." + h);
			model.addAttribute("homework", h);

			List<StudentResult> i = studentResultService.getStudentResults();
			System.out.println("StudentResult Details..." + i);
			model.addAttribute("result", i);

			List<AdmissionReport> j = admissionReportService.getAdmissionReport();
			System.out.println("Report Details..." + j);
			model.addAttribute("report", j);

			List<Events> k = eventsService.getEvents();
			System.out.println("Events Details..." + k);
			model.addAttribute("event", k);

			List<TimeTable> l = timeTableService.getTimeTables();
			System.out.println("=Time Table Details..." + l);
			model.addAttribute("timetable", l);			
			return "admin/adminDashBoard";
		} else {
			return "adminlogin";
		}
	}

	@RequestMapping("/adminDashBoard")
	public String dashBoard(Model model) {
		List<AdmissionEnquiry> a = admissionEnquiryService.getAdmissionEnquiry();
		System.out.println("enqury details ..." + a);
		model.addAttribute("enq", a);

		List<Admission> b = admissionServices.getAdmissions();
		System.out.println("Admission Details..." + b);
		model.addAttribute("admission", b);

		List<Book> c = bookService.getBooks();
		System.out.println("Book Details..." + c);
		model.addAttribute("addBook", c);

		List<Chapter> d = chapterService.getChapters();
		System.out.println("Chapter Details..." + d);
		model.addAttribute("chapter", d);

		List<UploadCourses> e = uploadCourseService.getUploadCourse();
		System.out.println("Course Details..." + e);
		model.addAttribute("course", e);

		List<Category> f = categoryDao.findAll();
		System.out.println("Category Details..." + f);
		model.addAttribute("cate", f);

		List<Images> g = imagesDao.findAll();
		System.out.println("Images Details..." + g);
		model.addAttribute("img", g);

		List<HomeWork> h = homeWorkService.getHomeWorks();
		System.out.println("HomeWork Details..." + h);
		model.addAttribute("homework", h);

		List<StudentResult> i = studentResultService.getStudentResults();
		System.out.println("StudentResult Details..." + i);
		model.addAttribute("result", i);

		List<AdmissionReport> j = admissionReportService.getAdmissionReport();
		System.out.println("Report Details..." + j);
		model.addAttribute("report", j);

		List<Events> k = eventsService.getEvents();
		System.out.println("Events Details..." + k);
		model.addAttribute("event", k);

		List<TimeTable> l = timeTableService.getTimeTables();
		System.out.println("=Time Table Details..." + l);
		model.addAttribute("timetable", l);

//		List<Book> m= bookService.getBooks();
//		System.out.println("Book Details..."+c);
//		model.addAttribute("addBook", c);
		return "admin/adminDashBoard";
	}

	@RequestMapping("/uploadCourses")
	public String uploadCourse() {
		return "admin/uploadCourses";
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

	@RequestMapping("/adminProfile")
	public String adminProfile(Admin admin) {
		System.out.println("admin Profile....");
		return "admin/adminProfile";
	}

	@PostMapping("/adminDashBoard")
	public String updateAdmin(@ModelAttribute("admin/adminDashBoard") Admin admin, Model model) {
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

	@GetMapping("/updateChapter{id}")
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

//............................UploadCourse handler.................................

	@RequestMapping(value = "/uploadCourses", method = RequestMethod.GET)
	public String adduploadCourse(Model model) {
		model.addAttribute("title", "UploadCourse-Student Management System");
		UploadCourses uplodeVideo = new UploadCourses();
		model.addAttribute("uplodeVideo", uplodeVideo);
		List<UploadCourses> data = uploadCourseService.getUploadCourse();
		model.addAttribute("data", data);
		return "admin/uploadCourses";
	}

	@PostMapping("/uploadCourses")
	public String uploadCourse(@ModelAttribute("admin/uploadCourses") @RequestParam MultipartFile uploadCourse,
			String title, String discription, String classes, String lesson, Model model) throws IOException {
		System.out.println("switching...");
		UploadCourses upload = new UploadCourses();
		UploadCourses im = uploadCourseService.addUploadCourse(upload);
		im.setUploadCourse(uploadCourse.getOriginalFilename());
		im.setTitle(title);
		im.setDiscription(discription);
		im.setClasses(classes);
		im.setLesson(lesson);
		UploadCourses video = uploadCourseService.addUploadCourse(upload);
		if (uploadCourse != null) {
			try {
				File saveFile = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + uploadCourse.getOriginalFilename());
				System.out.println(path);
				Files.copy(uploadCourse.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				uploadCourseService.addUploadCourse(upload);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		System.out.println("msg ::  Video Upload Successfully");
		return "admin/uploadCourses";
	}

//	@RequestMapping(value = "/uploadCourse", method = RequestMethod.POST)
//	public String insertuploadCourse(@ModelAttribute("admin/uploadCourse") UploadCourses uploadCourses) {
//		System.out.println("uploadCourse Adding...");
//		uploadCourseService.addUploadCourse(uploadCourses);
//		System.out.println("data inserted value ::" + uploadCourseService.addUploadCourse(uploadCourses));
//		return "admin/uploadCourse";
//	}

	@RequestMapping("/viewUploadCourse")
	public String viewUploadCourses(Model model, UploadCourses viewUploadCourse) {
		model.addAttribute("title", "View Chapter-Student Management System");
		System.out.println("Showing..........Chapter data");
		List<UploadCourses> uploadCourses = uploadCourseService.getUploadCourse();
		model.addAttribute("uploadCourses", uploadCourses);
		return "admin/viewUploadCourse";
	}

	@GetMapping("/updateUploadCourse{id}")
	public String updateuploadCourse(Model model, UploadCourses uploadCourses, @PathVariable("id") int id) {
		System.out.println("update method...");
		model.addAttribute("data", uploadCourses);
		Optional<UploadCourses> data = uploadCourseService.getUploadCourse(id);
		UploadCourses as = data.get();
		model.addAttribute("id", as.getId());
		model.addAttribute("title", as.getTitle());
		model.addAttribute("discription", as.getDiscription());
		model.addAttribute("class", as.getClasses());
		model.addAttribute("lesson", as.getLesson());
		model.addAttribute("upload", as.getUploadCourse());
		return "admin/updateUploadCourse";
	}

	@PostMapping("/updateUploadCourse")
	public String updateCourse(@ModelAttribute("admin/updateUploadCourse") @RequestParam MultipartFile uploadCourse,
			String title, String discription, String classes, String lesson, Model model) throws IOException {
		System.out.println("switching...");
		UploadCourses upload = new UploadCourses();
		UploadCourses im = uploadCourseService.updateUploadCourse(upload);
		im.setUploadCourse(uploadCourse.getOriginalFilename());
		im.setTitle(title);
		im.setDiscription(discription);
		im.setClasses(classes);
		im.setLesson(lesson);
		UploadCourses video = uploadCourseService.updateUploadCourse(upload);
		if (uploadCourse != null) {
			try {
				File saveFile = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + uploadCourse.getOriginalFilename());
				System.out.println(path);
				Files.copy(uploadCourse.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				uploadCourseService.updateUploadCourse(upload);
				List<UploadCourses> data = uploadCourseService.getUploadCourse();
				model.addAttribute("data", data);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		System.out.println("msg ::  update Successfully");
		return "admin/uploadCourses";
	}

	@PostMapping("/deletesUploads{id}")
	public String deleteuploadCourse(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		uploadCourseDao.deleteById(id);
		List<UploadCourses> data = uploadCourseService.getUploadCourse();
		model.addAttribute("data", data);
		System.out.println("Delete successfully...");
		return "admin/uploadCourses";
	}

	// ...............................Fee Controller................................

	@RequestMapping(value = "/fee", method = RequestMethod.GET)
	public String addFee(Model model) {
		model.addAttribute("title", "AddQuiz-School Management System");
		Fee fee = new Fee();
		model.addAttribute("quiz", fee);
		List<Fee> fees = feeService.getfee();
		model.addAttribute("data", fees);
		return "admin/fee";
	}

	@RequestMapping(value = "/fee", method = RequestMethod.POST)
	public String insertfee(@ModelAttribute("admin/fee") Fee fee, Model model) {
		System.out.println("fee Adding...");
		feeService.addfee(fee);
		System.out.println("data inserted value ::" + feeService.addfee(fee));
		List<Fee> fees = feeService.getfee();
		model.addAttribute("data", fees);
		return "admin/fee";
	}

	@PostMapping("/deletesfee{id}")
	public String deletefee(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		feeDao.deleteById(id);
		List<Fee> data = feeService.getfee();
		model.addAttribute("data", data);
		System.out.println("Delete successfully...");
		return "admin/fee";
	}

	// ...............................Quiz
	// Controller................................

	@RequestMapping(value = "/quiz", method = RequestMethod.GET)
	public String addQuiz(Model model) {
		model.addAttribute("title", "AddQuiz-School Management System");
		List<Quiz> quizs = quizService.getQuiz();
		model.addAttribute("quiz", quizs);
		System.out.println("quiz details :: " + quizs);
		
		List<Category> data = categoryDao.findAll();
		model.addAttribute("cate", data);
		System.out.println("Category value :: " + data);
		
		List<Option> opt=optionDao.findAll();
		model.addAttribute("opt", opt);
		System.out.println("Otion Data :: "+ opt);
		
		return "admin/quiz";
	}
	@RequestMapping(value = "/quiz", method = RequestMethod.POST)
	public String insertQuiz(@ModelAttribute("admin/quiz")Quiz quiz,Option option,String op1, String op2, String op3,String op4) {		
		System.out.println("uri section..."+ quiz);	    

	    Option optionsave= optionDao.save(option);	
	    System.out.println("options insert in table .."+optionsave);
	    
	    
	    Quiz saveFormData= quizService.addQuiz(quiz);
	    System.out.println("::.."+saveFormData);
	    
		return "admin/quiz";
	}

//	@RequestMapping(value = "/quiz", method = RequestMethod.POST)
//	public String insertQuiz(@ModelAttribute("admin/quiz") @RequestParam List<Option> option,String question,String answer,String 
//			category,String  score, String status, String op1, String op2, String op3, String op4, Quiz quisz) {		
//		System.out.println("uri section..."+ quisz);
//	    Quiz saveFormData= quizService.addQuiz(quisz);
//	    System.out.println("::.."+saveFormData);
//		Quiz quiz = new Quiz();
//		Quiz im = quizService.addQuiz(quiz);
//		im.setOption(option);
//		im.setQuestion(question);
//		im.setAnswer(answer);
//		im.setCategory(category);
//		im.setScore(score);
//		im.setStatus(status);
//		Quiz addquiz= quizService.addQuiz(quiz);		
//		System.out.println("data inserted value ::" + addquiz);
//		
//		Option options= new Option();
//	    Option in= optionDao.save(options);
//	    in.setOp1(op1);
//	    in.setOp2(op2);
//	    in.setOp3(op3);
//	    in.setOp4(op4);
//	    Option optionsave= optionDao.save(options);
//	    System.out.println("options insert in table .."+optionsave);
//		return "admin/quiz";
//	}

//	@RequestMapping("/viewQuiz")
//	public String viewquiz(Model model, Quiz quiz) {
//		model.addAttribute("title", "View Quiz Details-School Management System");
//		System.out.println("Quiz Details ...");
//		List<Quiz> quizs = quizService.getQuiz();
//		model.addAttribute("datas", quizs);
//		return "admin/viewQuiz";
//	}

	@GetMapping("/updateQuiz{id}")
	public String updateQuiz(Model model, Chapter chapter, @PathVariable("id") int id) {
		System.out.println("update method...");
		model.addAttribute("chapter", chapter);
		Optional<Quiz> data = quizService.getQuizId(id);
		Optional<Option> optdata = quizService.getOptionId(id);
		Quiz as = data.get();
		Option rs = optdata.get();
		model.addAttribute("id", as.getId());
		model.addAttribute("question", as.getQuestion());
		model.addAttribute("op1", rs.getOp1());
		model.addAttribute("op2", rs.getOp2());
		model.addAttribute("op3", rs.getOp3());
		model.addAttribute("op4", rs.getOp4());
		return "admin/updateQuiz";
	}

	@PostMapping("/updateQuiz")
	public String updateQuiz(@ModelAttribute("admin/updateQuiz") Quiz quiz, Model model) {
		System.out.println("updating data...");
		quizService.updateQuiz(quiz);
		System.out.println("update successfully ::" + quizService.updateQuiz(quiz));
		List<Quiz> quizs = quizService.getQuiz();
		model.addAttribute("quiz", quizs);

		return "admin/quiz";
	}

	@PostMapping("/deleteQuiz{id}")
	public String deleteQuiz(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		quizDao.deleteById(id);
		List<Quiz> quizs = quizService.getQuiz();
		model.addAttribute("quiz", quizs);
		System.out.println("Delete successfully...");
		return "admin/quiz";
	}

	@RequestMapping(value = "/addQuizDetails", method = RequestMethod.GET)
	public String addQuizs(Model model) {
		model.addAttribute("title", "AddQuizDetails-School Management System");
		QuizDetails quizdetails = new QuizDetails();
		model.addAttribute("quizdetails", quizdetails);
		List<QuizDetails> quizDetails = quizDetailsServices.getQuizDetails();
		model.addAttribute("quizDetails", quizDetails);
		List<Category> data = categoryDao.findAll();
		model.addAttribute("cate", data);
		System.out.println("Quiz Details section...");
		return "admin/addQuizDetails";
	}

	@RequestMapping(value = "/addQuizDetails", method = RequestMethod.POST)
	public String insertedQuizDetails(@ModelAttribute("admin/addQuizDetails") QuizDetails quizDetails, Model model) {
		System.out.println("Quiz Adding...");
		QuizDetails quizs = quizDetailsServices.addQuizDetails(quizDetails);
		System.out.println("data inserted value ::" + quizs);
		return "admin/quiz";
	}

	// .....................................Session
	// Controller................................
//	@GetMapping("/sessions")
//	public String process(Model model, HttpSession session) {
//		@SuppressWarnings("unchecked")
//		List<String> messages = (List<String>) session.getAttribute("this is session");
//		System.out.println("session1...");
//		if (messages == null) {
//			messages = new ArrayList<>();
//			System.out.println("session2...");
//		}
//		System.out.println("session3...");
//		model.addAttribute("sessionMessages", messages);
//		return "redirect:/";
//	}
//
//	@PostMapping("/sessions")
//	public String Proccess(@RequestParam("msg") String msg, HttpServletRequest request) {
//		@SuppressWarnings("unchecked")
//		List<String> messages = (List<String>) request.getSession().getAttribute(msg);
//		System.out.println("session4...");
//		if (messages == null) {
//			messages = new ArrayList<>();
//			System.out.println("session5...");
//			request.getSession().setAttribute("MY_SESSION_MSG", messages);
//		}
//		System.out.println("session6...");
//		messages.add(msg);
//		request.getSession().setAttribute("NOTES_SESSION", messages);
//		return "redirect:/index";
//
//	}
//
//	@PostMapping("/destoryss")
//	public String destorySession(HttpServletRequest request) {
//		request.getSession().invalidate();
//		return "redirect:/";
//	}

	// .......................................Add
	// Category............................

	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addCategory(Category category, Model model) {
		System.out.println("Category Section...");
		List<Category> data = categoryDao.findAll();
		model.addAttribute("cate", data);
		System.out.println("Category value..." + data);
		return "admin/addCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String insertCategory(@ModelAttribute("admin/addCategory") Category category) {
		Category add = categoryDao.save(category);
		System.out.println("insert Category data..." + add);
		return "admin/addCategory";
	}
	
	
	@GetMapping("/home")
	public String process(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

		if (messages == null) {
			messages = new ArrayList<>();
		}
		model.addAttribute("sessionMessages", messages);

		return "home";
	}

	@PostMapping("/persistMessage")
	public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		System.out.println("message ..."+messages);
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);
		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "redirect:home";
	}

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:home";
	}

	//...........................Notice Board....................................
	
	@RequestMapping("/noticeBoards")
	public String Notice() {
		System.out.println("notice board admin section");
		return "admin/noticeBoards";
	}
	
	//...........................Banner Controller..........................................
	
	@RequestMapping("/addBanner")
	public String banneradd() {
		System.out.println("Banner Section ...");		
		return "admin/addBanner";
	}
}
