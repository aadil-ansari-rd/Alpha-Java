/*
Problem Name: Knight's Tour
Problem Statement:
-----------------
Implement the Knight's Tour problem on an N x N chessboard. A knight starts 
from a given cell (usually 0,0) and must visit every cell on the board exactly once 
using valid knight moves. The goal is to find one possible sequence of moves that 
completes the tour.

You need to:
1. Use backtracking to explore all valid knight moves.
2. Mark each visited cell with the step number.
3. Backtrack if a move does not lead to a solution.
4. Print the solution board showing the sequence of steps, or indicate if no solution exists.

Example:
Input: N = 8 (standard chessboard)
Output: A 8x8 board with numbers 0 to 63 indicating the knight's movement sequence.

Explanation:
Each number represents the step in which the knight visits that cell. 
All cells are visited exactly once.
*/


public class KnightsTour {

    static int N = 8; // Chessboard size

    // Possible moves of a knight
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    // Function to print solution board
    static void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    // Backtracking function to solve Knight's Tour
    static boolean solveKnightTour(int[][] board, int x, int y, int step) {
        // Base case: all cells visited
        if (step == N * N) return true;

        // Explore all 8 knight moves
        for (int move = 0; move < 8; move++) {
            int nextX = x + dx[move];
            int nextY = y + dy[move];

            // Check validity of move
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && board[nextX][nextY] == -1) {
                board[nextX][nextY] = step;
                if (solveKnightTour(board, nextX, nextY, step + 1)) return true;
                board[nextX][nextY] = -1; // Backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        // Initialize board with -1 (unvisited)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = -1;

        // Starting position
        board[0][0] = 0;

        if (solveKnightTour(board, 0, 0, 1))
            printSolution(board);
        else
            System.out.println("Solution doesn't exist!");
    }
}
