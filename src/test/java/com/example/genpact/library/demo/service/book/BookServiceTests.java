package com.example.genpact.library.demo.service.book;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.StringUtils;

import com.example.genpact.library.demo.model.BookModel;
import com.example.genpact.library.demo.repo.book.BookRepository;

@SpringBootTest
public class BookServiceTests {

	@Autowired
	private BookServiceImpl bookService;

	@MockBean
	private BookRepository bookRepository;

	@BeforeEach
	void initUseCase() {
		bookService.setBookRepository(bookRepository);
	}

	@Test
	public void createBookEntryTest() {
		BookModel bookModel = new BookModel();
		bookModel.setBookDesc("Desc");
		bookModel.setBookTitle("Title");
		bookModel.setContent("Content");
		bookModel.setIsbn("ISBN");
		bookModel.setLibraryId(1l);
		if (bookModel != null)
			bookModel = this.bookService.createBookEntry(bookModel);
		
		assertNotNull(bookModel);
		assertNotNull(bookModel.getBookId());
	}

	@Test
	public void updateBookEntryTest() {

	}

	@Test
	public void deleteBookTest() {

	}

	@Test
	public void findBookTest() {

	}

	@Test
	public void findAllTest() {

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
