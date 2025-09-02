/*
Coin Change Problem (Total Number of Ways) using Tabulation (Bottom-Up DP)

Problem:
Given coins[] and an amount, find the total number of distinct ways to make that amount 
using unlimited supply of coins.

Approach:
1️⃣ Initialize dp[n+1][amount+1] where dp[i][j] = number of ways to make amount j using first i coins.
2️⃣ Base case: dp[i][0] = 1 (1 way to make amount 0 by choosing nothing).
3️⃣ Fill table iteratively:
   for i = 1..n:
       for j = 1..amount:
           dp[i][j] = dp[i-1][j]   // Exclude current coin
           if (j - coins[i-1] >= 0)
               dp[i][j] += dp[i][j - coins[i-1]]  // Include current coin
4️⃣ Result: dp[n][amount]

Time Complexity: O(n * amount)
Space Complexity: O(n * amount)

Example:
coins = [1,2,5], amount = 5
Output: 4 
Ways: [1+1+1+1+1, 1+1+1+2, 1+2+2, 5]
*/

import java.util.*;

public class CoinChangeWays {
    public static int countWays(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: one way to make amount 0 (by choosing nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Build table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // Exclude the current coin
                dp[i][j] = dp[i - 1][j];
                
                // Include the current coin if possible
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Total Ways: " + countWays(coins, amount));
    }
}
