package com.springboot.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.library.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{
	

}
