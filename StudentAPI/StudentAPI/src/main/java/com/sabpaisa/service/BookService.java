package com.sabpaisa.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sabpaisa.entity.Book;

@Service
public interface BookService {

	public List<Book> getBooks();

	public Optional<Book> getBook(int bookid);

	public Book addBook(Book book);

	public Book updateBook(Book book);

	public void deleteBook(int Delete_id);
	
//	public Book addBook(Book book, @RequestParam MultipartFile subIcon);
	
//    public Collection<Book> getbyStatus(Book book);

//	public List<Book> findBySubName(Book book); 

}
