package org.example.programs;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList1{

    public static void main(String[] args) {

      ArrayList<String> list = new ArrayList<>();

      /*  list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list);

    }*/
         list.add("Apple");
         list.add("Banana");
         list.remove("Banana");
         list.add("Cherry");

        Iterator itr= list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}

