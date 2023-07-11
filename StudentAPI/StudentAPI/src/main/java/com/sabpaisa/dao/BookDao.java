package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	
	

}
