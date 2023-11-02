package org.example.programs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void testFibonacciNegative() {
        assertNotEquals(34,Fibonacci.getFib(10));
    }

    @Test
    void testFibonacciPositive() {
        assertEquals(55,Fibonacci.getFib(10));
    }

}