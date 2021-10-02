package com.springboot.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.entity.Library;
import com.springboot.library.service.LibraryCreateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/createService")
public class LibraryCreateController {

	@Autowired
	LibraryCreateService createService;
		
	@ApiOperation(value = "Add Single Library", notes = "This API allows you to add a single library to Library table")
	@PostMapping("/addSingleLibrary")
	public String addSingleLibrary(Library library) {
		return createService.addSingleLibrary(library);
	}
	
	@ApiOperation(value = "Add Multiple Libraries", notes = "This API allows you to add multiple libraries to Library table")
	@PostMapping("/insertAllLibraries")
	public String insertAllLibraries(@RequestBody List<Library> libraries) {
		return createService.addAllLibraries(libraries);
	}
		
	@ApiOperation(value = "Add Single Library", notes = "This API allows you to add single library to Library table and it internally uses a combined method of save and flush")
	@PostMapping("/addLibrararywithSaveAndFlush")
	public Library addLibrararywithSaveAndFlush(Library library) {
		return createService.addLibrararywithSaveAndFlush(library);
	}
	
	
}



