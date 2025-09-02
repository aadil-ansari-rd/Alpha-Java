/*
Problem Name: N-Queens Problem
Problem Statement:
-----------------
Solve the N-Queens problem: Place N queens on an N x N chessboard such that 
no two queens threaten each other. A queen can attack any piece in the same row, 
column, or diagonal. Determine all possible arrangements and count them.

You need to:
1. Use backtracking to place one queen per row.
2. Check if placing a queen is safe in the current column and diagonals.
3. Recursively place queens in the next row.
4. Backtrack if a placement does not lead to a solution.
5. Count and optionally print all valid board configurations.

Example:
Input: n = 4
Output:
. Q . .
. . . Q
Q . . .
. . Q .

. . Q .
Q . . .
. . . Q
. Q . .
Number of ways N queens can be placed = 2
Explanation: There are 2 valid arrangements of 4 queens where no two queens attack each other.
*/


public class NQueen {
    static  int count =0;
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board, 0);
        System.out.println("No. of ways in which N Queens can be placed : "+ count);
    }

    static void solve(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';//Place Queen
                solve(board, row + 1); //Recursive call
                board[row][i] = '.';//Backtracking
            }
        }
    }

    static void printBoard(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(char[][] board, int row, int col) {
        //Check for col
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //Check for upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //Check for upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    
}
