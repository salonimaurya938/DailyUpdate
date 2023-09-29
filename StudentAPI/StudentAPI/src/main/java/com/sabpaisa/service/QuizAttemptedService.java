package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import com.sabpaisa.entity.QuizAttempted;

public interface QuizAttemptedService {
	
	public List<QuizAttempted> getAttemptedQuiz();

	public Optional<QuizAttempted> getAttemptedQuiz(int id);

	public QuizAttempted insertQuizAttempt(QuizAttempted quizAttempted);

	public QuizAttempted updateQuizAttempt(QuizAttempted quizAttempted);

	public void deleteAttemptQuiz(int id);

}
