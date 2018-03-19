package com.ayush.rest.restwebservices.bean;

public class Post {
	
	private int id;
	private String description;
	
	private int userId;
	
	
	

	public Post() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Post(int id, String description, int userId) {
		super();
		this.id = id;
		this.description = description;
		this.userId = userId;
	}
	public Post(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
	
	

}
