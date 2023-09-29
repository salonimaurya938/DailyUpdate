package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	//public Student findByEmailAndPassword(String email, String password);

}
