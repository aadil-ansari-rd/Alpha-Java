/*
Problem Name: Factorial Using Recursion
Problem Statement:
-----------------
Write a Java program to calculate the factorial of a given positive integer 
using recursion.

The program should:
1. Take an integer 'n' as input.
2. If n is 1, return 1 (base case).
3. Otherwise, return n multiplied by the factorial of (n-1) recursively.
4. Print the calculated factorial.

Example:
Input: 6
Output: 720
Explanation: 6! = 6 × 5 × 4 × 3 × 2 × 1 = 720
*/


public class Factorial {
    public static int factorial(int n){
        if(n==1){
            return  1;
        }
        return  n * factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }
}
