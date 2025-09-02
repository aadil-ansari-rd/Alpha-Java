/*
Problem: Count Unique Binary Search Trees (Tabulation)

Given an integer n, find the number of structurally unique BSTs (Binary Search Trees) that store values 1 to n using bottom-up dynamic programming (tabulation).

Formula:
Number of BSTs with n nodes = sum(dp[i-1] * dp[n-i]) for i = 1 to n
where dp[0] = dp[1] = 1

Example:
Input: n = 4
Output: 14

Explanation: There are 14 unique BSTs that can be formed with 4 nodes labeled 1 to 4.
*/

public class CountBSTsTabulation {

    // Function to count number of unique BSTs using Tabulation
    public static int countBST(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;  // empty tree
        dp[1] = 1;  // single node tree

        // Bottom-up computation
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    // Driver method
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of unique BSTs with " + n + " nodes is " + countBST(n));
    }
}
