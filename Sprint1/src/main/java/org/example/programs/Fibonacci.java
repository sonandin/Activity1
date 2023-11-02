package org.example.programs;

public class Fibonacci {

        public static void main(String[] args) {

//		fibonacci();

//		System.out.println(getFib(10));

            for(int i=0;i<=10;i++) {

                System.out.println(getFib(i));

            }

        }

        public static void fibonacci() {

            int a = 0, b = 1, c = 0;

            for (int i = 0; i <= 10; i++) {

                System.out.println(a);

                c = a + b;

                a = b;

                b = c;

            }

        }

        //recursive function to test the

        public static int getFib(int n) {

            if(n==0)

                return 0;

            if(n==1)

                return 1;

            return getFib(n-1)+getFib(n-2);

        }



    }