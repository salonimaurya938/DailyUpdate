package com.sabpaisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sabpaisa.entity.Student;
import com.sabpaisa.entity.Events;
import com.sabpaisa.service.StudentService;

@Controller
public class StudentLoginController {
	
	@Autowired
	private StudentService studentService;
	
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
		
	@RequestMapping("/viewRegister")
	public String viewstuden(Model model) {
		List<Student> as= studentService.getStudents();
		model.addAttribute("students", as);
		return "registerview";
	}
	
	@RequestMapping("/studentLogin")
	public String Studentlogin() {
		return "studentLogin";
	}
	
	@RequestMapping("/studentDashboard")
	public String Student() {
		return "student/studentDashboard";
	}
	
	@RequestMapping("/myProfile")
	public String studentProfile() {
		
		return "student/myProfile";
	}
	
//	@GetMapping("/students")
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

	
	
	

}
