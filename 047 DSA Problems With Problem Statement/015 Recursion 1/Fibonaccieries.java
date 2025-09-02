/*
Problem Name: Fibonacci Series Using Recursion
Problem Statement:
-----------------
Write a Java program to generate the Fibonacci series up to a given position 
using recursion.

The program should:
1. Take an integer 'n' as input representing the position up to which to print.
2. If n is negative, print an error message.
3. Use a recursive method to calculate the nth Fibonacci number:
   - Base cases: fib(0) = 0, fib(1) = 1
   - Recursive case: fib(n) = fib(n-1) + fib(n-2)
4. Use a recursive method to print the series from position 0 up to n.
5. Display the Fibonacci series.

Example:
Input: 5
Output: Fibbo series upto 5 positions are : 0 1 1 2 3 5
Explanation: The Fibonacci sequence starts with 0 and 1, and each subsequent 
number is the sum of the previous two numbers.
*/


import java.util.Scanner;

public class Fibonaccieries {
    //Find nth position
    public static int fib(int n){
        if(n<=1) return n;
        return  fib(n-1)+fib(n-2);
    }

    //Print series
    public static void printSeries(int count , int position){
        if(count>position){
            return;
        }
        System.out.print(fib(count) + " ");
        printSeries(count+1, position);
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the postion upto which to print : ");
        int n = sc.nextInt();
        if(n<0){
            System.out.println("Position can not be a negative number.");
        }else{
            System.out.println("Fibbo series upto " + n + "Postion are : ");
            printSeries(0, n);
        }
    }
}
