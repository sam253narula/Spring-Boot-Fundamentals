package com.springboot.library.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*In order to define the composite primary keys, we should follow some rules:
The composite primary key class must be public.
It must have a no-arg constructor.
It must define the equals() and hashCode() methods.
It must be Serializable.*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentID implements Serializable {

	private int id;
	
	private String passportNumber;
}
