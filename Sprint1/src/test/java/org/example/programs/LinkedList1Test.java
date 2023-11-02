package org.example.programs;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class LinkedList1Test {
    @Test
    public void testLinkedListOperations(){
        LinkedList<String> ll = new LinkedList<>();
       ll.add("Nandu");
       ll.add("Siva");
       ll.add("Sanjay");
        ll.add("Anvi");

        Iterator<String> itr = ll.iterator();

        assertTrue(itr.hasNext());
        assertEquals("Nandu",itr.next());

        assertTrue(itr.hasNext());
        assertNotEquals("Varma",itr.next());
    }

}
