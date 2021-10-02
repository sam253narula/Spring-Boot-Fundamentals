package com.springboot.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(Long id);

	boolean checkLibraryExistsByExample(String commaSeperatedBookNames);

}