package com.springboot.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.library.entity.Library;
import com.springboot.library.service.LibraryReadService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;
	
	@ApiOperation(value = "Get All Libraries", notes = "This API allows us to fetch all Libraries")
	@GetMapping("/getAllLibrary")
	public List<Library> getAllLibrary() {
		return readService.getAllLibrary();
	}
	
	@ApiOperation(value = "Get All Libraries With No Books", notes = "This API allows us to fetch all Libraries from the library table which ahs no books in it")
	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}
	
	@ApiOperation(value = "Get Libraries Paged", notes = "This API allows us to fetch all libraries in the paged format")
	@GetMapping("/getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readService.getLibrariesPaged();
	}
	
	@ApiOperation(value = "Get Libraries Custom Paged", notes = "This API allows us to fetch all libraries from the library table and also always us to customize the output or returned page format")
	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnAPage);
	}
	
	@ApiOperation(value = "Get Libraries With Latest Added Order", notes = "This API allows us to fetch all Libraries from the library table and displays them by the latest added order")
	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readService.getLibrariesWithLatestAddedOrder();

	}
	
	@ApiOperation(value = "Get Libraries Custom Sorted By Id", notes = "This API fetchs all the libraries from the Library table and allows us to customize the order of the returned list of libraries by Id")
	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readService.getLibrariesCustomSortedById(direction);
	}

	@ApiOperation(value = "Get Libraries Custom Sorted By Name", notes = "This API fetchs all the libraries from the Library table and allows us to customize the order of the returned list of libraries by name")
	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readService.getLibrariesCustomSortedByName(direction);
	}

	@ApiOperation(value = "Get Libraries Paged And Sorted By Name And With These Books", notes = "This API allows us to fetch particular libraries in page format and custom sorted by name")
	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeperatedBookNames);
	}

	@ApiOperation(value = "Get Libraries Custom Paged And Sorted With Default Order By Name And With These Books", notes = "This API allows us to get Libraries Custom Paged And Sorted With Default Order By Name And With These Books")
	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookNames, int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
				commaSeperatedBookNames, pageNumber, numberOfRecordsOnAPage);
	}

	@ApiOperation(value = "Get Sorted By Name And With These Books", notes = "This API allows us to fetch all libraries with particular books and sorted by name")
	@GetMapping("/getSortedByNameAndWithTheseBooks")
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getSortedByNameAndWithTheseBooks(commaSeperatedBookNames);
	}

	@ApiOperation(value = "Get Libraries By Ids", notes = "This API allows us to fetch a list of libraries with a list of ids")
	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readService.getLibrariesByIds(ids);
	}

	@ApiOperation(value = "Get A Library By Id", notes = "This API allows us to fetch a single library by id")
	@GetMapping("/getALibraryById")
	public Optional<Library> getALibraryById(Long id) {
		return readService.getALibraryById(id);
	}
	
	@ApiOperation(value = "Get A Library With These Books", notes = "This API allows us to fetch a single library by books")
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getALibraryWithTheseBooks(commaSeperatedBookNames);
	}
	
	@ApiOperation(value = "Get Libraries Paged And Sorted By Name", notes = "This API allows us to fetch libraries in page format and sorted by name")
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPagedAndSortedByName();
	}
	
}
