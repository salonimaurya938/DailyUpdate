package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.OptionDao;
import com.sabpaisa.dao.QuizDao;
import com.sabpaisa.entity.Option;
import com.sabpaisa.entity.Quiz;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private OptionDao optionDao;

	@Override
	public List<Quiz> getQuiz() {
		List<Quiz> quiz=quizDao.findAll();
		return quiz;
	}

	@Override
	public Optional<Quiz> getQuizId(int id) {
		Optional<Quiz> getById= quizDao.findById(id);
		return getById;
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		Quiz quizs= quizDao.save(quiz);
		return quizs;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		Optional<Quiz> data = quizDao.findById(quiz.getId());		
		if(data.isPresent()) {			
			Quiz newData= data.get();
			newData.setQuestion(quiz.getQuestion());
//			newData.setOp1(quiz.getOp1());
//			newData.setOp2(quiz.getOp2());
//			newData.setOp3(quiz.getOp3());
//			newData.setOp4(quiz.getOp4());
			newData=quizDao.save(newData);
			return newData;
		  }else {
			  quiz= quizDao.save(quiz);
			  return quiz;
		  }
	}

	@Override
	public void deleteQuiz(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Option> getOption() {
	List<Option> option = optionDao.findAll();
			return option;
	}

	@Override
	public Option addOption(Option option) {
	Option options = optionDao.save(option);
		return options;
	}
	
	@Override
	public Optional<Option> getOptionId(int id) {
		Optional<Option> getById= optionDao.findById(id);
		return getById;
	}

}
