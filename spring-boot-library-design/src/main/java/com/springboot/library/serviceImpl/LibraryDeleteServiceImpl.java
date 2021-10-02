package com.springboot.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.library.entity.Library;
import com.springboot.library.repository.LibraryRepository;
import com.springboot.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted Library: "+ library;
	}
	
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "prune complete";
	}
	
	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Delete All Complete";
	}
	
	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Deleted All in Batch Completed";
	}
	
	@Override
	public String deleteLibraryById(Long id) {
		libraryRepository.deleteById(id);
		return "Library with id: "+id+" is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "Deleted all the libraries in the list in batch mode";
	}
	
	
}






