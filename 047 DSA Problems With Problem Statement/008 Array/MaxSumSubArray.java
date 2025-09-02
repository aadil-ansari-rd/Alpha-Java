/*
Maximum Subarray Sum with All Subarrays
---------------------------------------
Write a Java program to find all subarrays of a given integer array and determine the maximum sum among them.

The program should:
1. Implement a method `subArray(int[] nums)` that:
   - Iterates through all possible subarrays of the array `nums`.
   - Prints each subarray along with its sum.
   - Keeps track of the maximum sum encountered.
2. In the main method, define an integer array.
3. Call the `subArray` method to display all subarrays, their sums, and the maximum sum.

Example:
Array: {1, 3, 5}
Output:
1 , sum = 1
1 3 , sum = 4
1 3 5 , sum = 9
3 , sum = 3
3 5 , sum = 8
5 , sum = 5
Maximum Sum = 9
*/


public class MaxSumSubArray {
    public static void subArray(int[] nums){
    int sum , maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length;i++){
            for(int j=i;j<nums.length; j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(nums[k] + " ");
                    sum+=nums[k];
                }
                if(sum>maxSum){
                    maxSum=sum;
                }
                
                System.out.print( ", sum = " + sum);
                System.out.println();
            }
                System.out.println();

        }
                System.out.println("maximun Sum = "+ maxSum);

    }
    public static void main(String args[]){
        int[] nums = {1, 3, 5, 6, 7};
        subArray(nums);
    }
}
