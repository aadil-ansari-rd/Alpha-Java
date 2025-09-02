/*
Climb Stairs Problem (LeetCode 70)

Problem:
Given n steps, count the number of distinct ways to climb to the top if you can take 1 or 2 steps at a time.

Approaches:

1️⃣ Recursive Approach (Exponential Time)
- Base case: 0 or 1 step → 1 way
- Recurrence: ways(n) = ways(n-1) + ways(n-2)
- Simple but inefficient for large n due to repeated calculations.

2️⃣ Memoization (Top-Down DP, O(n) Time)
- Use an array to store already computed values
- Avoid recomputation
- Base case same as recursion
- Recurrence same but store result: memo[n] = climbStairsMemo(n-1) + climbStairsMemo(n-2)

3️⃣ Tabulation (Bottom-Up DP, O(n) Time)
- Create dp array of size n+1
- dp[0] = dp[1] = 1
- Iteratively fill dp[i] = dp[i-1] + dp[i-2]
- Return dp[n]

Example:
Input: n = 6
Output: 13
Explanation: 13 distinct ways to climb 6 steps.

Key Points:
- Fibonacci-like recurrence
- Memoization reduces recursion to linear time
- Tabulation provides iterative solution, also linear time
*/

import java.util.Arrays;

public class ClimbStairs {

    // 🔹 Recursive approach (pure recursion, no optimization)
    public static int climbStairsRec(int n) {
        // Base case: If there are 0 or 1 steps, only 1 way to climb
        if (n == 0 || n == 1)
            return 1;

        // Recursive case: ways(n) = ways(n-1) + ways(n-2)
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    // 🔹 Memoization approach (Top-Down DP)
    public static int climbStairsMemo(int n, int[] memo) {
        // Base case
        if (n == 0 || n == 1)
            return 1;

        // If already computed, return the stored value
        if (memo[n] != -1) {
            return memo[n];
        }

        // Compute and store the result to avoid recomputation
        // ⚠ Original code called climbStairsRec here — replaced with climbStairsMemo for true memoization
        return memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
    }

    // 🔹 Tabulation approach (Bottom-Up DP)
    public static int climbStairsTab(int n) {
        // Base case
        if (n == 0 || n == 1)
            return 1;

        // Create a DP array to store number of ways for each step
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at step 0
        dp[1] = 1; // 1 way to climb 1 step

        // Fill the table iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n]; // Final answer
    }

    public static void main(String[] args) {
        int n = 6; // Example number of steps

        // Test recursion method
        System.out.println("No of ways with Recursion : " + climbStairsRec(n));

        // Test memoization method
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo array with -1
        System.out.println("No of ways with Memoization : " + climbStairsMemo(n, memo));

        // Test tabulation method
        System.out.println("No of ways with Tabulation : " + climbStairsTab(n));
    }
}

// import java.util.Arrays;

// public class ClimbStairs {
//     public static int climbStairsRec(int n) {
//         if (n == 0 || n == 1)
//             return 1;
//         return climbStairsRec(n - 1) + climbStairsRec(n - 2);
//     }

//     public static int climbStairsMemo(int n, int[] memo) {
//         if (n == 0 || n == 1)
//             return 1;
//         if (memo[n] != -1) {
//             return memo[n];
//         }
//         return memo[n] = climbStairsRec(n - 1) + climbStairsRec(n - 2);
//     }

//     public static int climbStairsTab(int n) {
//         if (n == 0 || n == 1)
//             return 1;

//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];

//     }

//     public static void main(String[] args) {
//         int n = 6;
//         System.out.println("No of ways with Recursion : " + climbStairsRec(n));

//         int[] memo = new int[n + 1];
//         Arrays.fill(memo, -1);
//         System.out.println("No of ways with Memoization : " + climbStairsMemo(n, memo));

//         System.out.println("No of ways with Tabulation : " + climbStairsTab(n));
//     }
// }
