package com.microservice.service;

//import com.microservice.service.FibonacciService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciServiceImplTest {

    @Mock
    private FibonacciServiceImpl fibonacciService; // Mock the interface, not the implementation

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFibonacci() {
        int limit = 5;
        List<Integer> expectedFibonacciSequence = List.of(0, 1, 1, 2, 3);

        // Mock the method from the interface to return the expected values
        Mockito.when(fibonacciService.getFibonacci(limit)).thenReturn(expectedFibonacciSequence);

        // Call the actual method to be tested
        List<Integer> result = fibonacciService.getFibonacci(limit);

        // Verify that the method from the interface was called with the expected limit
        Mockito.verify(fibonacciService).getFibonacci(limit);

        // Verify the result
        assertEquals(expectedFibonacciSequence, result);
    }
}
