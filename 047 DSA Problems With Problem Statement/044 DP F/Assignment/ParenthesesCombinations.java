/*
Problem: Count Valid Parentheses Combinations (Catalan Number)

Given n pairs of parentheses, count the number of valid combinations.

Approach (DP Tabulation):
1. Use dp[i] to store the number of valid combinations with i pairs.
2. Base case: dp[0] = 1 (empty string), dp[1] = 1 ("()").
3. Recurrence (Catalan formula): 
   dp[i] = Σ (dp[j] * dp[i-1-j]) for j = 0 to i-1.
4. dp[n] gives the total number of valid combinations.

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

public class ParenthesesCombinations {

    // Function to calculate number of valid parentheses combinations using tabulation
    public static int countParenthesesCombinations(int n) {
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 1;  
        if (n > 0) dp[1] = 1;

        // Fill dp array using Catalan recurrence
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

    // Main function to test
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of valid parentheses combinations for n=" + n + " is: " 
                           + countParenthesesCombinations(n));

        n = 4;
        System.out.println("Number of valid parentheses combinations for n=" + n + " is: " 
                           + countParenthesesCombinations(n));
    }
}
