package org.example.programs;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1 {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();
        ll.add("Nandu");
        ll.add("Siva");
        ll.add("Sanjay");
        ll.add("Avi");

        Iterator<String> itr = ll.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}