package com.example.genpact.library.demo.service.library;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genpact.library.demo.model.LibraryModel;
import com.example.genpact.library.demo.repo.library.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public void saveLibrary(LibraryModel libraryModel) {
		this.libraryRepository.save(libraryModel);
	}

	@Override
	public LibraryModel findById(Long id) {
		return this.libraryRepository.findById(id).get();
	}

	@Override
	public List<LibraryModel> findAll() {
		return StreamSupport.stream(this.libraryRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
