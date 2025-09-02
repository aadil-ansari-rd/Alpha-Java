/*
Chocolate Cutting Problem (Greedy)

Problem Statement:
You are given a chocolate bar of size m x n. The chocolate needs to be 
broken down into 1 x 1 pieces. The cost of cutting is different in 
horizontal and vertical directions. Each cut has a given cost, and 
you must pay the cost multiplied by the current number of pieces in 
the other direction.

Your task is to find the minimum total cost to cut the chocolate 
into 1 x 1 pieces.

Example 1:
Input:
horizontal = [2, 1]
vertical = [3, 1]
Output: 12
Explanation:
- First, cut vertically at cost 3 (1 horizontal piece × cost 3 = 3).
- Then, cut horizontally at cost 2 (2 vertical pieces × cost 2 = 4).
- Next, cut vertically at cost 1 (2 horizontal pieces × cost 1 = 2).
- Finally, cut horizontally at cost 1 (3 vertical pieces × cost 1 = 3).
Total cost = 3 + 4 + 2 + 3 = 12.

Example 2:
Input:
horizontal = [4]
vertical = [2, 1]
Output: 10
*/

import java.util.*;

public class ChocolaProblem {
    public static int minCost(int[] horizontal, int[] vertical) {
        Arrays.sort(horizontal);
        Arrays.sort(vertical);

        int h = horizontal.length - 1;
        int v = vertical.length - 1;

        int horizontalPieces = 1, verticalPieces = 1;
        int cost = 0;

        // Step 1: Pick the highest cost cut first
        while (h >= 0 && v >= 0) {
            if (horizontal[h] > vertical[v]) {
                cost += horizontal[h] * verticalPieces;
                horizontalPieces++;
                h--;
            } else {
                cost += vertical[v] * horizontalPieces;
                verticalPieces++;
                v--;
            }
        }

        // Step 2: Add remaining cuts
        while (h >= 0) {
            cost += horizontal[h] * verticalPieces;
            h--;
            horizontalPieces++;
        }

        while (v >= 0) {
            cost += vertical[v] * horizontalPieces;
            v--;
            verticalPieces++;
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] horizontal = {2, 1};
        int[] vertical = {3, 1};
        System.out.println("Minimum Cost: " + minCost(horizontal, vertical));
    }
}
