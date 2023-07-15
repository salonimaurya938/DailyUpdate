package com.sabpaisa.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.entity.Book;
import com.sabpaisa.fileuploading.Fileuploading;
import com.sabpaisa.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
//	.......................Start Book handler.................................

	@RequestMapping("/admin/addBook")
	public String bookBook(Model model) {
		model.addAttribute("title", "AddBook-Student Management System");
		Book book = new Book();
		model.addAttribute("book", book);
		return "admin/addBook";
	}

//	@PostMapping("/admin/addBook")
//	public String bookSave(@ModelAttribute("admin/addBook") Book book, @RequestParam("subIcon")MultipartFile multipartFile) throws IOException {
//		System.out.println("switching...");
//		ModelAndView mv = new ModelAndView("admin/addBook");
//		if(!multipartFile.isEmpty()) {
//			System.out.println("if column...");
//			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
//			book.setSubIcon(fileName);
//			bookService.addBook(book);
//			System.out.println("file uploading in add book data.."+bookService.addBook(book));
//			String uplaod= "/img/"+ book.getId();
//			Fileuploading.saveFile(uplaod, fileName, multipartFile);
//			
//		}else {
//			System.out.println("else column...");
//			if(book.getSubIcon().isEmpty()) {}
//			book.getSubIcon();
//			bookService.addBook(book);
//			
//		}
//		System.out.println("return column...");
//		bookService.addBook(book);
//		return "admin/saveBook";
//		
//	}
	
	
//	@PostMapping("/admin/addBook")
//	public String insertBook(@ModelAttribute("admin/addBook") Book book) {
//		System.out.println("inserting data..");
//		bookService.addBook(book);
//		System.out.println("data inserted value ::" + bookService.addBook(book));
//		return "redirect:/admin/profile";
//	}

	@RequestMapping(value="/admin/bupdate", method = RequestMethod.GET)
	public String updatebooks(Model model,Book book) {
		System.out.println("update method...");	
		model.addAttribute("bookUpdate", book);
		
//	    List<Book> booklist=  bookService.getBooks();
	    Optional<Book> b1= bookService.getBook(1);
	    Book b= b1.get();
	    model.addAttribute("id", b.getId());
		model.addAttribute("subName", b.getSubName());
		model.addAttribute("substatus", b.getSubstatus());
		model.addAttribute("subIcon", b.getSubIcon());
	    System.out.println("list book :: "+b1);
		return "admin/bupdate";
	}
	
	@RequestMapping(value = "/admin/bupdate",  method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("admin/bupdate") Book book) {
		System.out.println("updating data...");
		bookService.updateBook(book);
		System.out.println("data update value ::" + bookService.updateBook(book));
		return "redirect:/admin/profile";
	}

	@RequestMapping("/admin/downloadBook")
	public String downloadBook(Model model, Book book) {
		model.addAttribute("title", "Download-Student Management System");
		System.out.println("Showing..........book data");
		List<Book> book1 = bookService.getBooks();
		model.addAttribute("book", book1);
		return "admin/downloadBook";
	}

	@RequestMapping("/admin/deleteBook")
	public String deleteBook(Model model, Book book) {
		System.out.println("delete.............");
		bookService.deleteBook(0);
		model.addAttribute("title", "DeleteBook-Student Management System");
		return "admin/downloadBook";
	}

//	.......................End Book handler.................................

}
