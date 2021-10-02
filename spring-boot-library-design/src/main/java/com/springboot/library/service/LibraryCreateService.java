package com.springboot.library.service;

import java.util.List;

import com.springboot.library.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibrararywithSaveAndFlush(Library library);

}