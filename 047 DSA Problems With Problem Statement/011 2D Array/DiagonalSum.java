/*
Sum of Primary and Secondary Diagonals of a Matrix
--------------------------------------------------
Write a Java program to calculate the sum of both primary and secondary diagonals of a square matrix. 
If the matrix has an odd dimension, the middle element should only be counted once.

Approach:
---------
1. Let the matrix size be n x n.
2. Iterate from i = 0 to n-1:
   a) Add the primary diagonal element: matrix[i][i]
   b) Add the secondary diagonal element: matrix[i][n-1-i] 
      - Only if it's not the same as the primary diagonal (i != n-1-i)
3. Return the sum.

Time Complexity: O(n)
Space Complexity: O(1)

Example:
Input:  [[1, 2, 3, 4],
         [5, 6, 7, 8],
         [9, 10, 11, 12],
         [13, 14, 15, 16]]
Output: 68
*/

public class DiagonalSum {

    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;


        //O(n^2)
        // for(int i=0;i< n;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }else if(i+j==matrix.length-1){
        //             sum+=matrix[i][j];

        //         }
        //     }
        // }


        //O(n)
        for (int i = 0; i < n; i++) {
            //Primary Diagonal
            sum += matrix[i][i];
            //Secondary Diagonal : i+j =n-1 => j=n-1-i
            if (i != n - 1 - i) {
                sum += matrix[i][n - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(diagonalSum(matrix));
    }

}
