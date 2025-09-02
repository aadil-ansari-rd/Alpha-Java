/*
Problem Name: Unique Paths (Combinatorial)
Problem Statement:
-----------------
Given a grid of size m x n, calculate the total number of unique paths from 
the top-left corner (0,0) to the bottom-right corner (m-1, n-1) using 
combinatorial mathematics. You can only move right or down at any point.

Approach:
- Use the formula for combinations (nCr):
  Number of paths = ((m-1) + (n-1))! / ((m-1)! * (n-1)!)
- This counts the number of ways to arrange (m-1) downs and (n-1) rights.

Example:
Input: m = 3, n = 3
Output: 6

Explanation:
- There are 6 unique paths in the 3x3 grid from the top-left to the bottom-right corner.
- The paths are all permutations of two downs and two rights.
*/

public class GridWaysMath {
    public static void main(String[] args){
        int n=3, m=3;
        // long ways = 0;
        System.out.println("Total no. of ways : " + gridWays(m, n));
    }
    //nCr = ((n-1)+(m-1))!  / (n-1)! * (m-1)!
    static long gridWays( int m , int n ){
        return  factorial((n-1)+(m-1))/(factorial(n-1)*factorial(m-1));
    }
    static long factorial(int n ){
        if(n==1) return  1;
        return n * factorial(n-1);
    }
}
