package com.example.demo.domain;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
	
	/*@Select("SELECT bookid, title, publisher FROM BOOK")
	List<Book> getBookList();
	*/
	@Select("select distinct b.title, l.branchname, c.no_of_copies, b.bookid " + 
			"from book b, library_branch l, book_copies c " + 
			"where c.bookid = b.bookid and c.branchid = l.branchid")
	List<Book> getBookList();

	@Insert("INSERT INTO BORROWER VALUES(#{cardNo}, #{name}, #{address}, #{phone}, #{password})")
	void newUser(FormCommand formCommand);
	
	@Select("SELECT COUNT(NAME) FROM BORROWER WHERE CARDNO = #{cardNo} and PASSWORD = #{password}")
	int authenticate(FormCommand formCommand);

	@Select("SELECT ADDRESS FROM LIBRARY_BRANCH WHERE BRANCHNAME = #{branchName}")
	List<BookAddress> getBranchAddress(BookAddress bookAddress);

	@Select("SELECT A.AUTHORNAME, B.TITLE " + 
			"FROM BOOK_AUTHORS A, BOOK B " + 
			"WHERE a.bookid = b.bookid and a.BOOKID = #{bookId}")
	List<BookAuthors> getBookAuthors(BookAuthors bookAuthors);

}
