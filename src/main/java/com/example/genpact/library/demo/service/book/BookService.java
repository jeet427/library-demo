package com.example.genpact.library.demo.service.book;

import java.util.List;

import com.example.genpact.library.demo.exception.ItemNotFoundException;
import com.example.genpact.library.demo.model.BookModel;

public interface BookService {

	BookModel createBookEntry(BookModel bookModel);

	void deleteBook(Long libraryId, Long bookId) throws ItemNotFoundException;

	BookModel findBook(Long libraryId, Long bookId) throws ItemNotFoundException;

	BookModel updateBookEntry(BookModel bookModel, boolean isUpdate) throws ItemNotFoundException;

	List<BookModel> findAll(Long libraryId);

}
