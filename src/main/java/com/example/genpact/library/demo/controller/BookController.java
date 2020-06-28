package com.example.genpact.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.genpact.library.demo.exception.ItemNotFoundException;
import com.example.genpact.library.demo.model.BookModel;
import com.example.genpact.library.demo.service.book.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

	@Autowired
	private BookService bookService;

	@DeleteMapping("/delete/library/{libraryId}/book/{bookId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteBook(@PathVariable("libraryId") Long libraryId, @PathVariable("bookId") Long bookId)
			throws ItemNotFoundException {
		this.bookService.deleteBook(libraryId, bookId);
	}
	
	@GetMapping("/find/library/{libraryId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<BookModel> findAll(@PathVariable("libraryId") Long libraryId)
			throws ItemNotFoundException {
		return this.bookService.findAll(libraryId);
	}

	@GetMapping("/find/library/{libraryId}/book/{bookId}")
	@ResponseStatus(value = HttpStatus.OK)
	public BookModel findBook(@PathVariable("libraryId") Long libraryId, @PathVariable("bookId") Long bookId)
			throws ItemNotFoundException {
		return this.bookService.findBook(libraryId, bookId);
	}

	@PostMapping("/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createBook(@RequestBody BookModel bookModel) {
		this.bookService.createBookEntry(bookModel);
	}

	@PutMapping("/update")
	@ResponseStatus(value = HttpStatus.OK)
	public void updateBook(@RequestBody BookModel bookModel) throws ItemNotFoundException {
		this.bookService.updateBookEntry(bookModel, true);
	}

	@PatchMapping("/update")
	@ResponseStatus(value = HttpStatus.OK)
	public void mergeBook(@RequestBody BookModel bookModel) throws ItemNotFoundException {
		this.bookService.updateBookEntry(bookModel, false);
	}
}
