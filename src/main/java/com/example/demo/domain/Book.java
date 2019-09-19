package com.example.demo.domain;

import java.math.BigDecimal;

public class Book {
	/*private BigDecimal bookId;
	private String title;
	private String publisher;
	
	public Book(BigDecimal bookId, String title, String publisher) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
	}

	public BigDecimal getBookId() {
		return bookId;
	}

	public void setBookId(BigDecimal bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	*/
		private BigDecimal copies;
		private String branchName;
		private String bookName;
		private BigDecimal bookId;
		
		public Book(String bookName, String branchName, BigDecimal copies, BigDecimal bookId) {
			super();
			this.bookName = bookName;
			this.branchName = branchName;
			this.copies = copies;
			this.bookId = bookId;
		}


		public BigDecimal getCopies() {
			return copies;
		}

		public void setCopies(BigDecimal copies) {
			this.copies = copies;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		
		public BigDecimal getBookId() {
			return bookId;
		}

		public void setBookId(BigDecimal bookId) {
			this.bookId = bookId;
		}
		
}
