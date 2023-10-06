package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.QuizAttemptedDao;
import com.sabpaisa.entity.QuizAttempted;
@Service
public class QuizAttemptedServiceImpl implements QuizAttemptedService {

	
	@Autowired
	private QuizAttemptedDao quizAttemptedDao;
	
	@Override
	public List<QuizAttempted> getAttemptedQuiz() {
		return quizAttemptedDao.findAll();
	}

	@Override
	public Optional<QuizAttempted> getAttemptedQuiz(int id) {
		Optional<QuizAttempted> abc= quizAttemptedDao.findById(id);
		return abc;
	}

	@Override
	public QuizAttempted insertQuizAttempt(QuizAttempted quizAttempted) {		
		return quizAttemptedDao.save(quizAttempted);
	}

	@Override
	public QuizAttempted updateQuizAttempt(QuizAttempted quizAttempted) {
		return null;
	}

	@Override
	public void deleteAttemptQuiz(int id) {
		
	}

}
