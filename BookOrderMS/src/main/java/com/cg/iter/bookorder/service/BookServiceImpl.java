package com.cg.iter.bookorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.iter.bookorder.dto.BookEntity;
import com.cg.iter.bookorder.exception.BookAlreadyPresentException;
import com.cg.iter.bookorder.repository.BookRepo;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo BookRepo;

	/** This is the Method for Viewing All books */

	public Iterable<BookEntity> viewAllBook() {

		return BookRepo.findAll();
	}

	/** This is the Method for Viewing book by id */

	//@Override
//	public Optional<BookEntity> viewBookById(Integer bookid) {
//
//		return BookRepo.findById(bookid);
//	}

	/** This is the Method for Adding books */

	@Override
	public BookEntity addBook(BookEntity book) {

		if (BookRepo.findById(book.getBookid()).isPresent()) {
			throw new BookAlreadyPresentException("Book with bookCode: " + book.getBookid() + " is already there!!!!");
		}
		return BookRepo.save(book);
	}

	/** This is the Method for Removing book by Id */

	@Override
	public String removeBook(Integer bookid) {

		BookRepo.deleteById(bookid);

		return "Book got deleted";
	}

}
