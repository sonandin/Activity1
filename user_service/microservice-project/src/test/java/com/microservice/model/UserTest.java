package com.microservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	private User user;

	@BeforeEach
	void setup() {
		user = new User();
		user.setUserId(Integer.toUnsignedLong(100));
		user.setFirstName("Nagarjuna");
		user.setLastName("Kumara");
		user.setDepartment("IT");
	}

	@Test
	void testForAllGetters() {
		assertEquals(100, user.getUserId());
		assertEquals("Nagarjuna", user.getFirstName());
		assertEquals("Kumara", user.getLastName());
		assertEquals("IT", user.getDepartment());
	}
	
	

}
