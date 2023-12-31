package com.sabpaisa.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.entity.Student;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.entity.TimeTable;
import com.sabpaisa.entity.UploadCourses;
import com.sabpaisa.dao.AdmissionDao;
import com.sabpaisa.dao.CategoryDao;
import com.sabpaisa.dao.OptionDao;
import com.sabpaisa.dao.QuizDao;
import com.sabpaisa.dao.QuizDetailsDao;
import com.sabpaisa.dao.StudentDao;
import com.sabpaisa.dao.UploadDao;
import com.sabpaisa.dto.QuizDto;
import com.sabpaisa.entity.Admission;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Category;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.Events;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.Images;
import com.sabpaisa.entity.Option;
import com.sabpaisa.entity.Quiz;
import com.sabpaisa.entity.QuizDetails;
import com.sabpaisa.service.AdmissionServices;
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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private AdmissionServices admissionServices;

	@Autowired
	private AdmissionDao admissionDao;

//	@RequestMapping("/register")
//	public String StudentRegistration() {
//		return "register";
//	}
	
	@GetMapping("/my-account")
	public String addstudents(Model model, Student student) {
		model.addAttribute("title", "Registration-School Management System");
		model.addAttribute("students", student);
		return "my-account";
	}

	@PostMapping("/my-account")
	public String addstudent(@ModelAttribute("admin/addEvents") Student student) {
		studentService.addStudent(student);
		System.out.println("Data Insrted Successfully :: " + studentService.addStudent(student));
		return "my-account";
	}

	@RequestMapping("/viewRegistration")
	public String viewstuden(Model model) {
		List<Student> as = studentService.getStudents();
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
	public String Studentlogin(Model model, @ModelAttribute("login") Admission admission, HttpSession session) {
		System.out.println("Admission details :: " + admission);
		Admission user = admissionDao.findByUserIdAndPass(admission.getUserId(), admission.getPass());
		int userid = user.getId();
		String id = Integer.toString(userid);
		String email = user.getUserId();
		String pass = user.getPass();
		System.out.println("Admission data" + user);
		if (email != null && pass != null) {
			session.setAttribute("username", user.getUserId());
			session.setAttribute("name", user.getName());
			session.setAttribute("email", user.getGmail());
			session.setAttribute("pass", user.getPass());
			session.setAttribute("id", id);
			session.setAttribute("fname", user.getFname());
			session.setAttribute("mname", user.getMname());
			session.setAttribute("dob", user.getDob());
			session.setAttribute("gender", user.getGender());
			session.setAttribute("bloodGroup", user.getBloodGroup());
			session.setAttribute("classes", user.getClasses());
			session.setAttribute("address", user.getAddress());
			session.setAttribute("rollNo", user.getRollNo());
			session.setAttribute("pmob", user.getPmob());
			session.setAttribute("registratonNo", user.getRegistrationNo());
			session.setAttribute("admissionNo", user.getAdmissionNo());
//   	    model.addAttribute("id", d.getId());
			return "student/studentDashboard";
		} else
			return "login";
	}

	@RequestMapping("/studentDashboard")
	public String dashBoard() {
		return "student/studentDashboard";
	}

	@RequestMapping("/myProfile")
	public String Student(Admission admission, HttpSession session, Model model) {
		ModelAndView ma = new ModelAndView("myProfile");
		System.out.println("my profile...");

		String username = (String) session.getAttribute("username");
		String email = (String) session.getAttribute("email");
		String id = (String) session.getAttribute("id");
		// int id = (int) session.getId();
		String pmob = (String) session.getAttribute("pmob");
		String name = (String) session.getAttribute("name");
		String pass = (String) session.getAttribute("pass");
		String fname = (String) session.getAttribute("fname");
		String mname = (String) session.getAttribute("mname");
		String bloodGroup = (String) session.getAttribute("bloodGroup");
		String dob = (String) session.getAttribute("dob");
		String gender = (String) session.getAttribute("gender");
		String classes = (String) session.getAttribute("classes");
		String rollNo = (String) session.getAttribute("rollNo");
		String address = (String) session.getAttribute("address");
		String registratonNo = (String) session.getAttribute("registratonNo");
		if (username != null && email != null) {

			model.addAttribute("username", username);
			model.addAttribute("email", email);
		}
		model.addAttribute("pmob", pmob);
		model.addAttribute("pass", pass);
		model.addAttribute("name", name);
		model.addAttribute("mname", mname);
		model.addAttribute("fname", fname);
		model.addAttribute("address", address);
		model.addAttribute("bloodGroup", bloodGroup);
		model.addAttribute("dob", dob);
		model.addAttribute("gender", gender);
		model.addAttribute("classes", classes);
		model.addAttribute("rollNo", rollNo);
		model.addAttribute("registratonNo", registratonNo);
		model.addAttribute("id", id);

		System.out.println(" Username :: " + username + "\n Email :: " + email + "\n Password :: " + pass
				+ "\n Mobile :: " + pmob);

		// Student d = studentService.studentLogin(student);
		// System.out.println("student value" + d);
		return "student/myProfile";
	}

	@PostMapping("/myProfile")
	public String studentProfile(Model model, @ModelAttribute("student/myProfile") HttpSession session,
			Admission admission) {
		System.out.println("my profile...");
		Admission abc = admissionServices.updateMyProfile(admission);
		System.out.println("Updated successfully !!! ::" + abc);
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
//	}.................................

	@RequestMapping("/changePassword")
	public String changePassword(Admission admission) {

		String oldPassword = admission.getPass();
	//	String newPassword = admission.getPass();
	//  String reNewPassword = admission.getPass();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		if (oldPassword != null) {

			//if (newPassword == reNewPassword) {

				Admission abc = admissionServices.changePassword(admission);
				System.out.println("Password Change successfully!!!");
				System.out.println("New Password :: "+abc);

			//}
		}

		return "student/myProfile";
	}

	
	
	
	// ..................Book Controller..............................

	@RequestMapping("/viewBook")
	public String downloadBook(Model model, Book book) {
		model.addAttribute("title", "Download-Student Management System");
		System.out.println("Showing..........book data");
		List<Book> book1 = bookService.getBooks();
		model.addAttribute("book", book1);
		return "student/viewBook";
	}

	// ..................Chapter Controller..............................
	@RequestMapping("/viewchapters")
	public String viewChapters(Model model, Chapter chapter) {
		model.addAttribute("title", "View Chapter-Student Management System");
		System.out.println("Showing..........Chapter data");
		List<Chapter> chapter1 = chapterService.getChapters();
		model.addAttribute("chapter", chapter1);
		return "student/viewchapters";
	}

	// ..................Events Controller..............................
	@RequestMapping("/viewEvent")
	public String viewEvents(Model model) {
		List<Events> as = eventsService.getEvents();
		model.addAttribute("events", as);
		return "student/viewEvent";
	}

	// ..................Gallery Controller..............................
	@RequestMapping("/viewimg")
	public String viewImg(Model model) {
		List<Images> list = uploadDao.findAll();
		model.addAttribute("lists", list);
		return "student/viewimg";
	}

	// ..................HomeWork Controller..............................
	@RequestMapping("/viewhomeworks")
	public String viewhomework(Model model, HomeWork homework) {
		model.addAttribute("title", "View HomeWork-School Management System");
		System.out.println("Showing..........homeWork data");
		List<HomeWork> homework1 = homeWorkService.getHomeWorks();
		System.out.println("homework data ::" + homework1);
		model.addAttribute("question", homework1);
		return "student/viewhomeworks";
	}

	// ..................Result Controller..............................
	@RequestMapping("/viewResults")
	public String viewResult(Model model) {
		List<StudentResult> list = studentResultService.getStudentResults();
		model.addAttribute("lists", list);
		return "student/viewResults";
	}

	// ..................TimeTable Controller..............................
	@GetMapping("/viewTimeTable")
	public String timetableget(Model model) {
		model.addAttribute("title", "TimeTable");
		List<TimeTable> as = timeTableService.getTimeTables();
		System.out.println("Time table data" + as);
		model.addAttribute("timeTables", as);
		return "student/viewTimeTable";
	}

	// .........................Online Courses...................
	@RequestMapping("/onlineCourse")
	public String onlineCourse(Model model) {
		List<UploadCourses> data = uploadCourseService.getUploadCourse();
		model.addAttribute("data", data);
		return "student/onlineCourse";
	}

	// ..............................Online Quiz...........................

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

	@RequestMapping(value = "/onlineQuiz", method = RequestMethod.GET)
	public String quizDetails(Model model, Admission admission) {

		List<Category> cate = categoryDao.findAll();
		System.out.println("category :: " + cate);
		model.addAttribute("cate", cate);
		List<QuizDetails> quizDetails = quizDetailsServices.getQuizDetails();
		// model.addAttribute("quizDetails", quizDetails);
		System.out.println("QuizDetails table details" + quizDetails);
		
		// dynamic id		
		//Optional<Admission> data = admissionDao.findById(admission.getId());	
		//System.out.println("get id Data :: " + data);
		//Admission studentClass = data.get();
		
		Optional<Admission> idData = admissionDao.findById(1);
		System.out.println("get id Data :: " + idData);
		Admission studentClass = idData.get();
		String stdclasses = studentClass.getClasses();
		System.out.println("get classes by Admission tbl :: " + studentClass);

		List<QuizDetails> newDetailsList = new ArrayList<>();
		List<QuizDetails> getList = quizDetailsServices.getQuizDetails();
		QuizDetails quisDetails = null;
		for (QuizDetails newData : getList) {
			if (stdclasses.equalsIgnoreCase(newData.getClasses())) {
				quisDetails = new QuizDetails();
				quisDetails.setCategory(newData.getCategory());
				quisDetails.setClasses(newData.getClasses());
				quisDetails.setMarks(newData.getMarks());
				quisDetails.setNegativeMarks(newData.getNegativeMarks());
				quisDetails.setSubject(newData.getSubject());
				quisDetails.setTitle(newData.getTitle());
				quisDetails.setTotalTime(newData.getTotalTime());
				quisDetails.setId(newData.getId());
				newDetailsList.add(quisDetails);
			}
		}
		System.out.println("New Quiz Details Match By Student Classes Data ::");
		System.out.println(newDetailsList);
		model.addAttribute("quizDetails", newDetailsList);
		
		
		
		
		return "student/onlineQuiz";
	}

    @PostMapping("/onlineQuiz")
	public String OnlineQuizss(Model model, Admission admission) {
    	
    	int id= admission.getId();
    	System.out.println("id get by id ::"+id);
		return "student/onlineQuiz";
		
	}
	
	
	
	@RequestMapping(value = "/testQuiz{category}", method = RequestMethod.GET)
	public String quizss(Model model, Quiz quz, @PathVariable("category") String category, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		model.addAttribute("userId", username);
		
		
		System.out.println("Quiz Section..." + category);
		List<QuizDetails> quizdetails = quizDetailsDao.findAll();
		model.addAttribute("quizdetials", quizdetails);
		List<QuizDetails> newQuizDetails = new ArrayList<>();
		List<QuizDetails> quizDetails1 = quizDetailsDao.findAll();
		QuizDetails data = null;
		for (QuizDetails quizDetails3 : quizDetails1) {
			if (quizDetails3.getCategory().equals(category)) {
				data = new QuizDetails();
				data.setTotalTime(quizDetails3.getTotalTime());
				data.setCategory(quizDetails3.getCategory());
				data.setClasses(quizDetails3.getClasses());
				data.setMarks(quizDetails3.getMarks());
				data.setNegativeMarks(quizDetails3.getNegativeMarks());
				data.setSubject(quizDetails3.getSubject());
				data.setTitle(quizDetails3.getTitle());
				newQuizDetails.add(quizDetails3);
			}
			System.out.println("new quizDetailsData.." + newQuizDetails);
			model.addAttribute("timebyCate", newQuizDetails);
		}
		List<Quiz> quiz = quizDao.findAll();
		model.addAttribute("quiz", quiz);
		System.out.println("Fetech All quiz Data ::" + quiz);
		System.out.println("Category..." + category);
		model.addAttribute("category", category);
		
		
		List<Quiz> newQuestionList = new ArrayList<>();
		List<Quiz> quiz1 = quizDao.findAll();
		Quiz quiz2 = null;
		for (Quiz question : quiz1) {
			if (question.getCategory().equalsIgnoreCase(category)) {
				quiz2 = new Quiz();
				quiz2.setQuestion(question.getQuestion());
				quiz2.setAnswer(question.getAnswer());
				quiz2.setCategory(question.getCategory());
				quiz2.setOption(question.getOption());
				quiz2.setId(question.getId());
				quiz2.setScore(question.getScore());
				quiz2.setStatus(question.getStatus());
				newQuestionList.add(quiz2);
			}
		}
		System.out.println("new quiz list.." + newQuestionList);
		model.addAttribute("questionOption", newQuestionList);
		return "student/testQuiz";
	}

	@PostMapping("/testQuiz")
	public String quizDetail(@RequestBody QuizDto quizDto, Quiz quz) {

//			System.out.println("quizsssss........ "+quizDto);
//	    	String id=quizDto.getId();
//	    	System.out.println("ids for quiz Dto :: "+id);
//	    	String question=quizDto.getQuestion();
//	    	String option = quizDto.getOption();
//			System.out.println("Form data received. Id: " + id + ", question: " + question+", Option:"+option);
//					    
//		    Optional<Quiz> a= quizService.getQuizId(1);
//		    System.out.println("Get by id single data by tbl...."+a);
//		    
//			Quiz ab = a.get();
//			int ids = ab.getId();
//			String stringValueId = String.valueOf(ids);
//			System.out.println("Get ID by tbl data in String:: " + stringValueId);
//		   
//			if(id.equalsIgnoreCase(stringValueId)) {				
//			System.out.println("get data ::"+ ids + " id :: "+stringValueId);	
//			String answers =ab.getAnswer();
//			System.out.println("Get by ID answer ::"+ answers);
//			   if(answers.equalsIgnoreCase(option)) {	
//				  System.out.println("Correct answer ::"+ answers+"Option :: "+option);
//				  
////				 Quiz quizupdate= quizService.updateQuizwhenClick(quiz);					
////				 System.out.println("quiz update data"+quizupdate);				   
////				   
//			   }
//			}

		return "student/testQuiz";
	}

	@RequestMapping(value = "/quizUpdateScore", method = RequestMethod.POST)
	public String processJsonData() {
		System.out.println("Ajax Data ...");

		return "student/testQuiz";
	}

//		 System.out.println("Quiz details Saloni ..."+request);			  
//		 Optional<Quiz> data = quizService.getQuizId(3);
//		 Quiz as = data.get();
//		 int ids=as.getId();
//		 
//		 int reqId= request.getId();			 
//		 if(ids==reqId) {
//			 System.out.println("tbl id :: "+ids);
//			 
//		 }

//			 Quiz quiz = new Quiz();
//			 
//			 if(request.getScore() != null) {				 
//				 quiz.setScore(request.getScore());
//				 quiz.setAnswer(request.getAnswer());
//				 quiz.setCategory(request.getCategory());
//				 quiz.setOption(request.getOption());
//				 quiz.setQuestion(request.getQuestion());
//				 quiz.setStatus(request.getStatus());
//				 newQuestionList.add(quiz);
//			 }
//			 System.out.println("new quiz list.."+newQuestionList);
//			 model.addAttribute("quiz", newQuestionList); 		  

	// ........................Notice Board ..............................

	@RequestMapping("/noticeBoard")
	public String Notice() {
		System.out.println("notice board student section...");
		return "student/noticeBoard";
	}

}
