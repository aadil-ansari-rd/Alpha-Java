/*
Trapping Rain Water Problem
---------------------------
Write a Java program to calculate the amount of rainwater trapped between bars of different heights.

The program should:
1. Implement a method `trap(int[] height)` that receives an array `height` representing the elevation map, where the width of each bar is 1.
2. Calculate the total trapped water using the concept of:
   - Maximum height to the left of each bar.
   - Maximum height to the right of each bar.
   - Water trapped at each position is `min(maxLeft, maxRight) - height[i]`.
3. Handle edge cases:
   - If the array has length <= 2, return 0.
   - If the array is strictly increasing or decreasing, return 0.
4. Return the total trapped water as an integer.

Example:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: 6 units of rainwater are trapped between the bars.
*/


class TrappingRainWater {
    public int trap(int[] height) {
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        boolean isIncreasing = true, isDecreasing = true;
        for (int i = 1; i < size; i++) {
            if (height[i] < height[i - 1]) {
                isIncreasing = false;
            }
            if (height[i] > height[i - 1]) {
                isDecreasing = false;
            }
        }
        if (isIncreasing || isDecreasing) {
            return 0;
        }
        // maxLeftBoundry = mxlb , maxRightBoundry = mxrb
        int[] mxlb = new int[size];
        int[] mxrb = new int[size];
        mxlb[0] = height[0];
        mxrb[size - 1] = height[size - 1];

        for (int i = 1; i < size; i++) {
            mxlb[i] = Math.max(mxlb[i - 1], height[i]);
        }
        for (int j = size - 2; j >= 0; j--) {
            mxrb[j] = Math.max(mxrb[j + 1], height[j]);
        }
        int trapWater = 0;
        for (int k = 0; k < size; k++) {
            trapWater += Math.min(mxrb[k] , mxlb[k]) -height[k];
        }
        return trapWater;

    }
}