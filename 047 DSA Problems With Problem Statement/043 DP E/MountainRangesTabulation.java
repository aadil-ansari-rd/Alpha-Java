/*
Problem: Count Valid Mountain Ranges (Tabulation)

Given n pairs of upstrokes and downstrokes (n 'U's and n 'D's), count the number of valid mountain ranges that can be drawn. A valid mountain range never dips below the starting level and returns to the original level after 2n steps. Use bottom-up dynamic programming (Catalan number approach).

Example:
Input: n = 4
Output: 14

Explanation: There are 14 valid sequences of 4 upstrokes and 4 downstrokes that form proper mountain ranges.
*/

public class MountainRangesTabulation {

    // Function to count valid mountain ranges using Tabulation (Catalan Numbers)
    public static int countMountainRanges(int n) {
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
        int n = 4;
        System.out.println("Number of valid mountain ranges for n = " + n + " is " + countMountainRanges(n));
    }
}
