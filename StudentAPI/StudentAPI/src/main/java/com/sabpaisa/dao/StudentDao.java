package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
//	Student findByUsernameAndPassword(String username, String password);

}
