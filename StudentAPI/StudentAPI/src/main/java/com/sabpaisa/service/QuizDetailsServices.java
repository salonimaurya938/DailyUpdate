package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.QuizDetails;

@Service
public interface QuizDetailsServices {
	
	public List<QuizDetails> getQuizDetails();

	public Optional<QuizDetails> getQuizDetailsId(int id);

	public QuizDetails addQuizDetails(QuizDetails quizDetails);

	public QuizDetails updateQuizDetails(QuizDetails quizDetails);

	public void deleteQuizDetails(int id);
}
