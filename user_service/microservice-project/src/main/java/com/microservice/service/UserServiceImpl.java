package com.microservice.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.exception.UserAlreadyExistsException;
import com.microservice.exception.UserNotFoundException;
import com.microservice.model.User;
import com.microservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User add(User user) throws UserAlreadyExistsException {

		try {
			Optional<User> user1 = userRepo.findById(user.getUserId());
			if (!user1.isPresent())
				userRepo.save(user);
			else
				throw new UserAlreadyExistsException("user already exists with id: " + user.getUserId());
		} catch (UserAlreadyExistsException ex) {
			throw new UserAlreadyExistsException(ex.getMessage());
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(Long id) throws UserNotFoundException {
		/*
		 * User user = userRepo.findById(id).orElseThrow(() -> new
		 * UserNotFoundException("user not found with id:" + id)); return user;
		 */
		try {
			Optional<User> user = userRepo.findById(id);
			if (user.isPresent())
				return user.get();
			else
				throw new UserAlreadyExistsException("user not found with id:" + id);
		} catch (UserNotFoundException ex) {
			throw new UserAlreadyExistsException(ex.getMessage());
		}

	}

	@Override
	public User update(Long id, User user) throws UserNotFoundException {
		User updatedUser = userRepo.findById(id).orElseThrow(
				() -> new UserNotFoundException("user update cannot be done, user not exists with id: " + id));
		updatedUser.setUserId(user.getUserId());
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setDepartment(user.getDepartment());
		updatedUser.setAge(user.getAge());
		return userRepo.save(updatedUser);
	}

	@Override
	public User delete(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found with id: " + id));
		userRepo.deleteById(id);
		return user;
	}
	// new method using streams and collection api's

	@Override
	public Map<String, List<User>> getUsersByDept() {

		return findAll().stream().collect(Collectors.groupingBy(User::getDepartment));
	}

	@Override
	public List<User> getUsersByAge(int age) {

		return findAll().stream().filter(user -> user.getAge() < age).collect(Collectors.toList());
	}

	@Override
	public List<User> getUsersFromDeptByAge(int age, String dept) {
		
		return findAll().stream().filter(user->user.getDepartment()==dept).collect(Collectors.toList());
	}

}
