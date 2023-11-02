package org.example.programs;

import java.util.Scanner;

public class A {
    //addition
    static int add(int a,int b)
    {
        return a+b;
    }
//subtraction
    static int subtract(int a,int b)
    {
        return a-b;
    }
//multiply
    static int multiply(int a,int b)
    {
        return a*b;
    }

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter the first number
            System.out.print("Enter the first number: ");
            int a = scanner.nextInt();

            // Prompt the user to enter the second number
            System.out.print("Enter the second number: ");
            int b = scanner.nextInt();
        int result1 = add(a,b);
        int result2 = subtract(a,b);
        int result3 = multiply(a,b);

        // Print the results
        System.out.println("Addition " +a + "+" +b+ "=" +result1);
        System.out.println("Subtraction " +a + "-" +b+ "="+ result2);
        System.out.println("Multiplication " +a + "*" +b+ "="+ result3);
    }
}
