package com.microservice.service;

//import com.microservice.service.PalindromeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeServiceImplTest {

    @Mock
    private PalindromeService palindromeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsPalindromeWithPalindromeString() {
        String input = "racecar";

        // Mock the method to return the expected result
        Mockito.when(palindromeService.isPalindrome(input)).thenReturn(input + " is a Palindrome");

        // Call the actual method to be tested
        String result = palindromeService.isPalindrome(input);

        // Verify that the method was called with the expected input
        Mockito.verify(palindromeService).isPalindrome(input);

        // Verify the result
        assertEquals(input + " is a Palindrome", result);
    }

    @Test
    public void testIsPalindromeWithNonPalindromeString() {
        String input = "hello";

        // Mock the method to return the expected result
        Mockito.when(palindromeService.isPalindrome(input)).thenReturn(input + " is Not a Palindrome");

        // Call the actual method to be tested
        String result = palindromeService.isPalindrome(input);

        // Verify that the method was called with the expected input
        Mockito.verify(palindromeService).isPalindrome(input);

        // Verifying  the result
        assertEquals(input + " is Not a Palindrome", result);
    }
}
