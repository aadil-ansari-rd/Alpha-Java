/*
0/1 Knapsack Problem (Tabulation / Bottom-Up DP)

Problem:
Given weights[] and values[] of n items and a knapsack of capacity W, 
find the maximum total value that can be put in the knapsack. 
Each item can be picked at most once.

Approach (Tabulation):
1️⃣ Create dp[n+1][capacity+1], where dp[i][w] = max value using first i items with capacity w
2️⃣ Base Case:
   - dp[0][*] = 0 (0 items) 
   - dp[*][0] = 0 (capacity 0)
3️⃣ For each item i (1..n) and capacity w (1..W):
   a) Exclude item i → dp[i-1][w]
   b) Include item i (if weight[i-1] ≤ w) → value[i-1] + dp[i-1][w-weights[i-1]]
4️⃣ dp[i][w] = max(include, exclude)
5️⃣ Answer = dp[n][capacity]

Time Complexity: O(n*W)  
Space Complexity: O(n*W)

Example:
weights = [1,3,4,5], values = [1,4,5,7], capacity = 7
Output: 9 (items with weights 3 and 4 → values 4 + 5)
*/

public class KnapsackTabulation {

    // Bottom-up tabulation method
    public static int knapSack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1]; // dp[i][w] = max value using first i items

        // Build dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // Exclude current item
                int exclude = dp[i - 1][w];

                // Include current item (if it fits)
                int include = 0;
                if (weights[i - 1] <= w) {
                    include = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                }

                // Store best of include or exclude
                dp[i][w] = Math.max(include, exclude);
            }
        }

        return dp[n][capacity]; // Final answer
    }

    // Driver code
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;

        int maxValue = knapSack(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
