/*
Valid Palindrome II - Tabulation DP Approach

Problem:
- Given a string s, check if it can become a palindrome by deleting at most one character.

Approach:
1. Build dp[i][j] = true if substring s[i..j] is palindrome.
2. Base case: dp[i][i] = true.
3. Fill dp for lengths 2..n:
   - if s[i] == s[j], dp[i][j] = dp[i+1][j-1] (or true if length 2)
   - else dp[i][j] = false
4. Two-pointer check from left=0, right=n-1:
   - If mismatch, try skipping left or right: dp[left+1][right] || dp[left][right-1]
5. Return true if string is palindrome or can become one after at most one deletion.

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

public class ValidPalindromeChecker {

    // Function to check if a string can become a palindrome by deleting at most one character
    public boolean validPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j] = true if s[i..j] is palindrome

        // Step 1: Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Step 2: Build DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) dp[i][j] = true; // 2-character palindrome
                    else dp[i][j] = dp[i + 1][j - 1]; // longer palindrome
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // Step 3: Check if string can be palindrome after at most one deletion
        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Try deleting either left or right character
                return dp[left + 1][right] || dp[left][right - 1];
            }
        }
        return true; // Already a palindrome
    }

    // Main function to test the solution
    public static void main(String[] args) {
        ValidPalindromeChecker checker = new ValidPalindromeChecker();

        String s1 = "aba";
        System.out.println("Can \"" + s1 + "\" be palindrome? " + checker.validPalindrome(s1));

        String s2 = "abca";
        System.out.println("Can \"" + s2 + "\" be palindrome? " + checker.validPalindrome(s2));

        String s3 = "abc";
        System.out.println("Can \"" + s3 + "\" be palindrome? " + checker.validPalindrome(s3));
    }
}
