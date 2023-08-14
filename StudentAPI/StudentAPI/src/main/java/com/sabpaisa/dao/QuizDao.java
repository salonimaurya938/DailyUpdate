package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
