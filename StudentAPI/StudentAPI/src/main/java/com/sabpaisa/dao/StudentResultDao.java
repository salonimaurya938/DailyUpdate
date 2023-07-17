package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.StudentResult;

public interface StudentResultDao extends JpaRepository<StudentResult, Integer> {

}
