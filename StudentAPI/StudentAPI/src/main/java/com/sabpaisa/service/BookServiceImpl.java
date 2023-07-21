package com.sabpaisa.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sabpaisa.dao.BookDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Images;

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
	
//	@Override
//	public Book addBook(Book book, MultipartFile subIcon) {
//		System.out.println(subIcon.getOriginalFilename());
//		book.setSubIcon(subIcon.getOriginalFilename());		
//		Book uploadimg= bookDao.save(book);		
//		return uploadimg;
//	}

	@Override
	public Book updateBook(Book book) {
		Optional<Book> bookdata = bookDao.findById(book.getId());	
		if(bookdata.isPresent()) {
			Book newdata=bookdata.get();
			newdata.setSubIcon(book.getSubIcon());
			newdata.setSubName(book.getSubName());
			newdata.setSubTitle(book.getSubTitle());
			newdata.setSubstatus(book.getSubstatus());
			newdata=bookDao.save(newdata);
			return newdata;
		}		
		  book=bookDao.save(book);
		return book;
	}
		

	@Override
	public void deleteBook(int deleteid) {
		Book entity= bookDao.getOne(deleteid);
		bookDao.delete(entity);		
	}
	
//	public Book imgUpload(Book book, MultipartFile subIcon) {
//		System.out.println(subIcon.getOriginalFilename());
//		book.setSubIcon(subIcon.getOriginalFilename());		
//		Book uploadimg= bookDao.save(book);		
//		return uploadimg;
//	}

//	@Override
//	public Collection<Book> getbyStatus(Book book) {
//		Collection<Book> book1 =bookDao.findByMyClassName(book.getSubstatus());
//		return book1;
//	}

//	@Override
//	public List<Book> findBySubName(Book book) {
//		List<Book> book1 = bookDao.findByName(book.getSubName());
//		return book1;
//	}

//	public List<Book> findbook(Book book) {
//		List<Book> book1=bookDao.findbyName(book.getSubName());
//		return book1;
//	}
	
//	@Override
//	public Book findBySubName(Book book) {		
//		Book book1=bookDao.findByName(book.getSubName());
//		return book1;
//	}
		
}
