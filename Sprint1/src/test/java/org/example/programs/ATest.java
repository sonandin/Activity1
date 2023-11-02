package org.example.programs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ATest {
    //addition test
    @Test


    public void testAdd(){
        assertEquals(246,A.add(123,123));
    }

    //subtraction test
    @Test


    public void testSubtract(){
        assertEquals(0,A.subtract(123,123));
    }

    //multiplication test
    @Test


    public void testMultiplication(){
        assertEquals(18,A.multiply(9,2));
    }
}
