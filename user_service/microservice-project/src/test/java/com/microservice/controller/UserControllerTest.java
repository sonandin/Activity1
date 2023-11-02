package com.microservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.microservice.model.User;
import com.microservice.service.UserService;

class UserControllerTest {

	@Mock
	private UserService serviceMock;

	@InjectMocks
	private UserController controller;

	private User user;

	@BeforeEach
	void setup() {
		user = new User();
		user.setUserId((long) (100));
		user.setFirstName("Nagarjuna");
		user.setLastName("Bindas");
		user.setDepartment("IT");
		user.setAge(39);
		
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAdd() {
		when(serviceMock.add(user)).thenReturn(user);
		ResponseEntity<User> addResponse = controller.add(user);
		
		assertEquals(HttpStatus.CREATED,addResponse.getStatusCode());
		//sample
		assertEquals("Bindas",serviceMock.add(user).getLastName());
	}

	// negative test add
	@Test
	void testAddNegative() {
		when(serviceMock.add(user)).thenReturn(user);
		ResponseEntity<User> addResponse = controller.add(user);
		
		assertNotEquals(HttpStatus.OK,addResponse.getStatusCode());
		//sample
		assertNotEquals("Binda",serviceMock.add(user).getLastName());
	}

	@Test
	void testUpdate() {
		User newUser = new User();
		newUser.setUserId((long) (200));
		newUser.setFirstName("Chaitanya");
		newUser.setLastName("Bindas");
		newUser.setDepartment("IT");
		newUser.setAge(45);
		when(serviceMock.update((long) (100), newUser)).thenReturn(newUser);
		ResponseEntity<User> updateResponse = controller.update((long) (100), newUser);
		assertEquals(HttpStatus.OK, updateResponse.getStatusCode());
		// sample
		assertEquals("Chaitanya", serviceMock.update((long) (100), newUser).getFirstName());
	}

	// delete
	@Test
	void testDelete() {
		User deletingUser = new User();
		deletingUser.setUserId((long) (100));
		deletingUser.setFirstName("Nagarjuna");
		deletingUser.setLastName("Bindas");
		deletingUser.setDepartment("IT");
		deletingUser.setAge(45);
		when(serviceMock.delete(deletingUser.getUserId())).thenReturn(deletingUser);
		ResponseEntity<String> deleteResponse = controller.delete(deletingUser.getUserId());
		assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
	}

	@Test
	void testFindAll() {
		List<User> list = new ArrayList<>();
		User user1 = new User((long) 101, "siva", "nandini", "Forensic",30);
		User user2 = new User((long) 102, "Nag", "Karan", "IT",45);
		list.add(user1);
		list.add(user2);
		when(serviceMock.findAll()).thenReturn(list);
		assertEquals(HttpStatus.OK, controller.findAll().getStatusCode());
		assertEquals(2,serviceMock.findAll().size());
	}
	

}
