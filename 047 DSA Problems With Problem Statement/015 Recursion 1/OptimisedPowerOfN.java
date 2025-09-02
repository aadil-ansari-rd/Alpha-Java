/*
Problem Name: Power of a Number Using Recursion (Naive & Optimized)
Problem Statement:
-----------------
Write a Java program to calculate the power of a number using recursion with 
both naive and optimized approaches.

The program should:
1. Take two integers 'x' (base) and 'n' (exponent).
2. Implement a naive recursive method:
   - Compute x^n by recursively multiplying x for n times (O(n) time complexity).
3. Implement an optimized recursive method using fast exponentiation:
   - Compute x^n by recursively calculating x^(n/2) and squaring it.
   - Multiply by x if n is odd (O(log n) time complexity).
4. Return the result from both methods.

Example:
Input: x = 2, n = 10
Output: 1024, 1024
Explanation: 2^10 = 1024, calculated by both naive and optimized methods.

Key Concept:
- Optimized approach reduces recursive calls by dividing the problem in half, 
  achieving logarithmic time complexity.
*/


public class OptimisedPowerOfN {
    public static int optimisedPowerOfN(int x ,int n){ //TC = O(n)
        if(n==0) return 1;
        int halfPowerSq = optimisedPowerOfN(x, n/2)*optimisedPowerOfN(x , n/2);
        if(n%2!=0){
            halfPowerSq = x* halfPowerSq; 
        }
        return  halfPowerSq;
    }
    public static int optimisedPowerOfN2(int x , int n){ //TC = O(logN)
        if(n==0) return 1;
        int halfPower = optimisedPowerOfN2(x, n/2);
        int halfPowerSq = halfPower * halfPower;
        if(n%2!=0){
            halfPowerSq = x* halfPowerSq; 
        }
        return  halfPowerSq;
    }
    public static void main(String[] args) {
        System.out.println(optimisedPowerOfN(2, 10));
        System.out.println(optimisedPowerOfN2(2, 10));
    }
}
