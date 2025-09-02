/*
Problem Name: Minimum Cost to Connect Ropes

Problem Statement:
-----------------
Given N ropes of different lengths, connect all ropes into one rope with minimum cost. The cost to connect two ropes is equal to the sum of their lengths.

Approach:
---------
1. Use a Min Heap (PriorityQueue) to efficiently access the two smallest ropes.
2. Pop the two smallest ropes from the heap and sum their lengths to compute the connection cost.
3. Add this cost to the total accumulated cost.
4. Push the combined rope back into the heap.
5. Repeat steps 2-4 until only one rope remains.

Key Points:
-----------
- Greedy approach ensures minimum total cost.
- Time Complexity: O(n log n) due to heap operations.
- Space Complexity: O(n) for the heap.

Example:
--------
Input: [4, 3, 2, 6]
Step 1: Pick 2 and 3 -> Cost = 5, Heap: [4, 5, 6]
Step 2: Pick 4 and 5 -> Cost = 9, Heap: [6, 9]
Step 3: Pick 6 and 9 -> Cost = 15, Heap: [15]
Total Cost = 5 + 9 + 15 = 29
*/


import java.util.PriorityQueue;

public class MinimumCostToConnectRopes {

    // Function to return minimum cost of connecting ropes
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all rope lengths into the min-heap
        for (int rope : arr) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Continue until we have one rope left
        while (minHeap.size() > 1) {
            // Take two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            // Push the combined rope back
            minHeap.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));  // Output: 29
    }
}
