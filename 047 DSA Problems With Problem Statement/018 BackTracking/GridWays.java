/*
Problem Name: Unique Paths (Grid)
Problem Statement:
-----------------
Given a grid of size m x n, count the total number of unique paths from the 
top-left corner (0,0) to the bottom-right corner (m-1, n-1). You can only move 
either right or down at any point in time.

You need to:
1. Start from the top-left cell.
2. Recursively explore moving right and moving down.
3. Count all valid paths that reach the bottom-right corner.

Example:
Input: m = 3, n = 3
Output: 6

Explanation:
- There are 6 unique paths from the top-left to the bottom-right corner:
  1. Right → Right → Down
  2. Right → Down → Right
  3. Down → Right → Right
  4. Down → Down → Right → Right (depending on step order)
  5. Right → Down → Down → Right
  6. Down → Right → Down → Right
- The recursive function explores moving right and down at each step, counting all paths that reach the destination.
*/


public class GridWays {
    public static void main(String[] args){
        int n=3, m=3;
        System.out.println("Total no. of ways : " + gridWays(0, 0, m, n));
    }

    static int gridWays(int row, int col, int m , int n ){
        if(row==m-1 && col==n-1) return 1;
        if(row>= m || col>= n ) return 0;

        int right = gridWays(row, col+1, m,n);
        int down = gridWays(row+1, col, m,n);
        return right + down;
    }
}
