package com.springboot.practice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public Iterable<Users> allUsers()
	{
		return repo.findAll();
	}
	
	public Users getUserByname(String name) {
		Users username = repo.findByName(name);
		return username;
	}
	
	public Users getUserById(int id) {
		Optional<Users> userfound = repo.findById(id);
		
		if(!userfound.isPresent()) {
			throw new UserNotFoundException();
		}
		return (userfound.get());
	}
	
	public void updateUser(Users update) {
		repo.save(update);
	}
}
