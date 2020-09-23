package com.cg.iter.bookorder.service;

import java.util.Optional;

import com.cg.iter.bookorder.dto.BookEntity;


public interface BookService {
	public Iterable<BookEntity> viewAllBook();
	
	//public Optional<BookEntity> viewBookById(Integer bookid);
	
	public BookEntity addBook(BookEntity book);
	
	public String removeBook(Integer bookid);
	
	
	
}
