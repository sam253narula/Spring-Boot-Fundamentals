package com.springboot.library.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class StudentWithCompositeKeyWithEmbeddableAnnotation {
	
	@EmbeddedId
	StudentIDWithEmbeddableAnnotation studentId;
	
	private String name;
}
