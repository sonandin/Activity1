package org.example.programs;

import java.util.Scanner;

public class B {

    public static boolean isPrime(int n){

        if(n<=1)
            return false;
        for(int i=2;i<=n/2; i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    //Palindrome
    public static boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i<j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.next();
        System.out.println("Enter a number");
        int n = sc.nextInt();

        String result = isPrime(n)?"isPrime":"not Prime";//ternary operator
        System.out.println(result);
        String result1 = isPalindrome(s)?"isPalindrome ":"not Palindrome";//ternary operator
        System.out.println(result1);
    }
}
