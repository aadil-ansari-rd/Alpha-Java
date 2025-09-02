/*
Longest Common Subsequence (LCS) Reconstruction

Problem:
Given two strings, find the actual longest common subsequence (not just length).

Approach:
1️⃣ Create DP table dp[m+1][n+1] storing LCS lengths for prefixes.
2️⃣ Fill DP table using standard LCS rules:
   - If s1[i-1] == s2[j-1], dp[i][j] = 1 + dp[i-1][j-1]
   - Else, dp[i][j] = max(dp[i-1][j], dp[i][j-1])
3️⃣ Backtrack from dp[m][n]:
   - If characters match, add to LCS
   - Else move in the direction of larger value (up or left)
4️⃣ Reverse collected characters to get LCS in correct order.

Time Complexity: O(m*n)
Space Complexity: O(m*n)

Example:
s1 = "abcde", s2 = "ace"
Output: "ace"
*/

public class LongestCommonSubsequence {

    public static String findLCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtrack to reconstruct LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1)); // match found
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // move up
            } else {
                j--; // move left
            }
        }

        return lcs.reverse().toString(); // reverse to get correct order
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        System.out.println("LCS: " + findLCS(s1, s2)); // Output: "ace"
    }
}
