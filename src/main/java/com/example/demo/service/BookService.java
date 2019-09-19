package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookDAO;
import com.example.demo.domain.Book;
import com.example.demo.domain.BookAddress;
import com.example.demo.domain.BookAuthors;
import com.example.demo.domain.FormCommand;

@Component
public class BookService {

	@Autowired
	BookDAO bookDAO;
	
	public BookService() {
		
	}
	public List<Book> getBookList() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookDAO.getBookList();
		return bookList;
	}
	public void newUser(FormCommand formCommand) {
		bookDAO.newUser(formCommand);
		
	}
	public int authenticate(FormCommand formCommand) {
		return bookDAO.authenticate(formCommand);
	}
	public List<BookAddress> getBranchAddress(BookAddress bookAddress) {
		return bookDAO.getBranchAddress(bookAddress);
	}
	public List<BookAuthors> getAuthors(BookAuthors bookAuthors) {
		return bookDAO.getBookAuthors(bookAuthors);
	}
}
