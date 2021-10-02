package com.springboot.library.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springboot.library.entity.Library;
import com.springboot.library.repository.LibraryRepository;
import com.springboot.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	LibraryRepository readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeperatedBooknames("");
		// Below exampleMatcher will make sure that only commaSeperatedBooknamesis
		// considered and id and name are ignored
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable first3records = PageRequest.of(0, 3);
		return readRepository.findAll(first3records);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		Pageable first3records = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepository.findAll(first3records);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable first3records = PageRequest.of(0, 3, Sort.by("name"));
		return readRepository.findAll(example, first3records);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookNames, int pageNumber, int numberOfRecordsOnAPage) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable customPage = PageRequest.of(pageNumber, numberOfRecordsOnAPage, Sort.by("name"));
		return readRepository.findAll(example, customPage);

	}

	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
	}

	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getALibraryById(Long id) {
		return readRepository.findById(id);
	}

	@Override
	public Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageable =  PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}
	

}
