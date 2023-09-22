package com.sabpaisa.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Option;


public interface OptionDao extends JpaRepository<Option, Integer>{

	Option getById(Option option);
	
//	Option findAllByQuestion_Id(int id);

	
}
