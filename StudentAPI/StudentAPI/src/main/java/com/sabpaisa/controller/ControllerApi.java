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

import com.sabpaisa.dao.AdminDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Student;
import com.sabpaisa.service.AdminService;
import com.sabpaisa.service.StudentService;

@RestController
public class ControllerApi {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdminService adminService;

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

}
