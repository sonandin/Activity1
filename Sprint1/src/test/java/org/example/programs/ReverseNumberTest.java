package org.example.programs;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseNumberTest {

    @Test
    public void testReverseNumber()
    {
        assertEquals(12345,ReverseNumber.reverseNumber(54321));
        assertNotEquals(32456,ReverseNumber.reverseNumber(123445));
    }
}
