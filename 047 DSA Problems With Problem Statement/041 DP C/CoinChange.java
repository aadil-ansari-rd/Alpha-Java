/*
Coin Change Problem (Minimum Coins) using Tabulation (Bottom-Up DP)

Problem:
Given coins[] and an amount, find the minimum number of coins required to make that amount. 
Return -1 if not possible.

Approach:
1️⃣ Initialize dp[0..amount] with a large value (amount+1 as infinity).
2️⃣ Base case: dp[0] = 0 (0 coins needed for amount 0).
3️⃣ For each amount i = 1..amount:
   - For each coin in coins[]:
       if (i - coin >= 0)
           dp[i] = min(dp[i], dp[i - coin] + 1)
4️⃣ Result: dp[amount] (if > amount, return -1 as impossible)

Time Complexity: O(amount * number_of_coins)
Space Complexity: O(amount)

Example:
coins = [1,2,5], amount = 11
Output: 3 (5+5+1)
*/

import java.util.*;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // DP array to store minimum coins for each amount
        int[] dp = new int[amount + 1];
        
        // Fill with a large value (infinity representation)
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;
        
        // Build solution bottom-up
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If value is still large, means not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins, amount));
    }
}
