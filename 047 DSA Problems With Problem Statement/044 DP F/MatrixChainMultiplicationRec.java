/*
Problem: Matrix Chain Multiplication (Recursive Approach)

Given an array arr[] of length n representing the dimensions of matrices such that the ith matrix has dimensions arr[i-1] x arr[i], find the minimum number of scalar multiplications needed to multiply the chain of matrices using recursion.

Example 1:
Input: arr = [40, 20, 30, 10, 30]
Output: 26000
Explanation: The optimal order is ((A1 x A2) x (A3 x A4)) with 26000 multiplications.

Example 2:
Input: arr = [10, 30, 5, 60]
Output: 4500
*/

public class MatrixChainMultiplicationRec {

    // Recursive function to find minimum cost
    public static int solve(int[] arr, int i, int j) {
        // Base case: single matrix
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        // Try every possible split
        for (int k = i; k < j; k++) {
            // Cost of left + right + multiplying two parts
            int cost = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);

            // Take the minimum
            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        // Example test case
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

        int result = solve(arr, 1, n - 1); // call recursion from 1 to n-1
        System.out.println("Minimum number of multiplications: " + result);
    }
}
