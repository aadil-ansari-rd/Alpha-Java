/*
Problem Name: Sudoku Solver
Problem Statement:
-----------------
Implement a Sudoku solver: Given a 9x9 Sudoku puzzle with some cells filled (numbers 1-9) 
and empty cells represented by 0, fill the empty cells so that the puzzle is solved. 
Each row, each column, and each 3x3 subgrid must contain all numbers from 1 to 9 exactly once.

You need to:
1. Use backtracking to try placing numbers 1-9 in empty cells.
2. Check if placing a number is safe according to Sudoku rules (row, column, subgrid).
3. Recursively continue to solve the puzzle.
4. Backtrack if a placement leads to no solution.
5. Print the completed Sudoku if a solution exists or indicate if it does not.

Example:
Input:
{
 {5, 3, 0, 0, 7, 0, 0, 0, 0},
 {6, 0, 0, 1, 9, 5, 0, 0, 0},
 {0, 9, 8, 0, 0, 0, 0, 6, 0},
 {8, 0, 0, 0, 6, 0, 0, 0, 3},
 {4, 0, 0, 8, 0, 3, 0, 0, 1},
 {7, 0, 0, 0, 2, 0, 0, 0, 6},
 {0, 6, 0, 0, 0, 0, 2, 8, 0},
 {0, 0, 0, 4, 1, 9, 0, 0, 5},
 {0, 0, 0, 0, 8, 0, 0, 7, 9}
}
Output: Completed Sudoku grid with all cells filled according to the rules.
Explanation: Each number 1-9 appears exactly once in each row, column, and 3x3 subgrid.
*/


public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {
                            {5, 3, 0, 0, 7, 0, 0, 0, 0},
                            {6, 0, 0, 1, 9, 5, 0, 0, 0},
                            {0, 9, 8, 0, 0, 0, 0, 6, 0},
                            {8, 0, 0, 0, 6, 0, 0, 0, 3},
                            {4, 0, 0, 8, 0, 3, 0, 0, 1},
                            {7, 0, 0, 0, 2, 0, 0, 0, 6},
                            {0, 6, 0, 0, 0, 0, 2, 8, 0},
                            {0, 0, 0, 4, 1, 9, 0, 0, 5},
                            {0, 0, 0, 0, 8, 0, 0, 7, 9}
                        };
        if(sudokuSolver(sudoku)){
            printSudoku(sudoku);
        }else{
            System.out.println("Sokution do not exist.");
        }

    }
    static boolean sudokuSolver(int[][] sudoku){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(sudoku[row][col]==0){
                    for(int val = 1;val<=9;val++){
                        if(isSafe(sudoku, row, col, val)){
                            sudoku[row][col]=val; //Put val in cell
                            if(sudokuSolver(sudoku))return true; //Check for more
                            sudoku[row][col]=0; //Backtracking
                        }
                    }
                    return false;//Cell id empty but cannot be filled
                }
            }
        }
        return true ; // all cells are already filled
    }
    static void printSudoku(int[][] sudoku){
        for(int[] row : sudoku){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] sudoku, int row , int col,int val){
        //For row and column
        for(int i=0;i<9;i++){
            if(sudoku[row][i]==val) return false; // For row
            if(sudoku[i][col]==val) return false; // For Col
        }

        // For sub-matrix
        int stRow = row - (row%3);
        int stCol = col - (col%3);
        for(int i = stRow; i<(stRow + 3); i++){
            for(int j= stCol;j<(stCol + 3);j++){
                if(sudoku[i][j]==val) return false;
            }
        }


        return true;
    }
}
