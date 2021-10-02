package com.springboot.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.library.entity.StudentID;
import com.springboot.library.entity.StudentWithCompositeKeyWithIDClassAnnotation;

public interface StudentRepositoryIdClass extends JpaRepository<StudentWithCompositeKeyWithIDClassAnnotation, StudentID> {

}
