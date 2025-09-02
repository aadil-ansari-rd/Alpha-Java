/*
Problem Statement: Count Distinct Elements in an Array

Given an integer array, find the number of distinct elements present in the array.

Example 1:
Input: [1, 2, 2, 3, 4, 1]
Output: 4
Explanation: The distinct elements are 1, 2, 3, 4.

Example 2:
Input: [5, 5, 5, 5]
Output: 1
Explanation: Only one distinct element exists: 5.
*/

import java.util.HashSet;

public class DistinctElementCounter {
    public static int countDistinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the HashSet (duplicates will be ignored)
        for (int num : arr) {
            set.add(num);
        }

        // Return the size of the HashSet (i.e., count of unique elements)
        return set.size();
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 1};
        int distinctCount = countDistinct(arr);
        System.out.println("Total distinct elements: " + distinctCount); // Output: 4
    }
}
