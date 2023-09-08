package com.sabpaisa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
//	@Query("SELECT "+ " new com.sabpaisa.entity.Quiz(q.category, COUNT(q)) "+
//	       "FROM "+
//			"   Quiz q "+
//	       "GROUP BY " +
//			"   q.category")
//	List<Quiz> findQuizCount();

}
