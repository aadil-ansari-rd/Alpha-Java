/*
Rod Cutting Problem (Bottom-Up DP)

Problem:
Given a rod of length n and an array price[], where price[i] is the price of a rod of length i+1, 
find the maximum profit obtainable by cutting the rod into pieces.

Approach:
1️⃣ Create dp[] array of size n+1, where dp[i] stores max profit for rod of length i.
2️⃣ Fill dp[] iteratively:
   - For each length i (1 to n):
       - Try all possible first cut lengths j (1 to i)
       - dp[i] = max(dp[i], price[j-1] + dp[i-j])
3️⃣ dp[n] contains the maximum profit.

Time Complexity: O(n^2)
Space Complexity: O(n)

Example:
price = {1,5,8,9,10,17,17,20}, n = 8
Output: Maximum Profit = 22
*/

import java.util.*;

public class RodCutting {
    public static int rodCutting(int[] price, int n) {
        // dp[i] will store max profit for rod of length i
        int[] dp = new int[n + 1];

        // Bottom-up calculation
        for (int i = 1; i <= n; i++) {
            int maxProfit = Integer.MIN_VALUE;
            // Try every cut length j (1 to i)
            for (int j = 1; j <= i; j++) {
                maxProfit = Math.max(maxProfit, price[j - 1] + dp[i - j]);
            }
            dp[i] = maxProfit;
        }
        return dp[n];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println("Maximum Profit: " + rodCutting(price, n));
    }
}
