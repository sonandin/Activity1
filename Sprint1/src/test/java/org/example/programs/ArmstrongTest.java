package org.example.programs;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongTest {

    @Test
    public void testIsArmstrongWithArmstrongNumber() {
        // Test with an Armstrong number (e.g., 153)
        boolean result = Armstrong.isArmstrong(153);
        assertEquals(true, result);
    }

    @Test
    public void testISArmstrongWithNoArmstrongNumber(){

        boolean result = Armstrong.isArmstrong(123);
        assertEquals(false ,result);
    }
}
