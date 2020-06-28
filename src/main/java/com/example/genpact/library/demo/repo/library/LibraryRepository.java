package com.example.genpact.library.demo.repo.library;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.genpact.library.demo.model.LibraryModel;

@Repository
public interface LibraryRepository extends CrudRepository<LibraryModel, Long>{

}
