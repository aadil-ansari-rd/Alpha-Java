/*
Rod Cutting Problem (2D DP approach)

Problem:
Given a rod of length n and price array, maximize profit by cutting the rod into pieces. 
Here, we use a 2D DP table where dp[i][j] represents max profit using first i lengths for rod length j.

Approach:
1️⃣ Create lengths[] array = {1,2,...,n}.
2️⃣ Initialize dp[n+1][n+1] to 0.
3️⃣ Fill dp table:
   - For each length i (1 to n):
       - For each rod length j (1 to n):
           - If length[i-1] <= j:
               dp[i][j] = max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j])
           - Else: dp[i][j] = dp[i-1][j]
4️⃣ dp[n][n] has the maximum profit.

Time Complexity: O(n^2)
Space Complexity: O(n^2)

Example:
price = {1,5,8,9,10,17,17,20}, n=8
Output: Maximum Profit = 22
*/

import java.util.*;

public class RodCutting2D {
    public static int rodCutting(int[] price, int n) {
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1; // rod piece lengths = 1 to n
        }

        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] → max profit using first i pieces for rod length j

        // Bottom-up filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (length[i - 1] <= j) {
                    // Either include or exclude the piece
                    dp[i][j] = Math.max(
                        price[i - 1] + dp[i][j - length[i - 1]], // include (stay in same row)
                        dp[i - 1][j] // exclude
                    );
                } else {
                    dp[i][j] = dp[i - 1][j]; // cannot include
                }
            }
        }
        return dp[n][n];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println("Maximum Profit: " + rodCutting(price, n));
    }
}
