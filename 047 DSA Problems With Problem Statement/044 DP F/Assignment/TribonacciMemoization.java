/*
Problem: Tribonacci Number with Memoization

Definition:
- T(0) = 0, T(1) = 1, T(2) = 1
- T(n) = T(n-1) + T(n-2) + T(n-3) for n >= 3

Approach:
1. Use a dp[] array to store results of subproblems to avoid recomputation.
2. Initialize dp[i] = -1 to mark uncalculated states.
3. Base cases:
   - dp[0] = 0, dp[1] = 1, dp[2] = 1
4. Recursive relation with memoization:
   dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
5. Time Complexity: O(n)
6. Space Complexity: O(n) for recursion stack + dp array
*/

public class TribonacciMemoization {

    public int tribonacci(int n) {
        int[] dp = new int[n + 1]; // store subproblem results
        for (int i = 0; i <= n; i++) {
            dp[i] = -1; // initialize with -1 (not calculated)
        }
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // If already calculated, return
        if (dp[n] != -1) {
            return dp[n];
        }

        // Recursively calculate and store
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp) + solve(n - 3, dp);
        return dp[n];
    }

    // Example run
    public static void main(String[] args) {
        TribonacciMemoization obj = new TribonacciMemoization();
        System.out.println("Tribonacci(4): " + obj.tribonacci(4));  // Output: 4
        System.out.println("Tribonacci(25): " + obj.tribonacci(25)); // Output: 1389537
    }
}
