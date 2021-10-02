package com.springboot.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.service.LibraryCountService;
import com.springboot.library.serviceImpl.LibraryCountServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/countService")
public class LibraryCountController {
	
	@Autowired
	LibraryCountService countService;
	
	@ApiOperation(value = "Count Libraries", notes = "Counts the number of libraries in the library table")
	@GetMapping("/countLibraries")
	public long countLibraries() {
		return countService.countLibraries();
	}
	
	@ApiOperation(value =  "Count Libraries with No books", notes = "Counts the number of libraries in the library table which has no books in it")
	@GetMapping("/countLibrariesWithZeroBooks")
	public long countLibrariesWithZeroBooks() {
		return countService.countLibrariesWithZeroBooks();
	}
	
	
}
