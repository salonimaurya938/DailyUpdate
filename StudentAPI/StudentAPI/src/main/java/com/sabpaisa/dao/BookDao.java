package com.sabpaisa.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
//	List<Book> findbyName(String subName);

//	Book findByName(String subName);	
	

}
