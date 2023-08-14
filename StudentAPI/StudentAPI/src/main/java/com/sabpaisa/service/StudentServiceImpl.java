package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.StudentDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	

	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}
	
	@Override
	public Optional<Student> getStudent(int studentid) {
		Optional<Student> getById = studentDao.findById(studentid);
		return getById;
	}

	@Override
	public Student addStudent(Student student) {
		Student add=studentDao.save(student);
		return add;
	}

	@Override
	public Student updateStudent(Student student) {
		 Student update=studentDao.save(student);
		return update;
	}

	@Override
	public void deleteStudent(int Delete_id) {
	 Student entity= studentDao.getOne(Delete_id);
	 studentDao.delete(entity);
		
	}

	@Override
	public Student studentLogin(Student student) {
		System.out.println(student);
		Student findByUsername= studentDao.findByEmailAndPassword(student.getEmail(),student.getPassword());
		System.out.println(findByUsername);
	    return findByUsername;
	}
	

}
