package com.springboot.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.library.entity.StudentID;
import com.springboot.library.entity.StudentIDWithEmbeddableAnnotation;
import com.springboot.library.entity.StudentWithCompositeKeyWithEmbeddableAnnotation;
import com.springboot.library.entity.StudentWithCompositeKeyWithIDClassAnnotation;

public interface StudentRepositoryEmbeddable extends JpaRepository<StudentWithCompositeKeyWithEmbeddableAnnotation, StudentIDWithEmbeddableAnnotation> {

}
