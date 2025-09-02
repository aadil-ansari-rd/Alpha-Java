/*
Problem Name: Sum of First N Natural Numbers Using Recursion
Problem Statement:
-----------------
Write a Java program to calculate the sum of the first N natural numbers using recursion.

The program should:
1. Take an integer 'n' as input.
2. Compute the sum of numbers from 1 to n recursively.
3. Return the result.

Example:
Input: 6
Output: 21
Explanation: 1 + 2 + 3 + 4 + 5 + 6 = 21

Approach:
- Base case: if n == 1, return 1.
- Recursive case: return n + sumOfFirstN(n-1).
This method uses recursion to accumulate the sum.
*/


public class SumOfFirstN {
    public static int sumOfFirstN(int n){
        if(n==1){
            return  1;
        }
        return  n + sumOfFirstN(n-1);
    }
    public static void main(String[] args) {
        System.out.println(sumOfFirstN(6));
    }
}
