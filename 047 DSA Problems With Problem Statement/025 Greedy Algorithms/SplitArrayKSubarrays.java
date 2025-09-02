/*
Split Array Largest Sum (LeetCode 410)

Problem Statement:
Given an array of non-negative integers and an integer k, split the array 
into k or fewer non-empty contiguous subarrays such that the largest sum 
among these subarrays is minimized. Return the minimized largest sum.

Example 1:
Input: arr = [1, 1, 2], k = 2
Output: 2
Explanation: Split into [1,1] and [2], the largest sum is 2.

Example 2:
Input: arr = [1, 2, 3, 4], k = 3
Output: 4
Explanation: Split into [1,2], [3], [4], the largest sum is 4.

Example 3:
Input: arr = [7, 2, 5, 10, 8], k = 2
Output: 18
Explanation: Split into [7,2,5] and [10,8], the largest sum is 18.
*/

public class SplitArrayKSubarrays {

    // Function to check if we can split into K or fewer parts with max sum <= mid
    public static boolean isValid(int[] arr, int k, int mid) {
        int count = 1, currentSum = 0;
        for (int num : arr) {
            if (currentSum + num > mid) {
                count++; // Start new subarray
                currentSum = num;
            } else {
                currentSum += num;
            }
        }
        return count <= k;
    }

    // Main function to find minimal maximum subarray sum
    public static int splitArray(int[] arr, int k) {
        int maxElement = 0, totalSum = 0;
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
            totalSum += num;
        }

        int low = maxElement, high = totalSum, answer = totalSum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        System.out.println(splitArray(arr1, 2)); // Output: 2

        int[] arr2 = {1, 2, 3, 4};
        System.out.println(splitArray(arr2, 3)); // Output: 4
    }
}
