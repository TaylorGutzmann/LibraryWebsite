package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookAddress;
import com.example.demo.domain.BookAuthors;
import com.example.demo.domain.BookMapper;
import com.example.demo.domain.FormCommand;

@Component
public class BookDAO {
	
	@Autowired
	BookMapper bookMapper;

	public BookDAO() {
		
	}

	public List<Book> getBookList() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookMapper.getBookList();
		return bookList;
	}

	public void newUser(FormCommand formCommand) {
		bookMapper.newUser(formCommand);
	}

	public int authenticate(FormCommand formCommand) {
		return bookMapper.authenticate(formCommand);
	}

	public List<BookAddress> getBranchAddress(BookAddress bookAddress) {
		return bookMapper.getBranchAddress(bookAddress);
	}

	public List<BookAuthors> getBookAuthors(BookAuthors bookAuthors) {
		return bookMapper.getBookAuthors(bookAuthors);
	}
}
