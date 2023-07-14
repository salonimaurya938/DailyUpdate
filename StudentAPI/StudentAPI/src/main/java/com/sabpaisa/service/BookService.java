package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.Book;

@Service
public interface BookService {

	public List<Book> getBooks();

	public Optional<Book> getBook(int bookid);

	public Book addBook(Book book);

	public Book updateBook(Book book);

	public void deleteBook(int Delete_id);
	
//	public List<Book> findbook(Book book);

//	public Book findBySubName(Book book); 

}
