package org.example.programs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    void testCalcuateFactorial() {
        assertEquals(120,Factorial.calculateFactorial(5));
        assertEquals(120,Factorial.getFactorial(5));
    }

}