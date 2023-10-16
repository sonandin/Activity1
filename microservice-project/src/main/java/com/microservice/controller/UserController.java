package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.exception.UserAlreadyExistsException;
import com.microservice.exception.UserNotFoundException;
import com.microservice.model.User;
import com.microservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	// http://localhost:8585/users/add
	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody User user) throws UserAlreadyExistsException {
		return new ResponseEntity<>(service.add(user), HttpStatus.CREATED);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {
		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> update(@PathVariable("userId") Long userId,@RequestBody User user)throws UserNotFoundException{
		return new ResponseEntity<>(service.update(userId, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId") Long userId) throws UserNotFoundException {
		service.delete(userId);
		return ResponseEntity.ok("user with id: "+userId+" deleted successfully !!!");
	}
}
