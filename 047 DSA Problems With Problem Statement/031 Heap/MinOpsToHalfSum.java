/*
Problem Statement: Minimum Operations to Halve Array Sum (LeetCode L2208)

✅ Problem Statement:
You are given an array of positive integers 'nums'. In one operation, you can choose any element and reduce it to half of its current value. Your task is to find the minimum number of operations required to reduce the sum of the array to at least half of its original sum.

Example:
Input: nums = [5, 19, 8, 1]
Output: 3

Explanation:
Initial sum = 33, target sum = 16.5
- Reduce 19 → 9.5 (sum reduced by 9.5)
- Reduce 9.5 → 4.75 (sum reduced by 4.75)
- Reduce 8 → 4 (sum reduced by 4)
Total operations = 3
*/

import java.util.*;

public class MinOpsToHalfSum {

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double total = 0;

        for (int num : nums) {
            maxHeap.add((double) num);
            total += num;
        }

        double target = total / 2;
        int operations = 0;
        double reduced = 0;

        while (reduced < target) {
            double largest = maxHeap.poll();
            double half = largest / 2;
            reduced += half;
            maxHeap.add(half);
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] arr = {5, 19, 8, 1};
        System.out.println(halveArray(arr));  // Output: 3
    }
}
