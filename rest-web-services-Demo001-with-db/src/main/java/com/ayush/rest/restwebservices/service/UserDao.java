package com.ayush.rest.restwebservices.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayush.rest.restwebservices.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
