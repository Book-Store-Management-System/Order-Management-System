package com.cg.iter.bookorder.dto;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

// book
@Entity
@Table(name = "book_info")
public class BookEntity {

	/** Declaration of All the required variables */
	@Id
	private Integer bookid;
	private String booktitle;
	private String bookdescription;
	private String bookauthor;
	private String isbn;
	private Integer bookrate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishdate;

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookdescription() {
		return bookdescription;
	}

	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getBookrate() {
		return bookrate;
	}

	public void setBookrate(Integer bookrate) {
		this.bookrate = bookrate;
	}

	public LocalDate getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
	}

	public BookEntity() {
		super();

	}

	@Override
	public String toString() {
		return "BookEntity [bookid=" + bookid + ", booktitle=" + booktitle + ", bookdescription=" + bookdescription
				+ ", bookauthor=" + bookauthor + ", isbn=" + isbn + ", bookrate=" + bookrate + ", publishdate="
				+ publishdate + "]";
	}

}
