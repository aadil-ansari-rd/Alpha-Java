/*
Problem: Longest Palindromic Subsequence (LPS)

Given a string s, find the length of the longest subsequence which is a palindrome.

Approach (DP Tabulation):
1. Let dp[i][j] = length of LPS in substring s[i..j].
2. Base case: single characters are palindromes of length 1 → dp[i][i] = 1.
3. Fill dp for increasing substring lengths:
   - If s[i] == s[j]: dp[i][j] = 2 + dp[i+1][j-1] (extend palindrome)
   - Else: dp[i][j] = max(dp[i+1][j], dp[i][j-1]) (skip one end)
4. Result: dp[0][n-1] gives LPS of entire string.

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill dp for substrings of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2; // Two same characters
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // Answer is for the entire string
        return dp[0][n - 1];
    }

    // Main method to test
    public static void main(String[] args) {
        LongestPalindromeSubseq sol = new LongestPalindromeSubseq();
        System.out.println(sol.longestPalindromeSubseq("bbbab")); // 4
        System.out.println(sol.longestPalindromeSubseq("cbbd"));  // 2
    }
}
