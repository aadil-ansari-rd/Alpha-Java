/*
Burst Balloons Problem - Tabulation DP

Problem:
- Array of balloons with coins values
- Bursting balloon i gives coins = nums[left]*nums[i]*nums[right], 
  where left/right are adjacent remaining balloons
- Goal: maximize total coins

Approach:
1. Pad nums with 1 at both ends to simplify boundary cases.
2. dp[start][end] = max coins obtainable in range [start..end].
3. For all lengths 1..n, for all start indices:
   - For each i in range, consider bursting i last:
     dp[start][end] = max(dp[start][i-1] + nums[start-1]*nums[i]*nums[end+1] + dp[i+1][end])
4. Return dp[1][n].

Time Complexity: O(n^3)
Space Complexity: O(n^2)
*/

public class BurstBalloonsSolver {

    // Function to compute maximum coins by bursting balloons using tabulation
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Step 1: Create padded array with extra 1s at both ends
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        // Step 2: Create DP table (dp[start][end] stores max coins in range [start..end])
        int[][] dp = new int[n + 2][n + 2];

        // Step 3: Process ranges of increasing length
        for (int len = 1; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;

                int maxCoins = 0;

                // Step 4: Try every balloon i as the last balloon to burst
                for (int i = start; i <= end; i++) {
                    int coins = newNums[start - 1] * newNums[i] * newNums[end + 1]
                              + dp[start][i - 1] // coins from left subarray
                              + dp[i + 1][end];  // coins from right subarray

                    maxCoins = Math.max(maxCoins, coins);
                }

                // Step 5: Store best result for range [start..end]
                dp[start][end] = maxCoins;
            }
        }

        // Step 6: Answer is for full range [1..n]
        return dp[1][n];
    }

    // Main function to test the solution
    public static void main(String[] args) {
        BurstBalloonsSolver solver = new BurstBalloonsSolver();

        int[] nums1 = {3, 1, 5, 8};
        System.out.println("Maximum coins (Example 1): " + solver.maxCoins(nums1));

        int[] nums2 = {1, 5};
        System.out.println("Maximum coins (Example 2): " + solver.maxCoins(nums2));

        int[] nums3 = {9, 76, 64, 21};
        System.out.println("Maximum coins (Custom Example): " + solver.maxCoins(nums3));
    }
}
