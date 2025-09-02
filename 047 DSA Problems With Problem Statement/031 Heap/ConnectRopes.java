/*
Problem Statement: Minimum Cost to Connect Ropes

✅ Problem Statement:
Given n ropes of different lengths, you need to connect them into one rope. 
The cost of connecting two ropes is equal to the sum of their lengths. 
Find the minimum total cost to connect all ropes.

Example 1:
Input: ropes = [4,3,2,6]
Output: 29
Explanation: 
1. Connect 2 + 3 = 5, cost = 5
2. Connect 4 + 5 = 9, cost = 9
3. Connect 6 + 9 = 15, cost = 15
Total cost = 5 + 9 + 15 = 29

Example 2:
Input: ropes = [1,2,3,4,5]
Output: 33
Explanation:
1+2=3 (cost 3), 3+3=6 (cost 6), 4+5=9 (cost 9), 6+9=15 (cost 15), total = 3+6+9+15=33
*/

import java.util.*;

public class ConnectRopes {

    public static int minCost(int[] ropes) {
        // Step 1: Add all ropes to Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Step 2: Keep combining two smallest ropes
        while (minHeap.size() > 1) {
            int first = minHeap.poll();  // Smallest
            int second = minHeap.poll(); // Second smallest
            int cost = first + second;   // Combine

            totalCost += cost;           // Accumulate cost
            minHeap.add(cost);           // Add back to heap
        }

        return totalCost;
    }

    // Main method with multiple test cases
    public static void main(String[] args) {
        int[][] testCases = {
            {4, 3, 2, 6},      // Expected: 29
            {1, 2, 3, 4, 5},   // Expected: 33
            {5, 17, 100, 11},  // Expected: 182
            {8},               // Expected: 0 (only one rope)
            {}                 // Expected: 0 (empty input)
        };

        for (int i = 0; i < testCases.length; i++) {
            int cost = minCost(testCases[i]);
            System.out.println("Test " + (i + 1) + " - Ropes: " + Arrays.toString(testCases[i]));
            System.out.println("Minimum cost: " + cost + "\n");
        }
    }
}
