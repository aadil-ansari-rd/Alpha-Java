/*
Problem: Maximum Height of Stacked Cuboids (Tabulation DP)

Given n cuboids with dimensions [l,w,h], stack them to maximize height. A cuboid can be rotated internally (dimensions sorted), and a cuboid can be placed on another if all three dimensions are ≤ the one below.

Approach:
1. Normalize each cuboid by sorting dimensions.
2. Sort cuboids lexicographically by dimensions.
3. Use DP array: dp[i] = max height ending with cuboid i.
4. For each i, check j < i: if cuboid j fits below i, update dp[i] = max(dp[i], dp[j]+height[i]).
5. Answer = max(dp[i]).

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class CuboidStackingTabulation {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        // Step 1: Normalize each cuboid (sort dimensions inside)
        for (int[] c : cuboids) {
            Arrays.sort(c);
        }

        // Step 2: Sort all cuboids
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        // Step 3: DP for maximum height (like LIS in 3D)
        int[] dp = new int[n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2]; // height of current cuboid
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] &&
                    cuboids[j][1] <= cuboids[i][1] &&
                    cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }

    // Main method to test
    public static void main(String[] args) {
        CuboidStackingTabulation solver = new CuboidStackingTabulation();

        int[][] cuboids1 = {{50,45,20},{95,37,53},{45,23,12}};
        System.out.println("Max Height (Example 1): " + solver.maxHeight(cuboids1)); // 190

        int[][] cuboids2 = {{38,25,45},{76,35,3}};
        System.out.println("Max Height (Example 2): " + solver.maxHeight(cuboids2)); // 76

        int[][] cuboids3 = {{7,11,17},{7,17,11},{11,7,17},{17,7,11}};
        System.out.println("Max Height (Example 3): " + solver.maxHeight(cuboids3)); // 34
    }
}
