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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sabpaisa.dao.BookDao;
import com.sabpaisa.dao.StudentResultDao;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.service.BookService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title","Home-Smart content manager");
		return "home";
	}
	
//....................................Start Book handler.................................

	@RequestMapping("/addBook")
	public String bookBook(Model model,HttpSession session) {
		model.addAttribute("title", "AddBook-Student Management System");
		 session.setAttribute("attributeName", "attributeValue");
		Book book = new Book();
		model.addAttribute("book", book);
		return "admin/addBook";
	}

	
	@PostMapping("/addBook")
	public String bookSave(@ModelAttribute("admin/addBook")@RequestParam MultipartFile subIcon, String subName,String subTitle,String substatus,String publisher, String author ,String bookIssueDate,String bookSubmitDate,String classes) throws IOException {
		System.out.println("Switching...");	
		Book book = new Book();
	    Book im = bookService.addBook(book);
	    im.setSubIcon(subIcon.getOriginalFilename());
	    im.setSubName(subName);
	    im.setSubstatus(substatus);
	    im.setSubTitle(subTitle);
	    im.setPublisher(publisher);
	    im.setAuthor(author);
	    im.setBookIssueDate(bookIssueDate);
	    im.setBookSubmitDate(bookSubmitDate);
	    im.setClasses(classes);
		Book subicon= bookService.addBook(book);			
		if(subicon!=null) {			
			try {
				File saveFile = new ClassPathResource("static/images").getFile();
			    Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+subIcon.getOriginalFilename());
			    System.out.println(path);
			    Files.copy(subIcon.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
			    bookService.addBook(book);
			} catch (Exception e) {
			
				e.printStackTrace();
		  }			
		}		
		System.out.println("msg :: Image Upload Successfully");	
		return "admin/addBook";
		
	}
		
//	@PostMapping("/addBook")
//	public String insertBook(@ModelAttribute("admin/addBook") Book book) {
//		System.out.println("inserting data..");
//		bookService.addBook(book);
//		System.out.println("data inserted value ::" + bookService.addBook(book));
//		return "redirect:/admin/profile";
//	}

	@RequestMapping(value="/bupdate{id}", method = RequestMethod.GET)
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
		model.addAttribute("publisher", b.getPublisher());
		model.addAttribute("author", b.getAuthor());
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
	
	@GetMapping("/downloadBook")
	public String downloadBook(Model model, Book book) {
		model.addAttribute("title", "Download-Student Management System");
		System.out.println("BookData....");		
		List<Book> book1 = bookService.getBooks();
		model.addAttribute("book", book1);
		return findPaginated(1, model);
	}

	@PostMapping("/deleteBook{id}")
	public String deleteBook(Model model,@RequestParam int id) {
		model.addAttribute("title", "DeleteBook-School Management System");
		System.out.println("delete method.............");
		bookDao.deleteById(id);	
		List<Book> book1 = bookService.getBooks();
		model.addAttribute("book", book1);
		return "admin/downloadBook";
	}
	
//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable(value="pageNo")int pageNo, Model model)
//	{
//		System.out.println("Pagination...");
//		int pageSize = 5;
//		System.out.println(pageSize);
//		Page<Book> page = bookService.findPaginated(pageNo, pageSize);
//		System.out.println(page);
//		List<Book> listBook = page.getContent();	
//		System.out.println(listBook);
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		model.addAttribute("listBook", listBook);		
//		return "admin/downloadBook";
//	}	
	@GetMapping("/page{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo")int pageNo, Model model)
	{
		System.out.println("Pagination...");

		 int pageSize = 5; // Number of items per page
	     Page<Book> page = bookDao.findAll(PageRequest.of(pageNo - 1, pageSize));
	     model.addAttribute("page", page);	
		return "admin/downloadBook";
	}
	
//	.......................End Book handler.................................
}
