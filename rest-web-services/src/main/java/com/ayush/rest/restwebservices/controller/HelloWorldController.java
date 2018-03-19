package com.ayush.rest.restwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.rest.restwebservices.bean.HelloWorldBean;

@RestController // specifies this is a rest controller which will be handling the http requests
public class HelloWorldController {
	@Autowired
	private MessageSource bundleMessageSource;
	
	@RequestMapping(method=RequestMethod.GET ,path="/helloWorld")
	public String helloWorld(){
		return "Hello World";
	}
	@GetMapping(path="/hello-World")
	public String helloWorldGet(){
		return "Hello World";
	}
	@GetMapping(path="/hello-World-Bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World bean");
	}
	
	@GetMapping(path="/hello-World-Bean/{name}")
	public HelloWorldBean helloWorldBeanPathParam(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name ));
	}
	
	@GetMapping(path="/hello-World-Bean/In")
	public String helloWorldBeanPathParam(@RequestHeader(name="Accept-Language", required=false)  Locale locale){
		return bundleMessageSource.getMessage("good.morning.message", null, locale);
	}
}
