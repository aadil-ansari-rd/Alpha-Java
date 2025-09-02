/*
Longest Common Subsequence (LCS) using Memoization (Top-Down DP)

Problem:
Given two strings s1 and s2, find the length of their longest common subsequence.

Approach:
1️⃣ Let dp[i][j] store LCS length of first i characters of s1 and first j characters of s2.
2️⃣ Base case: if i==0 or j==0 → LCS length = 0.
3️⃣ If characters match: dp[i][j] = 1 + dp[i-1][j-1]
4️⃣ If not match: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
5️⃣ Use memoization to store results to avoid recomputation.

Time Complexity: O(n*m)
Space Complexity: O(n*m)

Example:
s1 = "abcde", s2 = "ace"
Output: 3 (LCS = "ace")
*/

import java.util.Arrays;

public class LCSMemoization {

    // Function to find LCS length using memoization
    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        // Base case: if one string is empty
        if (i == 0 || j == 0) {
            return 0;
        }

        // If already calculated, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            // If not match, take max of skipping one from either string
            dp[i][j] = Math.max(
                lcs(s1, s2, i - 1, j, dp),
                lcs(s1, s2, i, j - 1, dp)
            );
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        int n = s1.length();
        int m = s2.length();

        // Initialize dp with -1
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = lcs(s1, s2, n, m, dp);
        System.out.println("Length of LCS: " + result);
    }
}
