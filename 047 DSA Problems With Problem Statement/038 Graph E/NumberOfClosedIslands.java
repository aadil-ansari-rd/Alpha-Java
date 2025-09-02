/*
Number of Closed Islands in a Grid (Java):

1. Definition: A closed island is a group of 1s (land) completely surrounded by 0s (water) and not touching the boundary.

2. Approach:
   - Use DFS to traverse each land cell.
   - If DFS touches the boundary, mark the island as not closed.
   - Mark visited land cells as 0 to avoid revisiting.

3. Example Grid:
0 0 0 0 0 0 0 0
0 1 1 1 1 1 0 0
0 1 0 1 0 1 0 0
0 1 1 1 1 1 0 0
0 0 0 0 0 0 0 0

Output:
Number of closed islands: 1
*/

public class NumberOfClosedIslands {

    // Direction vectors for 4 directions (up, down, left, right)
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    // DFS function to mark connected land and check if it touches boundary
    private static boolean dfs(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        // If out of bounds, touches boundary → not closed
        if (x < 0 || y < 0 || x >= n || y >= m) return false;

        // If water or already visited, return true (doesn't affect closure)
        if (grid[x][y] == 0) return true;

        // Mark current land as visited
        grid[x][y] = 0;

        boolean isClosed = true;

        // Explore 4 directions
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (!dfs(grid, newX, newY)) {
                isClosed = false; // touches boundary
            }
        }

        return isClosed;
    }

    // Main function to count closed islands
    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        // Iterate through entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(grid, i, j)) {
                        count++; // increment if it's a closed island
                    }
                }
            }
        }

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,0,0},
            {0,1,0,1,0,1,0,0},
            {0,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,0}
        };

        int result = closedIsland(grid);
        System.out.println("Number of closed islands: " + result); // Output: 1
    }
}
