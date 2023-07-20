package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.StudentResult;

@Repository
public interface StudentResultDao extends JpaRepository<StudentResult, Integer> {

}
