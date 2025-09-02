/*
Problem Name: N-th Fibonacci Number Using Recursion
Problem Statement:
-----------------
Write a Java program to find the N-th Fibonacci number using recursion.

The program should:
1. Take an integer 'n' as input representing the position in the Fibonacci sequence.
2. Return the Fibonacci number at the N-th position.
3. Use the recursive formula: 
      fib(0) = 0, fib(1) = 1
      fib(n) = fib(n-1) + fib(n-2) for n > 1

Example:
Input: 10
Output: 55
Explanation: The first 10 Fibonacci numbers are 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55. 
The 10th Fibonacci number is 55.
*/


public class NthFibboPosition {
    public static int fib(int n){
        if(n<=1) return n;
        return  fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
