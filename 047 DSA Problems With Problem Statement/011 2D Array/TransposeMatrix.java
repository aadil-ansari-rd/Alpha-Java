/*
Transpose of a Matrix
--------------------
Write a Java program to find the transpose of a given matrix. The transpose of a matrix is formed by turning all rows of a given matrix into columns and vice versa.

Approach:
---------
1. Create a new matrix with dimensions swapped (columns become rows and rows become columns).
2. Iterate over each element of the original matrix.
3. Set mat[j][i] = arr[i][j] to transpose.
4. Return the transposed matrix.

Time Complexity: O(n*m) where n = rows, m = columns
Space Complexity: O(n*m) for the new matrix

Example:
Input:  
arr = {{11,12,13},
       {21,22,23},
       {31,32,33},
       {41,42,43}}

Output:
Transpose:
11 21 31 41
12 22 32 42
13 23 33 43
*/


public class TransposeMatrix{
    
    public static int[][] transpose(int[][] arr){
        int[][] mat = new int[arr[0].length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                mat[j][i]=arr[i][j];
            }
        }
        return mat;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{11,12,13},{21,22,23},{31,32,33},{41,42,43}};
        
        System.out.println("Before Transpose");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("After Transpose");
        int[][] transpose = transpose(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}