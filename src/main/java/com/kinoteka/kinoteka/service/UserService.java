package com.kinoteka.kinoteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kinoteka.kinoteka.model.User;
import com.kinoteka.kinoteka.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		List<User> allUsers = this.userRepository.findAll();

		return allUsers;
	}
	
	public User getUser(String username) {
		User user = this.userRepository.findByUsername(username);

		return user;
	}
	
	public User getUserById(Long id) {
		Optional<User> possibleUser = this.userRepository.findById(id);

		if(possibleUser.isPresent()) {
			return possibleUser.get();
		}

		return null;
	}
	
	public User createUser(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setDescription(user.getDescription());
		
		if(user.getAddress())

		return this.userRepository.save(newUser);
	}
	
	public boolean deleteUser(Long id) {
		User user = this.getUserById(id);
		if(user != null) {
			this.userRepository.deleteById(id);			

			return true;
		}
		
		return false;
	}
	
	public User updateUser(User user) {
		User userFromDb = this.getUserById(user.getId());
		if(userFromDb == null) {
			return null;
		}

		userFromDb.setDescription(user.getDescription());
		userFromDb.setPassword(user.getPassword());
		userFromDb.setUsername(user.getUsername());

		User updatedUser = this.userRepository.save(userFromDb);
		return updatedUser != null ? updatedUser : null; 
	}
}
