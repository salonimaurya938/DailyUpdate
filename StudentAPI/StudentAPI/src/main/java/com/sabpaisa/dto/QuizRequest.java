package com.sabpaisa.dto;

import com.sabpaisa.entity.Quiz;

public class QuizRequest {
	
	private Quiz quiz;

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "QuizRequest [quiz=" + quiz + "]";
	}
	
	
}
