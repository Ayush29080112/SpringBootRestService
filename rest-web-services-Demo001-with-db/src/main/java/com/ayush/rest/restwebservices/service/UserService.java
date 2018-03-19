package com.ayush.rest.restwebservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayush.rest.restwebservices.Exception.UserNotFoundException;
import com.ayush.rest.restwebservices.entity.Post;
import com.ayush.rest.restwebservices.entity.User;

@Component
public class UserService {
	@Autowired
	private UserDao daoService;
	@Autowired
	private PostDao postDao;
	
	public List<com.ayush.rest.restwebservices.bean.User> findAll(){
		List<User> user=daoService.findAll();
		List<com.ayush.rest.restwebservices.bean.User> list=new ArrayList<>();
		for (User user2 : user) {
			com.ayush.rest.restwebservices.bean.User user3=new com.ayush.rest.restwebservices.bean.User(user2.getId(), user2.getName(), user2.getBirthDate());
			list.add(user3);
		}
		return list;
	}
	
	public com.ayush.rest.restwebservices.bean.User findById(int id){
		Optional<User> user=daoService.findById(id);
		com.ayush.rest.restwebservices.bean.User user3 = null;
		if(user.isPresent()) {
			User user2=user.get();
			user3=new com.ayush.rest.restwebservices.bean.User(user2.getId(), user2.getName(), user2.getBirthDate());
		}
		return user3;
	}
	
	public com.ayush.rest.restwebservices.bean.User save(com.ayush.rest.restwebservices.bean.User user){
		
		User user2=new User();
		user2.setBirthDate(user.getBirthDate());
		user2.setName(user2.getName());
		
		daoService.save(user2);
		
		user.setId(user2.getId());
		return user;
	}
	
	
	public void deleteById(int id){
		
		daoService.deleteById(id);
	}

	

	public List<com.ayush.rest.restwebservices.bean.Post> findAllPostsByUser(int id) {
		Optional<User> user=daoService.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("Galat Id mt diya kr bhai mere");
		}
		List<Post> post=user.get().getPost();
		List<com.ayush.rest.restwebservices.bean.Post> posts=new ArrayList<>();
		for (Post post2 : post) {
			com.ayush.rest.restwebservices.bean.Post post3=new com.ayush.rest.restwebservices.bean.Post(post2.getId(), post2.getDescription(),id);
			posts.add(post3);
		}
		
		return posts;
	}

	public int save(com.ayush.rest.restwebservices.bean.Post post,int id) {
		Optional<User> user=daoService.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("Galat Id mt diya kr bhai mere");
		}
		Post post2=new Post();
		post2.setUser(user.get());
		post2.setDescription(post.getDescription());
		postDao.save(post2);
		
		return post2.getId();
	}
}
