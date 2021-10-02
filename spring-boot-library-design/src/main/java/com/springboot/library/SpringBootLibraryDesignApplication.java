package com.springboot.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.springboot.library.entity.Library;
import com.springboot.library.service.LibraryCountService;
import com.springboot.library.service.LibraryCreateService;
import com.springboot.library.service.LibraryDeleteService;
import com.springboot.library.service.LibraryExistService;
import com.springboot.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService createServiceImpl;

	@Autowired
	LibraryCountService countServiceImpl;

	@Autowired
	LibraryExistService existServiceImpl;

	@Autowired
	LibraryDeleteService deleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello Spring Boot");
		System.out.println("Hello Dev-Tools");
	}

	@Override
	public void run(String... args) throws Exception {
		// readServiceImplMethodsExecution();
		// createServiceImplMethodsExecution();
		// countServiceImplMethodsExecution();
		// existServiceImplMethodsExecution();
//		log.info("Deleted One Library -> {}", deleteServiceImpl.deleteOneLibrary(Library.builder().id(10l)
//				.commaSeperatedBooknames("xyz, abc, efg").name("C Library").build()));
		// log.info("Prune Library Table -> {}", deleteServiceImpl.pruneTable());
//		List<Library> libraries = new ArrayList<Library>();
//		libraries.add(Library.builder().id(3l).commaSeperatedBooknames("").name("Animal library").build());
//		libraries.add(Library.builder().id(4l).commaSeperatedBooknames("").name("Cloud Library").build());
//		log.info("Delete all these -> {}", deleteServiceImpl.deleteAllThese(libraries));
//		log.info("Delete all in Batch -> {}", deleteServiceImpl.deleteAllInBatch());
		// log.info("Delete Library by id -> {}",
		// deleteServiceImpl.deleteLibraryById(6l));
//		List<Library> libraries = new ArrayList<Library>();
//		libraries.add(Library.builder().id(3l).commaSeperatedBooknames("").name("Animal library").build());
//		libraries.add(Library.builder().id(4l).commaSeperatedBooknames("").name("Cloud Library").build());
//		log.info("Deleting all the libraries in batch -> {}", deleteServiceImpl.deleteAllTheseInBatch(libraries));

	}

	private void existServiceImplMethodsExecution() {
		log.info("Check if Library exist by id -> {}", existServiceImpl.checkLibraryExistsById(11l));
		log.info("Check if Library exist by example -> {}",
				existServiceImpl.checkLibraryExistsByExample("Mars Red Planet, Titan with water"));
	}

	private void countServiceImplMethodsExecution() {
		log.info("Count the number of libraries -> {}", countServiceImpl.countLibraries());
		log.info("Count Libraries with zero books -> {}", countServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("Persist a single Library -> {}", createServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeperatedBooknames("xyz,abc").build()));
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeperatedBooknames("abc,efg").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeperatedBooknames("efg").build());
		log.info("Persist all Libraries -> {}", createServiceImpl.addAllLibraries(libraries));
		log.info("Persist a Library with saveAndFlush combined -> {} ",
				createServiceImpl.addLibrararywithSaveAndFlush(Library.builder().id(14l).name("E-Commerce Libray")
						.commaSeperatedBooknames("Amazon, Flipcart").build()));
	}

	private void readServiceImplMethodsExecution() {
		log.info("Fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());
		log.info("Fetch all libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		log.info("Fetch Libraries in Page format -> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch Libraries in custom page format -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch Libraries with latest added order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("Fetch Libraries custom sorted by id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));
		log.info("Fetch Libraries custom sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));
		log.info("Fetch Libraries default paged, sorted and with these books -> {}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));
		log.info("Fetch Libraries custom paged and default sorted by name and with these books -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("xyz, abc, efg", 1, 2)
						.get().collect(Collectors.toList()));

		log.info("Fetch libraries with default sorted by name -> {}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("xyz, abc, efg"));
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);

		log.info("Fetch Libraries by ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));
		long id = 12l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("Fetch Library by Id -> {}", optionalLibrary.get());
		} else {
			log.info("No matching library with this id " + id + " was found in the DB");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl
				.getALibraryWithTheseBooks("Life of tommy, Life of Brownie");
		if (optionalSingleLibrary.isPresent()) {
			log.info("Fetch Library with these books -> {}", optionalSingleLibrary.get());
		} else {
			log.info("No matching library with this id " + id + " was found in the DB");
		}

		log.info("Fetch Libraries default paged and default sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
	}

}
