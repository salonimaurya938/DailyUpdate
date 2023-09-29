package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sabpaisa.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> getStudents();
	
	public Optional<Student> getStudent(int studentId);
	
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public void deleteStudent(int Delete_id);
	
	//public Student studentLogin(Student student);
	

}
