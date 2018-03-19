package com.ayush.rest.restwebservices.versioning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.rest.restwebservices.bean.Name;
import com.ayush.rest.restwebservices.bean.PersonV1;
import com.ayush.rest.restwebservices.bean.PersonV2;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	//@GetMapping(value="person/param", params="Version=1")
	public PersonV1 personV1() {
		return new PersonV1("Ayush Bajpai");
	}
	
	@GetMapping("v2/person")
	//@GetMapping(value="person/param", params="Version=2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Vinay", "Bajpai"));
	}
	
	// @GetMapping("v1/person")
	@GetMapping(value = "person/param", params = "Version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Ayush Bajpai");
	}

	// @GetMapping("v2/person")
	@GetMapping(value = "person/param", params = "Version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Vinay", "Bajpai"));
	}
		
	// @GetMapping("v1/person")
	// @GetMapping(value="person/param", params="Version=1")
	@GetMapping(value="person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Ayush Bajpai");
	}

	// @GetMapping("v2/person")
	// @GetMapping(value="person/param", params="Version=2")
	@GetMapping(value="person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Vinay", "Bajpai"));
	}
	
	// @GetMapping("v1/person")
	// @GetMapping(value="person/param", params="Version=1")
	@GetMapping(value="person/produces", produces="application/v1+json")
	public PersonV1 produceV1() {
		return new PersonV1("Ayush Bajpai");
	}

	// @GetMapping("v2/person")
	// @GetMapping(value="person/param", params="Version=2")
	@GetMapping(value="person/produces", produces="application/v2+json")
	public PersonV2 produceV2() {
		return new PersonV2(new Name("Vinay", "Bajpai"));
	}

}
