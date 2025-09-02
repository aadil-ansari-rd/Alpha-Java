/*
Longest Common Substring Problem

Problem:
Given two strings s1 and s2, find the longest substring (contiguous) present in both.

Approach:
1️⃣ Create DP table dp[m+1][n+1], where m=s1.length(), n=s2.length().
2️⃣ Initialize maxLen = 0 and endIndex = -1.
3️⃣ Fill table:
   - If characters match: dp[i][j] = 1 + dp[i-1][j-1]
   - Else: dp[i][j] = 0 (reset because substring must be contiguous)
4️⃣ Track maximum length and its ending index.
5️⃣ Extract substring: s1.substring(endIndex - maxLen + 1, endIndex + 1)

Time Complexity: O(m*n)
Space Complexity: O(m*n)

Example:
s1 = "abcde", s2 = "abfce"
Output: Longest Common Substring = "ab", Length = 2
*/

public class LongestCommonSubstring {

    public static String longestCommonSubstring(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0; 
        int endIndex = -1; // To reconstruct substring

        // Step 1: Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // Track max length and ending index
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0; // reset since not contiguous
                }
            }
        }

        // Step 2: Extract substring using endIndex
        if (maxLen == 0) return ""; 
        return s1.substring(endIndex - maxLen + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        String result = longestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring: " + result); // Output: "ab"
        System.out.println("Length: " + result.length()); // Output: 2
    }
}
