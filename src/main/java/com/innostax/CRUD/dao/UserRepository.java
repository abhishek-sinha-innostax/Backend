package com.innostax.CRUD.dao;

import java.util.List;

import com.innostax.CRUD.entity.User;

public interface UserRepository {
	
	User saveUser(User user) ;
	User updateUser(User user) ;
	User getById (int id) ;
	String deleteById (int id) ;
	List<User> allUsers() ;
	
}
