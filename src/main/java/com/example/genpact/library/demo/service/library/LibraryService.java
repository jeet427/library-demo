package com.example.genpact.library.demo.service.library;

import java.util.List;

import com.example.genpact.library.demo.model.LibraryModel;

public interface LibraryService {

	void saveLibrary(LibraryModel libraryModel);

	LibraryModel findById(Long id);

	List<LibraryModel> findAll();

}
