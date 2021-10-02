package com.springboot.library.service;

import org.springframework.stereotype.Component;

import com.springboot.library.model.SpringBootAppInfo;

@Component
public interface ExampleService {

	SpringBootAppInfo get();

	SpringBootAppInfo customInfo(String courseName, String courseType, String firstName, String lastname);

}