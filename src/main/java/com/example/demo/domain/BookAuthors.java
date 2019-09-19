package com.example.demo.domain;

import java.math.BigDecimal;

public class BookAuthors {
	private BigDecimal bookId;
	private String authorName;
	private String title;
	
	public BookAuthors(BigDecimal bookId, String authorName, String title) {
		super();
		this.bookId = bookId;
		this.authorName = authorName;
		this.title = title;
	}
	public BookAuthors() {
		super();
	}
	public BigDecimal getBookId() {
		return bookId;
	}

	public void setBookId(BigDecimal bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
