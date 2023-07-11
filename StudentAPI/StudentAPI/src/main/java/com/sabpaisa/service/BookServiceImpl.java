package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.BookDao;
import com.sabpaisa.entity.Book;

@Service
public class BookServiceImpl  implements BookService{

	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Optional<Book> getBook(int bookid) {
		Optional<Book> getById = bookDao.findById(bookid);
		System.out.println("only one data:: "+getById);
		return getById;
	}

	@Override
	public Book addBook(Book book) {
		Book add=bookDao.save(book);
		return add;
	}

	@Override
	public Book updateBook(Book book) {
		 Book update=bookDao.save(book);
		return update;
	}

	@Override
	public void deleteBook(int Delete_id) {
		Book entity= bookDao.getOne(Delete_id);
		bookDao.delete(entity);		
	}
		
}
