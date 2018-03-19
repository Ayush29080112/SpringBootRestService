package com.ayush.rest.restwebservices.filtering.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.rest.restwebservices.bean.DynamicSomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	//field1 , field 2 required
	@GetMapping("/dynamicfilter")
	public MappingJacksonValue retrieveSomeBean() {
		DynamicSomeBean bean=new DynamicSomeBean("value1","value2","value3");
		
		MappingJacksonValue jacksonValue=new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFIlter", filter);
		jacksonValue.setFilters(filters);
				
		return jacksonValue;
	}
}
