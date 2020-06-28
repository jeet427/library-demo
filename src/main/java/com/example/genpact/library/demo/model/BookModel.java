package com.example.genpact.library.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BookModel")
@NamedQueries(value = { 
		@NamedQuery(name = "BookModel.findAllBooks", query = "SELECT book FROM BookModel book WHERE libraryId = :libraryId"),
		@NamedQuery(name = "BookModel.findBook", query = "SELECT book FROM BookModel book WHERE libraryId = :libraryId and bookId = :bookId")})
public class BookModel {
	private Long bookId;
	private Long libraryId;
	private String bookTitle;
	private String bookDesc;
	private String content;
	private String isbn;
	@JsonIgnore
	private LibraryModel libraryModel;

	@Id
	@GeneratedValue
	@Column(name = "BookId")
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Column(name = "LibraryId")
	public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

	@Column(name = "BookTitle")
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Column(name = "BookDesc")
	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	@Column(name = "Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "ISBN")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, name = "libraryId")
	public LibraryModel getLibraryModel() {
		return libraryModel;
	}

	public void setLibraryModel(LibraryModel libraryModel) {
		this.libraryModel = libraryModel;
	}

}
