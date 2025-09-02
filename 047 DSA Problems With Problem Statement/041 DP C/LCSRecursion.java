/*
Longest Common Subsequence (LCS) using Recursion

Problem:
Given two strings s1 and s2, find the length of their longest common subsequence.

Approach:
1️⃣ Base case: if n==0 or m==0 → return 0.
2️⃣ If last characters match (s1[n-1] == s2[m-1]) → include in LCS: 1 + lcs(n-1, m-1)
3️⃣ If not match → max(lcs(n-1, m), lcs(n, m-1))
4️⃣ Pure recursion without memoization → may have overlapping subproblems.

Time Complexity: O(2^(n+m)) (exponential)
Space Complexity: O(n+m) (recursion stack)

Example:
s1 = "abcde", s2 = "ace"
Output: 3 (LCS = "ace")
*/

public class LCSRecursion {
    // Function to find LCS length using recursion
    public static int lcs(String s1, String s2, int n, int m) {
        // Base case: if either string is empty
        if (n == 0 || m == 0) {
            return 0;
        }

        // If last characters match, include them in LCS
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        } 
        else {
            // If not matching, try both options and take max
            return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
        }
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int n = s1.length();
        int m = s2.length();
        System.out.println("Length of LCS: " + lcs(s1, s2, n, m));
    }
}
