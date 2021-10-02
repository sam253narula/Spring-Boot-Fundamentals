package com.springboot.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.entity.Library;
import com.springboot.library.service.LibraryDeleteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/deleteService")
public class LibraryDeleteController {
	
	@Autowired
	LibraryDeleteService deleteService;
	
	@ApiOperation(value = "Delete One Library", notes = "This API allows you to delete one library from Library table")
	@DeleteMapping("/deleteOneLibrary")
	public String deleteOneLibrary(Library library) {
		return deleteService.deleteOneLibrary(library);
	}
	
	@ApiOperation(value = "Prune Table",notes = "This API allows you to prune Library table")
	@DeleteMapping("/pruneTable")
	public String pruneTable() {
		return deleteService.pruneTable();
	}
	
	@ApiOperation(value = "Delete All These Libraries", notes = "This API allows you to delete a list of libraries from Library table")
	@PostMapping("/deleteAllThese")
	public String deleteAllThese(@RequestBody List<Library> libraries) {
		return deleteService.deleteAllThese(libraries);
	}
	
	@ApiOperation(value = "Delete All Libraries In Batch Mode",notes = "This API allows you to delete all libraries present in the Library table in batch mode")
	@DeleteMapping("/deleteAllInBatch")
	public String deleteAllInBatch() {
		return deleteService.deleteAllInBatch();
	}
		
	@ApiOperation(value = "Delete Library By Id",notes = "This API allows you to delete single library at a time by ID")
	@DeleteMapping("/deleteLibraryById")
	public String deleteLibraryById(Long id) {
		return deleteService.deleteLibraryById(id);
	}
	
	@ApiOperation(value = "Delete all these Libraries In Batch Mode", notes = "This API allows you to delete a list of libraries from the library table in batch mode")
	@PostMapping("/deleteAllTheseInBatch")
	public String deleteAllTheseInBatch( @RequestBody List<Library> libraries) {
		return deleteService.deleteAllTheseInBatch(libraries);
	}
	
}


