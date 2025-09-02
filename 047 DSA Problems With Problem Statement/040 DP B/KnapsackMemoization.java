/*
0/1 Knapsack Problem (Memoization / Top-Down DP)

Problem:
Given weights[] and values[] of n items and a knapsack of capacity W, 
find the maximum total value that can be put in the knapsack. 
Each item can be picked at most once.

Approach (Memoization):
1️⃣ Recursive Choice:
   - For each item at index:
     a) Exclude it → move to next item
     b) Include it (if weight <= remaining capacity) → add its value and reduce capacity
2️⃣ Memoization:
   - Use dp[index][capacity] to store the maximum value for subproblems
   - Avoid recomputation
3️⃣ Base Cases:
   - index == n → no more items to consider
   - capacity == 0 → no capacity left

Time Complexity: O(n * W)  
Space Complexity: O(n * W) (for dp array + recursion stack)

Example:
weights = [1,3,4,5], values = [1,4,5,7], capacity = 7
Output: 9 (items 3 and 4, weights 3+4, values 4+5)
*/

public class KnapsackMemoization {

    // Recursive helper with memoization
    public static int knapSackHelper(int[] weights, int[] values, int capacity, int index, int[][] dp) {
        // Base case: no items left or capacity is 0
        if (index == weights.length || capacity == 0) {
            return 0;
        }

        // Return cached value if already computed
        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        // Option 1: Exclude the current item
        int exclude = knapSackHelper(weights, values, capacity, index + 1, dp);

        // Option 2: Include the current item (if it fits)
        int include = 0;
        if (weights[index] <= capacity) {
            include = values[index] + knapSackHelper(weights, values, capacity - weights[index], index + 1, dp);
        }

        // Store the result in memo table
        dp[index][capacity] = Math.max(include, exclude);
        return dp[index][capacity];
    }

    // Main function
    public static int knapSack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // Initialize dp table with -1 (uncomputed state)
        int[][] dp = new int[n][capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = -1;
            }
        }
        return knapSackHelper(weights, values, capacity, 0, dp);
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
