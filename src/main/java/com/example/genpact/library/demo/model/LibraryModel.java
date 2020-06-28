package com.example.genpact.library.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "LibraryModel")
@Entity
public class LibraryModel {
	private Long libraryId;
	private String libraryName;
	
	@JsonIgnore
	private List<BookModel> bookList;

	public LibraryModel() {
		super();
	}

	public LibraryModel(String libraryName) {
		super();
		this.libraryName = libraryName;
	}

	@Id
	@GeneratedValue
	public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

	@Column(name = "LibraryName")
	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	@OneToMany(mappedBy = "libraryId")
	public List<BookModel> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookModel> bookList) {
		this.bookList = bookList;
	}

}
