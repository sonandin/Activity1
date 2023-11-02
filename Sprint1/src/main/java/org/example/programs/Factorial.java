package org.example.programs;

public class Factorial {
   public static void main(String[] args){
       System.out.println(calculateFactorial(0));
       System.out.println(getFactorial(0));
   }

    static int calculateFactorial(int n) {
       if(n==0 || n==1)
           return 1;
       return n* calculateFactorial(n-1);
    }
    static int getFactorial(int n) {
        int fact = 1;
        for(int i=n;i>=1;i--){
            fact = fact *i;
        }
        return fact;
    }

}
