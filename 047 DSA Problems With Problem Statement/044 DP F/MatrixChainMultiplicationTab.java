/*
Problem: Matrix Chain Multiplication (Tabulation / Bottom-Up DP)

Given an array arr[] of length n representing the dimensions of matrices such that the ith matrix has dimensions arr[i-1] x arr[i], find the minimum number of scalar multiplications needed to multiply the chain of matrices using a bottom-up dynamic programming approach.

Example 1:
Input: arr = [40, 20, 30, 10, 30]
Output: 26000
Explanation: The optimal multiplication order yields 26000 multiplications.

Example 2:
Input: arr = [10, 30, 5, 60]
Output: 4500
*/

public class MatrixChainMultiplicationTab {

    // Bottom-up tabulation approach
    public static int matrixChainOrder(int[] arr, int n) {
        int[][] dp = new int[n][n];

        // dp[i][i] = 0 (single matrix cost is zero)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is the chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all partitions
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

        int result = matrixChainOrder(arr, n);
        System.out.println("Minimum number of multiplications: " + result);
    }
}

