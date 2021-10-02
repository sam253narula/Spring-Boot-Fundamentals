package com.springboot.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity
@Data
@IdClass(StudentID.class)
public class StudentWithCompositeKeyWithIDClassAnnotation {
	
	@Id
	private int id;
	
	@Id
	private String passportNumber;
	
	private String name;
}
