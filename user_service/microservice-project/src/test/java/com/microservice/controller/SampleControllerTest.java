package com.microservice.controller;

import com.microservice.controller.SampleController;
import com.microservice.service.AddSubService;
import com.microservice.service.FibonacciService;
import com.microservice.service.PalindromeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleControllerTest {

    @Mock
    private AddSubService addSubService;

    @Mock
    private FibonacciService fibonacciService;

    @Mock
    private PalindromeService palindromeService;

    @InjectMocks
    private SampleController sampleController;

   
        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testAdd() {
            int num1 = 2;
            int num2 = 9;

            Mockito.when(addSubService.add(num1, num2)).thenReturn(11);

            ResponseEntity<Integer> response = sampleController.add(num1, num2);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(11, response.getBody());
        }

        @Test
        public void testSub() {
            int num1 = 2;
            int num2 = 9;

            Mockito.when(addSubService.sub(num1, num2)).thenReturn(-7);

            ResponseEntity<Integer> response = sampleController.sub(num1, num2);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(-7, response.getBody());
        }

        @Test
        public void testFibonacci() {
            int limit = 10;
            List<Integer> expectedFibonacci = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

            Mockito.when(fibonacciService.getFibonacci(limit)).thenReturn(expectedFibonacci);

            ResponseEntity<List<Integer>> response = sampleController.fibonacci(limit);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(expectedFibonacci, response.getBody());
        }

        @Test
        public void testPalindrome() {
            String palindromeString = "madam";

            Mockito.when(palindromeService.isPalindrome(palindromeString)).thenReturn("madam is a Palindrome");

            ResponseEntity<String> response = sampleController.palindrome(palindromeString);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals("madam is a Palindrome", response.getBody());
        }
    }
