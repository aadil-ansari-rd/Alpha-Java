/*
Problem: Generate Balanced Parentheses using Tabulation (DP)

Given n pairs of parentheses, generate all combinations of balanced parentheses using a bottom-up dynamic programming approach.

Example:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 2
Output: ["(())","()()"]

Explanation:
- dp[i] stores all valid combinations of i pairs of parentheses.
- For dp[i], combine all pairs of dp[j] and dp[i-1-j] for 0 <= j < i:
  result = "(" + dp[j] + ")" + dp[i-1-j]
- Build dp from 0 to n iteratively.
*/

import java.util.*;

public class BalancedParenthesesTabulation {
    public List<String> generateParentheses(int n) {
        List<List<String>> dp = new ArrayList<>();
        
        // Base case
        dp.add(new ArrayList<>());
        dp.get(0).add("");  // empty string for 0 pairs

        // Build up solutions for 1..n
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - 1 - j)) {
                        current.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(current);
        }

        return dp.get(n);
    }

    // Main method to test
    public static void main(String[] args) {
        BalancedParenthesesTabulation solver = new BalancedParenthesesTabulation();

        System.out.println("n = 3 → " + solver.generateParentheses(3));
        System.out.println("n = 2 → " + solver.generateParentheses(2));
        System.out.println("n = 4 → " + solver.generateParentheses(4));
    }
}
