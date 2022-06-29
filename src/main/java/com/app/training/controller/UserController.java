package com.app.training.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.training.converter.UserConverter;
import com.app.training.model.User;
import com.app.training.proyections.UserProyection;
import com.app.training.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserConverter userConverter;
	/**
	 * @requestBody, is used to represent the HTTP body request
	 * @return
	 */
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<UserProyection> getUsers(){
		return userService.getUsers().stream().map(user ->{
			return userConverter.convert(user);
		}).collect(Collectors.toList());
	}
	
	/*Request body, body what i'm getting and will change*/
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUser(user, id);
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.delete(id);
	}
	@DeleteMapping("/name/{name}")
	public String deletebyFullName(@PathVariable String name) {
		return userService.deletebyFullname(name);
	}
	
	
	@DeleteMapping("/pass/{password}")
	public String deletebyPassword(@PathVariable String password) {
		return userService.deletebyPass(password);
	}

}
