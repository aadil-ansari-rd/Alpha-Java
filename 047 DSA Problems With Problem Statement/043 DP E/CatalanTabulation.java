/*
Problem: Catalan Number (Tabulation / Bottom-Up DP)

Given an integer n, compute the nth Catalan number using a bottom-up dynamic programming (tabulation) approach.

Catalan numbers are defined as:
C0 = 1, C1 = 1
Cn = sum(Ci * Cn-i-1) for i = 0 to n-1

Example:
Input: n = 6
Output: 132

Explanation: Using tabulation, the 6th Catalan number is calculated as 132.
*/

public class CatalanTabulation {

    // Function to compute nth Catalan number using Tabulation
    public static int catalan(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Bottom-up filling of dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    // Driver method
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Catalan number for n = " + n + " is " + catalan(n));
    }
}
