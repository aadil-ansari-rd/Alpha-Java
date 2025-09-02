/*
Problem Name: Fast Exponentiation (Binary Exponentiation)
Problem Statement:
-----------------
Write a Java program to efficiently calculate the power of a number using 
fast exponentiation (also known as binary exponentiation).

The program should:
1. Take two integers 'x' (base) and 'n' (exponent) as input.
2. Compute x raised to the power n (x^n) efficiently using bitwise operations.
3. Return the result.

Example:
Input: x = 5, n = 4
Output: 625
Explanation: 5^4 = 5 * 5 * 5 * 5 = 625

Approach:
---------
- Use binary representation of the exponent.
- Multiply the result whenever the current bit is 1.
- Square the base and right-shift the exponent at each step.
This reduces time complexity to O(log n).
*/


public class FastExponentiation {
    public static int myPow(int x, int n){
        int ans =1;
        while(n>0){
            if((n&1)!=0){
                ans = ans*x;
            }
            x= x*x;
            n= n>>1;
        }
        return  ans;
    }
    public static void main(String[] args) {
        System.out.println(myPow(5, 4));
    }
}
