/*
Print All Subarrays of an Array
-------------------------------
Write a Java program to print all possible subarrays of a given integer array.

The program should:
1. Implement a method `subArray(int[] nums)` that generates all subarrays:
   - A subarray is a contiguous portion of the array.
   - Iterate through all possible start and end indices to print each subarray.
2. In the main method, define an integer array.
3. Call the `subArray` method to display all subarrays.

Example:
Array: {1, 3, 5}
Output:
1
1 3
3
5
3 5
1 3 5
*/


public class SubArray {
    public static void subArray(int[] nums){
        for(int i=0; i<nums.length;i++){
            for(int j=0;j<nums.length; j++){
                for(int k=i;k<=j;k++){
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
                System.out.println();

        }
    }
    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6, 7};
        subArray(nums);

    }
}
