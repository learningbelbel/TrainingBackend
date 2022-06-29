package com.app.training.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.app.training.model.User;
import com.app.training.proyections.UserProyection;

@Service
public class UserConverter implements Converter<User, UserProyection> {

	@Override
	public UserProyection convert(User userModel) {
		
		UserProyection userProyection = new UserProyection();
		
		userProyection.setEmail(userModel.getEmail());
		userProyection.setId(userModel.getId());
		userProyection.setFullname(userModel.getFullname());
		
		
		return userProyection;
	}

}
