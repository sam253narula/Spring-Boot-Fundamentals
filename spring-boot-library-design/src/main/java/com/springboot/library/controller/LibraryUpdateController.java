package com.springboot.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.entity.Library;
import com.springboot.library.exception.LibraryNotFoundException;
import com.springboot.library.exception.LibraryNotFoundRuntimeException;
import com.springboot.library.repository.LibraryRepository;

@RestController
public class LibraryUpdateController {

	@Autowired
	LibraryRepository libraryRepository;
	
	@PutMapping("/updateLibraryNameById")
	public void updateLibraryNameById(String name, Long id) throws Exception {
		Optional<Library> optionalLibrary =  libraryRepository.findById(id);
		if(optionalLibrary.isPresent()) {
			Library library = optionalLibrary.get();
			library.setName(name);
			libraryRepository.saveAndFlush(library);
		}
		else {
			//throw new RuntimeException("There is no Library with id "+ id);
		//	throw new Exception("There is no Library with id "+ id);
			throw new LibraryNotFoundException("There is no Library with id "+ id);
			//throw new LibraryNotFoundRuntimeException("There is no Library with id "+ id);
		}
	}
}









