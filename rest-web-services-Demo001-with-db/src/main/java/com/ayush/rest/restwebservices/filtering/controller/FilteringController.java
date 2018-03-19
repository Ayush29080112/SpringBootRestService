package com.ayush.rest.restwebservices.filtering.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.rest.restwebservices.bean.SomeBean;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
}
