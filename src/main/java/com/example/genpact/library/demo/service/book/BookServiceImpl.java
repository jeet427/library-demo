package com.example.genpact.library.demo.service.book;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.genpact.library.demo.exception.ItemNotFoundException;
import com.example.genpact.library.demo.model.BookModel;
import com.example.genpact.library.demo.repo.book.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookModel createBookEntry(BookModel bookModel) {
		LOGGER.info("Saving new book entry");
		if (bookModel != null)
			return this.bookRepository.save(bookModel);
		
		return null;
	}

	@Override
	public BookModel updateBookEntry(BookModel bookModel, boolean isUpdate) throws ItemNotFoundException {
		LOGGER.info("Updating book entry");
		Long bookId = bookModel.getBookId();
		Long libraryId = bookModel.getLibraryId();
		BookModel savedBook = null;
		if (Objects.nonNull(bookId) && Objects.nonNull(libraryId)) {
			savedBook = this.findBook(libraryId, bookId);
		}

		if (savedBook == null) {
			throw new ItemNotFoundException();
		} else {
			updateBookEntries(savedBook, bookModel, isUpdate);
			return this.bookRepository.save(bookModel);
		}
	}

	@Override
	public void deleteBook(Long libraryId, Long bookId) throws ItemNotFoundException {
		LOGGER.info("Deleting book entry");
		BookModel bookModel = this.findBook(libraryId, bookId);
		this.bookRepository.delete(bookModel);
	}

	@Override
	public BookModel findBook(Long libraryId, Long bookId) throws ItemNotFoundException {
		LOGGER.info("Finding book entry");
		return this.bookRepository.findBook(libraryId, bookId);
	}


	@Override
	public List<BookModel> findAll(Long libraryId) {
		LOGGER.info("Finding all book entries");
		return this.bookRepository.findAllBooks(libraryId);
	}
	
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	private void updateBookEntries(BookModel savedBook, BookModel bookModel, boolean isUpdate) {
		if (isUpdate || StringUtils.hasText(bookModel.getBookDesc())) {
			savedBook.setBookDesc(bookModel.getBookDesc());
		}

		if (isUpdate || StringUtils.hasText(bookModel.getBookTitle())) {
			savedBook.setBookTitle(bookModel.getBookTitle());
		}

		if (isUpdate || StringUtils.hasText(bookModel.getContent())) {
			savedBook.setContent(bookModel.getContent());
		}

		if (isUpdate || StringUtils.hasText(bookModel.getIsbn())) {
			savedBook.setIsbn(bookModel.getIsbn());
		}

		if (isUpdate || Objects.nonNull(bookModel.getLibraryId())) {
			savedBook.setLibraryId(bookModel.getLibraryId());
		}
	}

}
