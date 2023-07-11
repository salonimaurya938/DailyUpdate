package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sabpaisa.entity.HomeWork;

@Service
public interface HomeWorkService {
	
	public List<HomeWork> getHomeWorks();

	public Optional<HomeWork> gethomeWork(int homeWorkid);

	public HomeWork addHomeWork(HomeWork homeWork);

	public HomeWork updateHomeWork(HomeWork homeWork);

	public void deleteHomeWork(int Delete_id);
	

}
