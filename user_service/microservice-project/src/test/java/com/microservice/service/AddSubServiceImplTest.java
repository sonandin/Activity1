package com.microservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class AddSubServiceImplTest {

	@InjectMocks
	private AddSubServiceImpl addSubService;
	
	@BeforeEach
	public void intit() {
		MockitoAnnotations.openMocks(this);//here am initilizing the annotated mocks
		
	}
	//Add positive numbers
	@Test
	public void testAddWithPositiveNumbers() {
		
		int a= 10;
		int b = 15;
		int c = addSubService.add(a, b);
		assertEquals(25,c);
	}
	
	//Add Negative  numbers
	@Test
	public void testAddwithNegativeNumbers() {
		
		int a= -4;
		int b= 8;
		
		assertThrows(IllegalArgumentException.class, ()->addSubService.add(a, b));
	}
	
	// Sub Positive  numbers
	@Test
	public void testSubWithPositiveNumbers() {
		int a = 8;
		int b = 2;
		int c = addSubService.sub(a, b);
		assertEquals(6,c);
	}
	//sub with negative numbers
	
	@Test
	public  void testSubWithNegativeNumbers() {
		int a = 9;
		int b = -5;
		assertThrows(IllegalArgumentException.class,()->addSubService.sub(a, b));
	}
}
