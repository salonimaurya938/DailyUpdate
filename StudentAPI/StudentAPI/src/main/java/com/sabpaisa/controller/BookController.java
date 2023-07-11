package com.sabpaisa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.Chapter;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.service.BookService;
import com.sabpaisa.service.ChapterService;
import com.sabpaisa.service.HomeWorkService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired 
	private HomeWorkService homeWorkService;
	
	
//	Subject Controller Handler.........................................

	@PostMapping("/bookadds")
	public Book addBook(@RequestBody Book Book) {
		System.out.println("Book Panle...");
		Book var = this.bookService.addBook(Book);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/book")
	public List<Book> getBooks(Model model) {
		List<Book> Books = bookService.getBooks();
		model.addAttribute("Books", bookService.getBooks());
		System.out.println("Fetech All Student Data ::" + Books);
		return Books;
	}

	@GetMapping("/book/{bookid}")
	public String getBook(@PathVariable("Bookid") int Bookid, Model model) {
	       Optional<Book> BooksDashBoard =this.bookService.getBook(Bookid);
	       model.addAttribute("Book", BooksDashBoard);
		return "BookDashBoard";
	}

	@PutMapping("/booksUpdate")
	public Book updateBook(@RequestBody Book Book) {
		System.out.println("test...");
		Book var = this.bookService.updateBook(Book);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/adeletes/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		this.bookService.deleteBook(bookId);
		System.out.println("Deleted Successfully!!!");
	}
	
//	 chapter controller handler ....................
	
	
	@PostMapping("/Chapteradd")
	public Chapter addChapter(@RequestBody Chapter chapter) {
		System.out.println("chapter Panle...");
		Chapter var = this.chapterService.addChapter(chapter);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/chapters")
	public List<Chapter> getChapter(Model model) {
		List<Chapter> Chapters = chapterService.getChapters();
		model.addAttribute("Chapters", chapterService.getChapters());
		System.out.println("Fetech All Student Data ::" + Chapters);
		return Chapters;
	}

	@GetMapping("/chapter/{chapterid}")
	public String getChapter(@PathVariable("chapterid") int chapterid, Model model) {
	       Optional<Chapter> chapter =this.chapterService.getAdmin(chapterid);
	       model.addAttribute("chapter", chapter);
		return "chapter";
	}

	@PutMapping("/chapterUpdate")
	public Chapter updateChapter(@RequestBody Chapter chapter) {
		System.out.println("test...");
		Chapter var = this.chapterService.updateChapter(chapter);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/cdeletes/{chapterid}")
	public void deleteChapter(@PathVariable int chapterid) {
		this.chapterService.deleteChapter(chapterid);
		System.out.println("Deleted Successfully!!!");
	}
	
	
//	 HomeWork controller handler ....................
	
	
	@PostMapping("/homeWorkadd")
	public HomeWork addHomeWork(@RequestBody HomeWork homeWork) {
		System.out.println("HomeWork Panle...");
		HomeWork var = this.homeWorkService.addHomeWork(homeWork);
		System.out.println("Inserted successfully ::" + var);
		return var;
	}

	@GetMapping("/homeWorks")
	public List<HomeWork> getHomeWorks(Model model) {
		List<HomeWork> homeWork = homeWorkService.getHomeWorks();
		model.addAttribute("HomeWork", homeWorkService.getHomeWorks());
		System.out.println("Fetech All Student Data ::" + homeWork);
		return homeWork;
	}

	@GetMapping("/homeWork/{homeWorkid}")
	public String getHomeWork(@PathVariable("homeWorkid") int homeWorkid, Model model) {
	       Optional<HomeWork> homeWork =this.homeWorkService.gethomeWork(homeWorkid);
	       model.addAttribute("homeWork", homeWork);
		return "homeWork";
	}

	@PutMapping("/homeWorkUpdate")
	public HomeWork updateHomeWork(@RequestBody HomeWork homeWork) {
		System.out.println("test...");
		HomeWork var = this.homeWorkService.updateHomeWork(homeWork);
		System.out.println("Updated successfully ::" + var);
		return var;
	}

	@DeleteMapping("/cdeletes/{homeWorkid}")
	public void deleteHomeWork(@PathVariable int homeWorkid) {
		this.homeWorkService.deleteHomeWork(homeWorkid);
		System.out.println("Deleted Successfully!!!");
	}
	
	
		
}
