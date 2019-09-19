package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookAddress;
import com.example.demo.domain.BookAuthors;
import com.example.demo.domain.FormCommand;
import com.example.demo.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/Books")
	public String getBooks(Model model) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
		return "bookLanding";
	}
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String login(@ModelAttribute FormCommand formCommand, Model model) {
		formCommand = new FormCommand();
		
		model.addAttribute(formCommand);
		return "login";
	}
	@RequestMapping(value = "/Welcome", method = RequestMethod.GET)
	public String showBooks(Model model) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
		return "bookLanding";
	}
	@RequestMapping(value = "/Welcome", method = RequestMethod.POST)
	public String tryLogin(@ModelAttribute FormCommand formCommand, Model model) {
		if(bookService.authenticate(formCommand) == 1) {
			
			List<Book> bookList = new ArrayList<Book>();
			bookList = bookService.getBookList();
			
			model.addAttribute("bookList", bookList);
			model.addAttribute("formCommand", formCommand);
			return "bookLanding";
		} else {
			return "wrongLogin";
		}

		
	}
	@RequestMapping(value = "/NewUser", method = RequestMethod.GET)
    public String formCommand(@ModelAttribute FormCommand formCommand, Model model) {
    	formCommand = new FormCommand();
    	
    	model.addAttribute("formCommand", formCommand);
        
        return "newUser";
    }
	@RequestMapping(value = "/NewUser", method = RequestMethod.POST)
    public String newUser(@ModelAttribute FormCommand formCommand, Model model) {
		
		try {
		bookService.newUser(formCommand);
			return "bookLanding";
		} catch (Exception e) {
			return "badUser";
		}
    }
	@GetMapping("/BookDetails/{bookId}/{branchName}")
	public String displayBook(@PathVariable BigDecimal bookId, @PathVariable String branchName, @ModelAttribute BookAddress bookAddress, @ModelAttribute BookAuthors bookAuthors, @ModelAttribute Book book, Model model) {
		List<BookAddress> addressList = new ArrayList<BookAddress>();
		addressList = bookService.getBranchAddress(bookAddress);
		model.addAttribute("branchAddress", addressList);
		
		List<BookAuthors> authorList = new ArrayList<BookAuthors>();
		authorList = bookService.getAuthors(bookAuthors);
		model.addAttribute("bookAuthors", authorList);
		
		String bookName = book.getBookName();
		model.addAttribute("bookName", bookName);
		return "bookDetails";
		
	}
	@RequestMapping(value = "/Checkout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "checkout";
	}
}