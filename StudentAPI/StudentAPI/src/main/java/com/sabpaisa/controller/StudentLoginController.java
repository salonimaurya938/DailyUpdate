package com.sabpaisa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sabpaisa.entity.Student;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.entity.TimeTable;
import com.sabpaisa.entity.UploadCourses;
import com.sabpaisa.dao.OptionDao;
import com.sabpaisa.dao.QuizDao;
import com.sabpaisa.dao.QuizDetailsDao;
import com.sabpaisa.dao.StudentDao;
import com.sabpaisa.dao.UploadDao;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.Events;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.Images;
import com.sabpaisa.entity.Quiz;
import com.sabpaisa.entity.QuizDetails;
import com.sabpaisa.service.BookService;
import com.sabpaisa.service.ChapterService;
import com.sabpaisa.service.EventsService;
import com.sabpaisa.service.HomeWorkService;
import com.sabpaisa.service.QuizDetailsServices;
import com.sabpaisa.service.QuizService;
import com.sabpaisa.service.StudentResultService;
import com.sabpaisa.service.StudentService;
import com.sabpaisa.service.TimeTableService;
import com.sabpaisa.service.UploadCourseService;

@Controller
public class StudentLoginController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	public StudentDao studentDao;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private EventsService eventsService;
	
	@Autowired
	public UploadDao uploadDao; 
	
	@Autowired
	private HomeWorkService homeWorkService;
	
	@Autowired
	private StudentResultService studentResultService;
	
	@Autowired
	private TimeTableService timeTableService;
	
	@Autowired
	private UploadCourseService uploadCourseService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private OptionDao optionDao;
	
	@Autowired
	private QuizDetailsDao quizDetailsDao;
	
	@Autowired
	private QuizDetailsServices quizDetailsServices;
	
//	@RequestMapping("/register")
//	public String StudentRegistration() {
//		return "register";
//	}
//	
	@GetMapping("/my-account")
	public String addstudents(Model model,Student student) {		
		model.addAttribute("title", "Registration-School Management System");
		model.addAttribute("students", student);		
		return "my-account";
	}
 	
	@PostMapping("/my-account")
	public String addstudent(@ModelAttribute("admin/addEvents") Student student) {		
		studentService.addStudent(student);		
		System.out.println("Data Insrted Successfully :: "+studentService.addStudent(student));		
		return "my-account";
	}
		
	@RequestMapping("/viewRegistration")
	public String viewstuden(Model model) {
		List<Student> as= studentService.getStudents();
		model.addAttribute("students", as);
		return "viewRegistration";
	}
	
	@GetMapping("/login")
	public ModelAndView studentlogin() {
		System.out.println("Project runing mood....");
		ModelAndView ma = new ModelAndView("login");
		ma.addObject("login", new Student());
		return ma;
	}	
	
	@PostMapping("/login")
	public String Studentlogin(Model model, @ModelAttribute("login") Student student) {
		System.out.println(student);
		Student d = studentService.studentLogin(student);
	    String email=d.getEmail();
	    String pass=d.getPassword();
	    System.out.println("student data "+d);
	   if(email!=null && pass!=null) {
		   model.addAttribute("id", d.getId());
			model.addAttribute("username", d.getStudentName());
			model.addAttribute("email", d.getEmail());
			model.addAttribute("mob", d.getMob());
			model.addAttribute("pass", d.getPassword());
			return "student/studentDashboard";
	   }else
		return "login";
	}
	
	@RequestMapping("/studentDashboard")
	public String dashBoard() {
		return "student/studentDashboard";
	}
	
	@RequestMapping("/myProfile")
	public String Student(Student student) {
		ModelAndView ma = new ModelAndView("myProfile");
		System.out.println("my profile...");
		Student d = studentService.studentLogin(student);
		System.out.println("student value"+d);
		return "student/myProfile";
	}
	
	@PostMapping("/myProfile")
	public String studentProfile(Model model,@ModelAttribute("myProfile")Student student) {
		System.out.println("my profile...");
		Student d = studentService.studentLogin(student);
		System.out.println("student value"+d);
	    if(d!=null) {	    	
	    	    model.addAttribute("id", d.getId());
				model.addAttribute("username", d.getStudentName());
				model.addAttribute("email", d.getEmail());
				model.addAttribute("mob", d.getMob());
				model.addAttribute("pass", d.getPassword());	
				return "student/myProfile";
	    }		
		return "student/myProfile";
	}
	
//	@GetMapping("/students ")
//	public Optional<Student> student(Student student, @PathVariable("id") int id) {
//		
////		Optional<Student> ida= studentService.getStudent(id);
//		Optional<Student> studentData = studentService.getStudent(id);
////		Student data=studentData.get(1);
////		System.out.println(data.getEmail());	
//		
//		System.out.println(studentData);
//		return studentData;
//	}

	//..................Book Controller..............................

	@RequestMapping("/viewBook")
	public String downloadBook(Model model, Book book) {
		model.addAttribute("title", "Download-Student Management System");
		System.out.println("Showing..........book data");
		List<Book> book1 = bookService.getBooks();
		model.addAttribute("book", book1);
		return "student/viewBook";
	}
	
	//..................Chapter Controller..............................
	@RequestMapping("/viewchapters")
	public String viewChapters(Model model, Chapter chapter) {
		model.addAttribute("title", "View Chapter-Student Management System");
		System.out.println("Showing..........Chapter data");
		List<Chapter> chapter1 = chapterService.getChapters();
		model.addAttribute("chapter", chapter1);
		return "student/viewchapters";
	}
	//..................Events Controller..............................
	@RequestMapping("/viewEvent")
	public String viewEvents(Model model) {
		List<Events> as= eventsService.getEvents();
		model.addAttribute("events", as);
		return "student/viewEvent";
	}
	//..................Gallery Controller..............................
	@RequestMapping("/viewimg")
	public String viewImg(Model model) {
		List<Images> list = uploadDao.findAll();
		model.addAttribute("lists", list);		
		return "student/viewimg";
	}	
	//..................HomeWork Controller..............................
	@RequestMapping("/viewhomeworks")
	public String viewhomework(Model model, HomeWork homework) {
		model.addAttribute("title", "View HomeWork-School Management System");
		System.out.println("Showing..........homeWork data");
		List<HomeWork> homework1 = homeWorkService.getHomeWorks();
		System.out.println("homework data ::"+homework1);
		model.addAttribute("question", homework1);
		return "student/viewhomeworks";
	}
	//..................Result Controller..............................
	@RequestMapping("/viewResults")
	public String viewResult(Model model) {
		List<StudentResult> list = studentResultService.getStudentResults();
		model.addAttribute("lists", list);
		return "student/viewResults";
	}
	//..................TimeTable Controller..............................
	@GetMapping("/viewTimeTable")
	public String timetableget(Model model) {
		model.addAttribute("title", "TimeTable");
		List<TimeTable> as = timeTableService.getTimeTables();
		System.out.println("Time table data" + as);
		model.addAttribute("timeTables", as);
		return "student/viewTimeTable";
	}
	//.........................Online Courses...................
	@RequestMapping("/onlineCourse")
	public String onlineCourse(Model model) {
		List<UploadCourses> data = uploadCourseService.getUploadCourse();
		model.addAttribute("data", data);
		return "student/onlineCourse";
	}
	//.........................Online Quiz...................
	
//		@RequestMapping("/onlineQuiz")
//		public String onlineQuiz(Model model) {
//			List<Quiz> quiz = quizDao.findAll();
//			System.out.println(quiz);
//			//Optional<Quiz> getById= quizService.getQuizId(1);
////			if(getById.isPresent()) {
////				Quiz ids=getById.get();
////				model.addAttribute("id", ids.getId());
////				model.addAttribute("question", ids.getQuestion());
////				model.addAttribute("op1", ids.getOp1());
////				model.addAttribute("op2", ids.getOp2());
////				model.addAttribute("op3", ids.getOp3());
////				model.addAttribute("op4", ids.getOp4());
////			}			
//			model.addAttribute("quiz", quiz);			
////			int a=1;
////			model.addAttribute("count", a);
////			a++;
//			return "student/onlineQuiz";
//		}
	
		@RequestMapping("/onlineQuiz")
		public String quizDetails(Model model) {
			List<QuizDetails> quizDetails=quizDetailsServices.getQuizDetails();
			model.addAttribute("quizDetails", quizDetails);	
			System.out.println(quizDetails);
			return "student/onlineQuiz";
		}
		
		
		
		@RequestMapping("/testQuiz")
		public String quizss(Model model) {
			System.out.println("Quiz Section...");
			List<Quiz> quiz = quizDao.findAll();
			model.addAttribute("quiz", quiz);
			System.out.println("Fetech All quiz Data ::" + quiz);
		return "student/testQuiz";
		}
	
}
