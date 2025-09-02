/*
Minimum Absolute Difference in an Array

Problem Statement:
Given an array of integers, find and return the minimum absolute difference 
between any two elements in the array.

Example 1:
Input: arr = [5, 2, 9, 1, 8]
Output: 1
Explanation: The minimum absolute difference is between 1 and 2.

Example 2:
Input: arr = [1, 3, 6, 10, 15]
Output: 2
Explanation: The minimum absolute difference is between 1 and 3.

Example 3:
Input: arr = [4, 4, 4, 4]
Output: 0
Explanation: All elements are the same, so the minimum difference is 0.
*/

import java.util.Arrays;

public class MinAbsDiffPair {
    // Method to find minimum absolute difference
    public static int minAbsDiff(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE; // initialize to maximum

        // Step 2: Traverse and check consecutive differences
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1]; // absolute difference between adjacent elements
            minDiff = Math.min(minDiff, diff); // update minimum
        }

        return minDiff;
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 8};
        System.out.println("Minimum Absolute Difference: " + minAbsDiff(arr));
    }
}
