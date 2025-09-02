/*
Print All Pairs in an Array
---------------------------
Write a Java program to print all possible pairs of elements in a given integer array.

The program should:
1. Implement a method `pairInArray(int[] nums)` that iterates through the array `nums` and prints all pairs (nums[i], nums[j]) where i < j.
2. In the main method, define an integer array.
3. Call the method to display all possible pairs.

Example:
Array: {1, 3, 5}
Output:
(1, 3) (1, 5) 
(3, 5)
*/


public class PairInArray {
    public static void pairInArray(int[] nums) {
        int end = nums.length ;
        for(int i=0 ; i<(end-1);i++){
            for (int j = i + 1; j < end; j++) {
                System.out.print(" ( " + nums[i] + " , " + nums[j] + " ) ");
            }
            System.out.println();
        }    
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7};
        pairInArray(nums);
    }
}
