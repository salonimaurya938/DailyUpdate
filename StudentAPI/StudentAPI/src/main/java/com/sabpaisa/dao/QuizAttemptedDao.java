package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.QuizAttempted;

@Repository
public interface QuizAttemptedDao extends JpaRepository<QuizAttempted, Integer>{
	

}
