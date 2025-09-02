/*
Problem Name: Trapping Rain Water (LeetCode 42) – Two Pointer Optimized Approach
-------------------------------------------------------------------------------

Problem Statement:
-----------------
Given an array representing heights of bars in a histogram, calculate the total amount of rainwater that can be trapped. Use the two-pointer approach for an optimized solution.

Approach:
---------
1. Initialize two pointers: left at start, right at end of the array.
2. Track maximum heights from left and right using leftMax and rightMax.
3. While left <= right:
   - If leftMax < rightMax:
     • Water trapped at left = max(0, leftMax - height[left]).
     • Update leftMax = max(leftMax, height[left]).
     • Move left pointer inward.
   - Else:
     • Water trapped at right = max(0, rightMax - height[right]).
     • Update rightMax = max(rightMax, height[right]).
     • Move right pointer inward.
4. Sum all trapped water amounts.

Key Points:
-----------
- Time Complexity: O(n)
- Space Complexity: O(1)
- No extra stack or array required.
- Efficiently handles all valleys and peaks.

Example:
--------
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: Total trapped rainwater is 6 units.
*/


// Trapping Rain Water (LeetCode 42) – Two Pointer Optimized Approach
public class TrappingRainWater2 {

    public static int trap(int[] height) {
        int n = height.length;

        // Edge case: if less than 3 bars, no water can be trapped
        if (n < 3) return 0;

        // Initialize left and right boundaries
        int left = height[0];
        int right = height[n - 1];

        // Pointers for traversing from both ends
        int low = 1;
        int high = n - 2;

        // Variable to store total trapped water
        int ans = 0;

        // Loop until pointers meet
        while (low <= high) {
            if (left < right) {
                // Update left boundary if needed
                left = Math.max(left, height[low]);
                // Calculate trapped water at this position
                ans += (left - height[low]);
                low++;
            } else {
                // Update right boundary if needed
                right = Math.max(right, height[high]);
                // Calculate trapped water at this position
                ans += (right - height[high]);
                high--;
            }
        }

        // Return the total trapped water
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(height);
        System.out.println("Total trapped rain water: " + result);
    }
}
