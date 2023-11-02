package org.example.programs;
import org.junit.*;
import org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class BTest {
    @Test
    public void testIsPrime(){

        assertTrue(B.isPrime(5));
    }
    @Test
    public void testIsPalindrome(){

        assertTrue(B.isPalindrome("malayalam"));
    }
}
