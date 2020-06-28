package com.example.genpact.library.demo.repo.book;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.genpact.library.demo.model.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {

	List<BookModel> findAllBooks(@Param("libraryId") Long libraryId);

	BookModel findBook(@Param("libraryId") Long libraryId, @Param("bookId") Long bookId);

}
