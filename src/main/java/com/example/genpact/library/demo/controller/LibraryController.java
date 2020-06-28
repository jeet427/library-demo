package com.example.genpact.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.genpact.library.demo.exception.ItemNotFoundException;
import com.example.genpact.library.demo.model.LibraryModel;
import com.example.genpact.library.demo.service.library.LibraryService;

/**
 * 
 * Controller to handle library management requests
 * 
 * @author jitmathu
 *
 */
@RestController
@RequestMapping("/library")
@CrossOrigin("*")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@GetMapping("/sample")
	@ResponseStatus(value = HttpStatus.OK)
	public LibraryModel getMessage() {
		return new LibraryModel("Library 1");
	}
	
	@GetMapping("/find/library/{libraryId}")
	@ResponseStatus(value = HttpStatus.OK)
	public LibraryModel findBook(@PathVariable("libraryId") Long libraryId)
			throws ItemNotFoundException {
		return this.libraryService.findById(libraryId);
	}
	
	@GetMapping("/find/library")
	@ResponseStatus(value = HttpStatus.OK)
	public List<LibraryModel> findBook()
			throws ItemNotFoundException {
		return this.libraryService.findAll();
	}

	@PostMapping("/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createLibrary(@RequestBody LibraryModel libraryModel) {
		this.libraryService.saveLibrary(libraryModel);
	}

}
