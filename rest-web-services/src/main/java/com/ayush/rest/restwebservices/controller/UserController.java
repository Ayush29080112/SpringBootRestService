package com.ayush.rest.restwebservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayush.rest.restwebservices.Exception.UserNotFoundException;
import com.ayush.rest.restwebservices.bean.User;
import com.ayush.rest.restwebservices.service.UserDAOService;

@RestController
public class UserController {

	@Autowired
	private UserDAOService userDAOService;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDAOService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> getAllUsers(@PathVariable int id){
		User user=userDAOService.findById(id);	
		
		Resource<User> resource=new Resource<User>(user);
		//ControllerLinkBuilder linkTo=linkTo(methodOn(HelloWorldController.class).helloWorld());
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-Users"));
		return resource;
	}
	
	@GetMapping(path="/users/exception/{id}")
	public ResponseEntity<User> getAllUsersException(@PathVariable int id){
		User user=userDAOService.findById(id);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK); 
	}
	
	@GetMapping(path="/users/exceptionHandled/{id}")
	public ResponseEntity<User> getAllUsersExceptionHandled(@PathVariable int id){
		User user=userDAOService.findById(id);
		if(user==null) {
			throw new UserNotFoundException("/id  -"+id);
		}
		return new ResponseEntity<User>(user, HttpStatus.CONTINUE); 
	}
	
	@PostMapping(path="/userCreate")
	public ResponseEntity<User> addUsers(@RequestBody User user){
		 userDAOService.save(user);
		// URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		 return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	@PostMapping(path="/user")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
		 userDAOService.save(user);
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/user/{id}")
		public void removeUser(@PathVariable int id){
			 userDAOService.removeId(id);
		}
	
	
	
}
