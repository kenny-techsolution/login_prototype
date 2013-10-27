package com.dovesquare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dovesquare.domain.User;
import com.dovesquare.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Boolean create(User user) {
		User existingUser = repository.findByUsername(user.getUsername());
		if (existingUser != null) 
			return false;
		
		user.getRole().setUser(user);
		User saved = repository.save(user);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean update(User user) {
		User existingUser = repository.findByUsername(user.getUsername());
		if (existingUser == null) 
			return false;
		
		existingUser.getRole().setRole(user.getRole().getRole());
		
		User saved = repository.save(existingUser);
		if (saved == null) 
			return false;
		
		return true;
	}
	
	public Boolean delete(User user) {
		User existingUser = repository.findOne(user.getId());
		if (existingUser == null) 
			return false;
		
		repository.delete(existingUser);
		User deletedUser = repository.findOne(user.getId());
		if (deletedUser != null) 
			return false;
		
		return true;
	}
}