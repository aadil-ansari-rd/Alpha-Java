/*
Problem Name: Power of a Number Using Simple Recursion
Problem Statement:
-----------------
Write a Java program to calculate the power of a number using simple recursion.

The program should:
1. Take two integers 'x' (base) and 'n' (exponent) as input.
2. Compute x raised to the power n (x^n) recursively.
3. Return the result.

Example:
Input: x = 5, n = 4
Output: 625
Explanation: 5^4 = 5 * 5 * 5 * 5 = 625

Approach:
- Base case: if n == 0, return 1.
- Recursive case: multiply x by powerOfN(x, n-1).
This method has O(n) time complexity.
*/



public class PowerOfN {

    public static int powerOfN(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * powerOfN(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(powerOfN(5, 4));
    }
}
