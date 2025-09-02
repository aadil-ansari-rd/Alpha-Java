/*
Problem Name: Trapping Rain Water (LeetCode 42) using Stack
-----------------------------------------------------------

Problem Statement:
-----------------
Given an array representing heights of bars in a histogram, calculate how much rainwater can be trapped after raining. Implement the solution using a stack.

Approach (Monotonic Stack):
---------------------------
1. Use a stack to keep track of indices of bars in non-increasing order.
2. Iterate through each bar:
   - While current bar height is greater than the bar at the top of the stack:
     • Pop the top (this is the bottom of a potential water container).
     • If the stack is empty, break (no left boundary).
     • Compute width = distance between current bar and new stack top - 1.
     • Compute bounded height = min(left bar, current bar) - bottom bar height.
     • Accumulate trapped water = width * bounded height.
   - Push current index onto the stack.
3. Continue until all bars are processed.

Key Points:
-----------
- Stack stores indices to compute distances between bars.
- Efficiently handles multiple valleys in a single pass.
- Time Complexity: O(n)
- Space Complexity: O(n)

Example:
--------
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: 6 units of water are trapped between the bars.
*/


// Trapping Rain Water (LeetCode 42) – Using Stack


import java.util.Stack;
import java.util.*;

public class TrappingRainWater {

    // Method to compute trapped water
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // While current bar is higher than stack top, process trapped water
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // the valley bottom

                if (stack.isEmpty()) break; // no left boundary

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[bottom];

                totalWater += distance * boundedHeight; // trapped water = width * height
            }

            stack.push(i); // push current bar index
        }

        return totalWater;
    }

    // Main method with hardcoded array
    public static void main(String[] args) {
        // Hardcoded elevation map
        int[] height = {4, 2, 0, 3, 2, 5};

        System.out.println("Elevation map: " + Arrays.toString(height));
        int result = trap(height);
        System.out.println("Total trapped water: " + result);
    }
}
