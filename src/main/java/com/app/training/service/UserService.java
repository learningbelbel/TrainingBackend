package com.app.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.training.model.User;
import com.app.training.repository.UserRepository;

@Service
public class UserService {
	
	/*
	 * Here we're make the CRUD
	 * */
	
	
	@Autowired
	UserRepository repository;
	public User createUser(User user) {
		return repository.save(user); /* es lo mismo que INSERT INTO USERS (values) PERO El repository lo hace por mi*/
	}
	public List<User> getUsers(){
		return repository.findAll();
	}
	public User updateUser(User user, Long id ) {
		User userToUpdate = repository.findById(id).orElseThrow(()-> new RuntimeException("El usuario no existe"));
		
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setFullname(user.getFullname());
		
		return repository.save(userToUpdate);
	}
	
	public String delete(Long id){
		repository.deleteById(id);
		return "Eliminado con Exito";
	}
	
	
	@Transactional
	public String deletebyFullname(String fullname) {
		repository.deleteByFullname(fullname);
		return "Eliminado con Exito";
	}
	
	@Transactional
	public String deletebyPass(String password) {
		repository.deleteBypassword(password);
		return "Eliminado by pass";
	}

}
