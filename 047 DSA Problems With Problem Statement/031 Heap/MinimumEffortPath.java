/*
Problem Statement: Minimum Effort Path (LeetCode L1631)

✅ Problem Statement:
You are given a 2D grid 'heights' where heights[i][j] represents the height of cell (i, j). Find a path from the top-left cell (0,0) to the bottom-right cell (m-1,n-1) such that the maximum absolute difference in heights between consecutive cells in the path is minimized. Return the minimum effort required.

You can move up, down, left, or right from a cell.

Example:
Input:
heights = [
  [1, 2, 2],
  [3, 8, 2],
  [5, 3, 5]
]

Output:
2

Explanation:
One of the paths with minimum effort is: [1,2,2,2,5] and the maximum absolute difference between consecutive cells is 2.
*/

import java.util.PriorityQueue;
import java.util.*;

public class MinimumEffortPath {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [effort, x, y]
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int e = curr[0], x = curr[1], y = curr[2];

            if (x == m - 1 && y == n - 1) return e;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newEffort = Math.max(e, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newEffort < effort[nx][ny]) {
                        effort[nx][ny] = newEffort;
                        pq.add(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }

        return 0; // unreachable
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };
        System.out.println(minimumEffortPath(heights)); // Output: 2
    }
}
