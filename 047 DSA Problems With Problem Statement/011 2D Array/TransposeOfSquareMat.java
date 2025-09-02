/*
In-Place Transpose of a Square Matrix
------------------------------------
Write a Java program to find the transpose of a square matrix in-place, i.e., without using any extra matrix.

Approach:
---------
1. Iterate only over the upper triangle of the square matrix (excluding the diagonal).
2. Swap arr[i][j] with arr[j][i] for all j > i.
3. This ensures every off-diagonal element is swapped with its symmetric element.
4. No extra space is required.

Time Complexity: O(n^2) where n = size of square matrix
Space Complexity: O(1) (in-place)

Example:
Input:
11 12 13
21 22 23
31 32 33

Output:
11 21 31
12 22 32
13 23 33
*/


public class TransposeOfSquareMat{
    
    public static void transpose(int[][] arr){
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         if(i<=j){
        //             int temp = arr[i][j];
        //             arr[i][j]=arr[j][i];
        //             arr[j][i]=temp;
        //         }
        //     }
        // }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[0].length;j++){
                    int temp = arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
            }
        }
        
    }
        
        
    
    public static void main(String[] args) {
        int[][] arr = {{11,12,13},{21,22,23},{31,32,33}};
        
        System.out.println("Before Transpose");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("After Transpose");
        transpose(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}