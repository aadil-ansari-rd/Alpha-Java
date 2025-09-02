/*
Problem Statement: Kth Largest Element in a Stream (LeetCode 703)

✅ Problem Statement:
Design a class to find the Kth largest element in a stream of integers. Implement the `KthLargest` class with a constructor and an `add` method:
- `KthLargest(int k, int[] nums)`: Initializes the object with the integer k and the stream of integers nums.
- `int add(int val)`: Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example:
Input:
k = 3, nums = [4, 5, 8, 2]
add(3) -> returns 4
add(5) -> returns 5
add(10) -> returns 5
add(9) -> returns 8
add(4) -> returns 8
*/

import java.util.PriorityQueue;

public class KthLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Add initial stream elements
        for (int num : nums) {
            add(num);
        }
    }

    // Adds a new number and returns the kth largest
    public int add(int val) {
        minHeap.add(val); // Add new value

        // If size > k, remove the smallest
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Return kth largest, i.e., root of heap
        return minHeap.peek();
    }

    // Test it
    public static void main(String[] args) {
        int k = 3;
        int[] initial = {4, 5, 8, 2};
        KthLargestStream stream = new KthLargestStream(k, initial);

        System.out.println(stream.add(3));  // Output: 4
        System.out.println(stream.add(5));  // Output: 5
        System.out.println(stream.add(10)); // Output: 5
        System.out.println(stream.add(9));  // Output: 8
        System.out.println(stream.add(4));  // Output: 8
    }
}
