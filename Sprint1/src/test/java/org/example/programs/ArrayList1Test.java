package org.example.programs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayList1Test {

    @Test
    public void testArrayListOperations(){
       ArrayList<String> list = new ArrayList<>();
       list.add("Apple");
       list.add("Banana");
        list.remove("Banana");
        list.add("Cherry");

        Iterator<String> itr = list.iterator();

        assertTrue(itr.hasNext());
        assertEquals("Apple",itr.next());

        assertFalse(list.contains("Banana"));

        assertTrue(itr.hasNext());
        assertNotEquals("Banana",itr.next());
    }

}
