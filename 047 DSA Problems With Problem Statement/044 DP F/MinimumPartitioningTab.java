/*
Problem: Minimum Subset Sum Difference (Tabulation)

Given an array arr[] of positive integers, partition it into two subsets S1 and S2 such that the absolute difference between the sums of the subsets is minimized. Return the minimum possible difference.

Example 1:
Input: arr = [1, 6, 11, 5]
Output: 1
Explanation: Partition the array into [1, 5, 6] and [11], sums are 12 and 11, difference = 1.

Example 2:
Input: arr = [3, 1, 4, 2, 2]
Output: 0
Explanation: Partition into [3, 2, 1] and [4, 2], sums both 6, difference = 0.
*/

public class MinimumPartitioningTab {

    // Function to find minimum partition difference
    public static int minPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int num : arr) sum += num;

        // DP table: dp[i][j] = true if sum j is possible with first i items
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the closest sum to half of total
        int s1 = 0;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                s1 = j;
                break;
            }
        }

        int s2 = sum - s1;
        return Math.abs(s2 - s1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int result = minPartition(arr);
        System.out.println("Minimum partition difference: " + result);
    }
}
