package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.HomeWorkDao;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.HomeWork;

@Service
public class HomeWorkServiceImpl implements HomeWorkService{
	
	@Autowired
	private HomeWorkDao homeWorkDao;

	@Override
	public List<HomeWork> getHomeWorks() {
		return homeWorkDao.findAll();
	}

	@Override
	public Optional<HomeWork> gethomeWork(int homeWorkid) {
		Optional<HomeWork> a= homeWorkDao.findById(homeWorkid);
		return a;
	}

	@Override
	public HomeWork addHomeWork(HomeWork homeWork) {
		return homeWorkDao.save(homeWork);
	}

	@Override
	public HomeWork updateHomeWork(HomeWork homeWork) {
		Optional<HomeWork> workdata = homeWorkDao.findById(homeWork.getId());	
		if(workdata.isPresent()) {
			HomeWork newdata=workdata.get();
			newdata.setQuestion(homeWork.getQuestion());
			newdata=homeWorkDao.save(newdata);
			return newdata;
		}		
		homeWork=homeWorkDao.save(homeWork);
		return homeWork;
	}

	@Override
	public void deleteHomeWork(int Delete_id) {
		HomeWork entity= homeWorkDao.getOne(Delete_id);
		homeWorkDao.delete(entity);	
		
	}

}
