/*
Problem: Sliding Window Maximum (LeetCode 239)

Description:
You are given an array nums and an integer k. There is a sliding window of size k that moves from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the maximum value in each sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Explanation:
Window positions:
[1,3,-1],-3,5,3,6,7 → max = 3
1,[3,-1,-3],5,3,6,7 → max = 3
1,3,[-1,-3,5],3,6,7 → max = 5
1,3,-1,[-3,5,3],6,7 → max = 5
1,3,-1,-3,[5,3,6],7 → max = 6
1,3,-1,-3,5,[3,6,7] → max = 7
*/


import java.util.*;

public class SlidingWindowMaximum {
    // Method to find maximum in every window of size k
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Result array to store maximums
        Deque<Integer> deque = new LinkedList<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Remove indices of elements which are out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices from back if their corresponding values are smaller than current value
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element index to the deque
            deque.offerLast(i);

            // Store max value of current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    // Testing
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}
