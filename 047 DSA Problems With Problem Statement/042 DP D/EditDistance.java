/*
Edit Distance Problem (Levenshtein Distance)

Problem:
Given two strings word1 and word2, find minimum operations (insert, delete, replace) to convert word1 → word2.

Approach:
1️⃣ Create DP table dp[m+1][n+1], where m=word1.length(), n=word2.length().
2️⃣ Base cases:
   - dp[i][0] = i (delete all characters from word1)
   - dp[0][j] = j (insert all characters to match word2)
3️⃣ Fill table:
   - If characters match: dp[i][j] = dp[i-1][j-1]
   - Else: dp[i][j] = 1 + min(delete: dp[i-1][j], insert: dp[i][j-1], replace: dp[i-1][j-1])
4️⃣ dp[m][n] gives the minimum edit distance.

Time Complexity: O(m*n)
Space Complexity: O(m*n)

Example:
word1 = "horse", word2 = "ros"
Output: Edit Distance = 3
*/

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all characters
        }

        // Fill dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],      // delete
                                  Math.min(dp[i][j - 1],       // insert
                                           dp[i - 1][j - 1])); // replace
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Edit Distance: " + minDistance(word1, word2));
        // Output: 3
    }
}
