package com.cg.iter.bookorder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import com.cg.iter.bookorder.dto.BookEntity;
import com.cg.iter.bookorder.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Order/Book")
public class BookController {
	
	@Autowired
	BookService bookService;
	/** This Is for Viewing All Books */

	@ApiOperation(value = " Get All Book", notes = "This api end point is to view all the books", response = BookEntity.class)
	@RequestMapping(value = "/viewAllBook", method = RequestMethod.GET)
	public Iterable<BookEntity> viewAllBook() {
		return bookService.viewAllBook();
	}

	/** This Is for Adding Books */
	@ApiOperation(value = " Add an book to Book Database ", notes = "This api end point is to add a book"
			+ "This api can be only accessed by the admin of the"
			+ "Book Order Management", response = BookEntity.class)

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public void addBook(@RequestBody BookEntity book) {
		bookService.addBook(book);

	}

	/** This Is for Removing Books By Id */
	@ApiOperation(value = " Delete a book From Book Database ", notes = "This api end point is to delete a book"
			+ "This api can be only accessed by the admin of the"
			+ "Book Order Management", response = BookEntity.class)

	@RequestMapping(value = "/removeBook/{bookid}", method = RequestMethod.DELETE)
	public void removeOrder(@PathVariable("bookid") Integer bookid) {
		bookService.removeBook(bookid);
	}
}
