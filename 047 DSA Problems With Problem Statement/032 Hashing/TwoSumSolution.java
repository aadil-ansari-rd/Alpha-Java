/*
Problem Statement: Two Sum (LeetCode 1)

Given an array of integers `arr` and an integer `target`, find indices of the two numbers such that they add up to `target`. Assume exactly one solution exists, and the same element cannot be used twice. Return the indices in any order.

Example Input 1:
arr = [2, 7, 11, 15], target = 9
Example Output 1:
[0, 1]  // Because arr[0] + arr[1] = 2 + 7 = 9

Example Input 2:
arr = [3, 2, 4], target = 6
Example Output 2:
[1, 2]  // Because arr[1] + arr[2] = 2 + 4 = 6
*/

import java.util.*;

public class TwoSumSolution {
    public static int[] twoSum(int[] arr, int target) {
        // Map to store value → index
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement is already in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // Found the pair
            }

            // Otherwise, store current value with index
            map.put(arr[i], i);
        }

        // If no pair is found (though problem guarantees one)
        return new int[] {};
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
