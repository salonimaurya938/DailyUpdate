package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.Book;

@Service
public interface BookService {

	public List<Book> getBooks();

	public Optional<Book> getBook(int Bookid);

	public Book addBook(Book Book);

	public Book updateBook(Book Book);

	public void deleteBook(int Delete_id);

}
