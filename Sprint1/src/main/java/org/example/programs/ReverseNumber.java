package org.example.programs;

//import java.util.Scanner;
import java.util.*;

public class ReverseNumber{

    public static void main(String[] args){

        System.out.println("Enter the number that you want to reverse:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int reverse_number = reverseNumber(n);
        System.out.println("The reverse of the given number is:" +reverse_number);

    }

    static int reverseNumber(int n) {

        boolean isNoNegative = n<0 ? true : false;
        if(isNoNegative)
        {
            n = n * -1;
        }
        int reverse = 0;
        int lastDigit = 0;
        while(n >= 1){
            lastDigit = n %10;
            reverse = reverse * 10 + lastDigit;
            n = n/10;
        }
        return isNoNegative == true? reverse * -1 : reverse;
    }
}