/*
Problem: Equal Subset Sum Partition (Tabulation DP)

Given an array, determine if it can be partitioned into two subsets with equal sum.

Approach:
1. Calculate total sum. If odd → impossible.
2. Target sum = totalSum / 2.
3. Initialize DP table dp[i][j] = true if sum j possible with first i elements.
4. Fill table: 
   - dp[i][j] = dp[i-1][j] (not take element)
   - dp[i][j] |= dp[i-1][j-nums[i-1]] (take element if feasible)
5. Answer = dp[n][target].

Time Complexity: O(n*target)
Space Complexity: O(n*target)
*/

public class EqualSubsetSumPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Step 1: Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: If total sum is odd, cannot partition
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        // Step 3: Initialize DP table
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Step 4: Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                // Not take current element
                dp[i][sum] = dp[i - 1][sum];

                // Take current element if possible
                if (nums[i - 1] <= sum) {
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - nums[i - 1]];
                }
            }
        }

        // Step 5: Final answer
        return dp[n][target];
    }

    // Driver code to test
    public static void main(String[] args) {
        EqualSubsetSumPartition obj = new EqualSubsetSumPartition();

        int[] nums1 = {1, 5, 11, 5};
        System.out.println(obj.canPartition(nums1)); // true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(obj.canPartition(nums2)); // false
    }
}
