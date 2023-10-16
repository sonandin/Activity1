package com.microservice.service;

import java.util.List;

import com.microservice.exception.UserAlreadyExistsException;
import com.microservice.exception.UserNotFoundException;
import com.microservice.model.User;

public interface UserService {
	public User add(User user) throws UserAlreadyExistsException;

	public List<User> findAll();

	public User update(Long id, User user)throws UserNotFoundException;

	public User delete(Long id)throws UserNotFoundException;
}
