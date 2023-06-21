package com.kinoteka.kinoteka.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinoteka.kinoteka.model.User;
import com.kinoteka.kinoteka.service.UserService;

@RestController
@lombok.RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService userService;

	@GetMapping 
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = this.userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/{username}") 
	public ResponseEntity<User> getUser(@PathVariable String username) {
		User foundUser = this.userService.getUser(username);
		
		if(foundUser == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(foundUser);
	} 
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User userForCreate) {
		User createdUser = this.userService.createUser(userForCreate);
		if(createdUser != null) {
			return ResponseEntity.ok(createdUser);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
		boolean isUserDeleted = this.userService.deleteUser(id);
		if(isUserDeleted != false) {
			return ResponseEntity.ok(isUserDeleted);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User userForUpdate) {
		User updatedUser = this.userService.updateUser(userForUpdate);
		return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
	}
}
