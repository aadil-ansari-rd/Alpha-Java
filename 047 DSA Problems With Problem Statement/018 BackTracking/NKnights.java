/*
Problem Name: N Knights Problem
Problem Statement:
-----------------
Place N knights on an N x N chessboard such that no two knights threaten each other. 
A knight moves in an "L" shape: two cells in one direction and one cell perpendicular. 
Determine all possible arrangements of placing N knights safely on the board.

You need to:
1. Use backtracking to try placing a knight in each cell.
2. Check if the cell is safe before placing a knight.
3. Recursively place the remaining knights.
4. Count all valid configurations and optionally print the board for small N.

Example:
Input: n = 3
Output: Number of ways N knights can be placed safely = 0
Explanation: On a 3x3 board, it's not possible to place 3 knights without threatening each other.
For n = 4 or 5, valid configurations exist and can be printed.
*/


public class NKnights {
    static  int count =0;
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board,0,0,n);
        System.out.println("No. of ways in which N Knight can be placed : "+ count);
        
    }

    static void solve(char[][] board,int row  , int col, int remainingKnights) {
        if(remainingKnights==0){ //Base Case
            printBoard(board); //run this line upto n=4, else it will keep print all posible ways
            count++;
            return;
        }
        if(row>=board.length) return; // When all row has finished
        if(col>=board.length) { // when all columns of a row is finished
            solve(board, row+1, 0, remainingKnights);
            return;
        }


        if(isSafe(board, row, col)){
            board[row][col]='K'; //Place Knight
            solve(board, row, col+1, remainingKnights-1); //Solve for more
            board[row][col]='.'; //Backtracking
        }

        //Skip placeing Knight
        solve(board, row, col+1, remainingKnights);

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

    static boolean isInbound(char[][] board , int row , int col){
        return  (row>=0) && (col>=0) && (row<board.length) && (col<board.length);
    }

    static boolean isSafe(char[][] board, int row, int col) {
        //Check for Upper left
        if(isInbound(board, row-2, col-1)){
            if (board[row-2][col-1] == 'K') {
                return false;
            }
        }
        //Check for Upper Right
        if(isInbound(board, row-2, col+1)){
            if (board[row-2][col+1] == 'K') {
                return false;
            }
        }
        //Check for 2ndUpper left
        if(isInbound(board, row-1, col-2)){
            if (board[row-1][col-2] == 'K') {
                return false;
            }
        }
        //Check for 2ndUpper Right
        if(isInbound(board, row-1, col+2)){
            if (board[row-1][col+2] == 'K') {
                return false;
            }
        }
        return true;
    }
}
