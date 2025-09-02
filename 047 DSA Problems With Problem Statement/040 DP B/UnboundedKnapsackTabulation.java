/*
Unbounded Knapsack Problem using Tabulation (Bottom-Up DP)

Problem:
Given weights[], values[], and a knapsack capacity, you can include each item unlimited times. 
Find the maximum value that can be obtained.

Approach:
1️⃣ Create DP table dp[n+1][capacity+1]:
   - dp[i][w] = max value using first i items for weight w
2️⃣ Iterate items i=1..n and weight w=1..capacity:
   - Exclude current item: dp[i][w] = dp[i-1][w]
   - Include current item (unbounded): dp[i][w] = max(dp[i][w], values[i-1] + dp[i][w - weights[i-1]])
     (Notice dp[i][...] not dp[i-1][...] because item can be reused)
3️⃣ Answer = dp[n][capacity]

Time Complexity: O(n*capacity)
Space Complexity: O(n*capacity)

Example:
weights = [2,4,6], values = [5,11,13], capacity = 10
Output: 30 (items 2+2+6 for max value)
*/

public class UnboundedKnapsackTabulation {

    // Function to solve Unbounded Knapsack using tabulation
    public static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // Exclude current item
                dp[i][w] = dp[i - 1][w];

                // Include current item (if it fits)
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w], values[i - 1] + dp[i][w - weights[i - 1]]);
                }
            }
        }

        return dp[n][capacity]; // Final answer
    }

    // Driver code
    public static void main(String[] args) {
        int[] weights = {2, 4, 6};
        int[] values = {5, 11, 13};
        int capacity = 10;

        int maxValue = unboundedKnapsack(weights, values, capacity);
        System.out.println("Maximum value in Unbounded Knapsack = " + maxValue);
    }
}
