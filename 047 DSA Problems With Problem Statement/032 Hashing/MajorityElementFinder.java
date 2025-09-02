/*
Problem Statement: Majority Element (LeetCode L169)

Given an array nums of size n, return the majority element. 
The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

import java.util.HashMap;
import java.util.Set;

public class MajorityElementFinder {

    public static int majorityElement(int[] nums) {
        int majorityFreq = nums.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            if (map.get(key) > majorityFreq) {
                return key;
            }
        }

        return -1; // As per LeetCode, this will never be hit
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2}; // ✅ You can change this array for testing

        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}
