/*
Spiral Order Traversal of a 2D Matrix
-------------------------------------
Print the elements of a 2D matrix in spiral order.

Approach:
---------
1. Define four pointers: startRow, endRow, startCol, endCol.
2. Traverse the top row from startCol to endCol.
3. Traverse the rightmost column from startRow+1 to endRow.
4. Traverse the bottom row from endCol-1 to startCol (if startRow != endRow).
5. Traverse the leftmost column from endRow-1 to startRow+1 (if startCol != endCol).
6. Increment startRow and startCol, decrement endRow and endCol to move inward.
7. Repeat until all elements are printed.

Time Complexity: O(n*m)
Space Complexity: O(1)

Example:
Input:  matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}
Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
*/


public class SpiralMatrix{
    public static void spiralMatrix(int[][] matrix){
        int startRow =0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startCol<=endCol && startRow<=endRow){
            //Top row
            for(int i=startCol;i<=endCol;i++){
                System.out.print(matrix[startRow][i] + " ");
            }

            //Right Column
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol] + " ");

            }

            //End Row 
            for(int i=endCol-1;i>=startCol;i--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");

            }

            //Left Column
            for(int i=endRow-1;i>startCol;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");

            }

            //Updation
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }


    
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralMatrix(matrix);
    }
}