/*
Find Largest Number in an Array
-------------------------------
Write a Java program to find the largest number in a given integer array.

The program should:
1. Implement a method `largestInArray(int[] nums)` that iterates through the array and returns the largest element.
2. In the main method, define an integer array.
3. Call the method and display the largest number in the array.

Example:
Array: {5, 12, 7, 9, 20}
Output: Largest number in the given array is : 20
*/


public class LargestInArray {
    public static int largestInArray(int[] nums){
        int largest = Integer.MIN_VALUE;
        for(int i =0; i<nums.length;i++){
            if(nums[i]>largest){
                largest = nums[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int[] numbers= {53, 85, 36, 75, 90, 25, 62, 60, 34, 55, 98, 19, 22, 91, 86, 6, 3, 38, 67, 73, 81, 48, 30, 35, 80, 11, 47, 12, 1, 45, 88, 63, 7, 84, 78, 18, 41, 43, 8, 10, 5, 16, 44, 56, 92, 97, 26, 28, 13, 39};
        System.out.println("Largest number in the given array is : "+ largestInArray(numbers));
    }
}
