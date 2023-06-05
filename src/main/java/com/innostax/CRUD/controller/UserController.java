package com.innostax.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.innostax.CRUD.dao.UserRepositoryImpl;
import com.innostax.CRUD.entity.User;
import com.innostax.CRUD.service.ServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserRepositoryImpl userRepository;
	
	@Autowired
	ServiceImpl serviceImpl ; 

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userRepository.saveUser(user);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userRepository.updateUser(user);
	}

	@GetMapping("/getById/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userRepository.getById(id);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUser() {
		return userRepository.allUsers();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById (@PathVariable("id") int id) {
		return userRepository.deleteById(id) ;
	}	
	
	@GetMapping("/getAllUsersSortedByName")
	public List<User> getAllUserSortedByName () {
		return serviceImpl.sortedList(getAllUser()) ;
	}

}
