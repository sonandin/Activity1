package com.microservice.controller;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.service.AddSubService;
import com.microservice.service.FibonacciService;
import com.microservice.service.PalindromeService;

@RestController
@RequestMapping("/api")
public class SampleController {
	@Autowired
	private AddSubService service;

	@Autowired
	private FibonacciService fibService;

	@Autowired
	private PalindromeService palindromeService;


	// add
	// http://localhost:9091/api/add/2/9
	@GetMapping("/add/{num1}/{num2}")
	public ResponseEntity<Integer> add(@PathVariable("num1")  int num1,
			@PathVariable("num2") int num2) {
		return new ResponseEntity<>(service.add(num1, num2), HttpStatus.OK);
	}

	// sub
	// http://localhost:9091/api/sub/2/9
	@GetMapping("/sub/{num1}/{num2}")
	public ResponseEntity<Integer> sub(@PathVariable("num1") int num1,
			@PathVariable("num2")  int num2) {
		return new ResponseEntity<>(service.sub(num1, num2), HttpStatus.OK);
	}
	
	

	// http://localhost:9091/api/fib/10
	// fib
	@GetMapping("/fib/{limit}")
	public ResponseEntity<List<Integer>> fibonacci(@PathVariable("limit") int limit) {
		return new ResponseEntity<>(fibService.getFibonacci(limit), HttpStatus.OK);
	}
	
	
	

	// http://localhost:9091/api/pallindrome/subbu
	// http://localhost:9091/api/pallindrome/madam
	// palindrome check
	@GetMapping("/palindrome/{string}")
	public ResponseEntity<String> palindrome(@PathVariable("string") String string) {

		return new ResponseEntity<>(palindromeService.isPalindrome(string), HttpStatus.OK);
	}

	

}
