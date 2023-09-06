package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.QuizDetailsDao;
import com.sabpaisa.entity.QuizDetails;

@Service
public class QuizDetailsServicesImpl implements QuizDetailsServices{

	@Autowired
	private QuizDetailsDao quizDetailsDao;
	
	
	@Override
	public List<QuizDetails> getQuizDetails() {
		List<QuizDetails> quizdetails = quizDetailsDao.findAll();
		return quizdetails;
	}

	@Override
	public Optional<QuizDetails> getQuizDetailsId(int id) {
		Optional<QuizDetails> getById= quizDetailsDao.findById(id);
		return getById;
	}

	@Override
	public QuizDetails addQuizDetails(QuizDetails quizDetails) {
		QuizDetails quizsDetails= quizDetailsDao.save(quizDetails);
		return quizsDetails;
	}

	@Override
	public QuizDetails updateQuizDetails(QuizDetails quizDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuizDetails(int id) {
		// TODO Auto-generated method stub
		
	}

}
