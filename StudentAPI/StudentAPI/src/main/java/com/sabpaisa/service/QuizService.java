package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.Quiz;

@Service
public interface QuizService {
	
	public List<Quiz> getQuiz();

	public Optional<Quiz> getQuizId(int id);

	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);

	public void deleteQuiz(int id);

}
