package com.sabpaisa.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.sabpaisa.entity.Book;
import com.sabpaisa.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title","Home-Smart content manager");
		return "admin/home";
	}
	
//	.......................Start Book handler.................................

	@RequestMapping("/addBook")
	public String bookBook(Model model) {
		model.addAttribute("title", "AddBook-Student Management System");
		Book book = new Book();
		model.addAttribute("book", book);
		return "admin/addBook";
	}

//	@PostMapping("/addBook")
//	public String bookSave(@Validated @ModelAttribute("admin/addBook")Book book, @RequestParam("subIcon") MultipartFile subIcon) throws IOException {
//		System.out.println("switching...");				
//		Book uploadimg= bookService.addBook(book, subIcon);			
//		if(uploadimg!=null) {			
//			try {
//				File saveFile = new ClassPathResource("static/images").getFile();
//			    Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+subIcon.getOriginalFilename());
//			    System.out.println(path);
//			    Files.copy(subIcon.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
//				
//			} catch (Exception e) {
//			
//				e.printStackTrace();
//		  }			
//		}		
//		System.out.println("msg :: Image Upload Successfully");	
//		return "admin/addBook";
//		
//	}
	
	
	@PostMapping("/addBook")
	public String insertBook(@ModelAttribute("admin/addBook") Book book) {
		System.out.println("inserting data..");
		bookService.addBook(book);
		System.out.println("data inserted value ::" + bookService.addBook(book));
		return "redirect:/admin/profile";
	}

	@RequestMapping(value="/bupdate/{id}", method = RequestMethod.GET)
	public String updatebooks(Model model,Book book,@PathVariable("id") int id) {
		System.out.println("update method...");	
		model.addAttribute("bookUpdate", book);	
		Optional<Book> bookData= bookService.getBook(id);
		Book b =bookData.get();
	    model.addAttribute("id", b.getId());
		model.addAttribute("subName", b.getSubName());
		model.addAttribute("substatus", b.getSubstatus());
		model.addAttribute("subIcon", b.getSubIcon());
		model.addAttribute("subTitle", b.getSubTitle());
	    System.out.println("list book :: "+bookData);
		return "admin/bupdate";
	}
	
	@RequestMapping(value = "/bupdate",  method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("admin/bupdate")Book book) {
		System.out.println("updating data...");	
		bookService.updateBook(book);
		System.out.println("update successfully ::"+bookService.updateBook(book));
		return "admin/bupdate";
	}
	
	@RequestMapping("/downloadBook")
	public String downloadBook(Model model, Book book) {
		model.addAttribute("title", "Download-Student Management System");
		System.out.println("Showing..........book data");
		List<Book> book1 = bookService.getBooks();
		model.addAttribute("book", book1);
		return "admin/downloadBook";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(Model model, Book book,@PathVariable("id") int id) {
		System.out.println("delete.............");
		bookService.deleteBook(id);
		model.addAttribute("title", "DeleteBook-Student Management System");
		return "admin/downloadBook";
	}

//	.......................End Book handler.................................

}
