package com.springboot.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.springboot.library.entity.Library;

public interface LibraryReadService {

	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getLibrariesPaged();

	Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getLibrariesWithLatestAddedOrder();

	List<Library> getLibrariesCustomSortedById(Direction direction);

	List<Library> getLibrariesCustomSortedByName(Direction direction);

	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);

	Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookNames, int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);

	List<Library> getLibrariesByIds(List<Long> ids);

	Optional<Library> getALibraryById(Long id);

	Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookNames);

	Page<Library> getLibrariesPagedAndSortedByName();

}