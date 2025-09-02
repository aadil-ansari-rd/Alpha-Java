/*
Problem: Minimum Jumps to Reach End of Array (Tabulation)

Given an array arr[] of non-negative integers where each element represents the maximum number of steps that can be jumped forward from that element, find the minimum number of jumps required to reach the last index of the array. If it is not possible to reach the end, return -1.

Example 1:
Input: arr = [2, 3, 1, 1, 4]
Output: 2
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: arr = [1, 1, 1, 1, 1]
Output: 4
Explanation: Jump 1 step at a time from the start to the end.
*/

import java.util.Arrays;

public class MinimumArrayJumpsTab {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // starting point, no jumps needed

        // Build dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 1, 4};
        int[] arr2 = {1, 1, 1, 1, 1};

        System.out.println("Minimum jumps for arr1: " + minJumps(arr1)); // Output: 2
        System.out.println("Minimum jumps for arr2: " + minJumps(arr2)); // Output: 4
    }
}
