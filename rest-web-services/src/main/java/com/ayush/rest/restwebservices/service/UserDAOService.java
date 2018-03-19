package com.ayush.rest.restwebservices.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ayush.rest.restwebservices.Exception.UserNotFoundException;
import com.ayush.rest.restwebservices.bean.User;

@Component
public class UserDAOService {

	private static int userCount=3;
	
	private static List<User> users=new ArrayList<User>();
	static{
		users.add(new User(1, "Vinay", new Date()));
		users.add(new User(2, "Archana", new Date()));
		users.add(new User(3, "Ayush", new Date()));
		
		
		
	}
	
	public List<User> findAll(){
		return users;
	}
	public User save(User user){
		if(user.getId()==null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	public User findById(int id){
		for (User user : users) {
			if(id==user.getId()){
				return user;
			}
		}
		return null;
	}
	public void removeId(int id){
		boolean value=users.removeIf(s->s.getId()==id);
		if(!value) {
			throw new UserNotFoundException("Chutiye kuch bhi mtlb");
		}
	}
	
	
}
