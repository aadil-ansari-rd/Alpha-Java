/*
Check for Duplicate Elements in an Array
----------------------------------------
Write a Java program to determine if any element appears at least twice in an integer array.

The program should:
1. Implement a method `elementTwice(int[] nums)` that checks for duplicate elements:
   - Iterate through the array and compare each element with all subsequent elements.
   - Return `true` if any element appears more than once.
   - Return `false` if all elements are distinct.
2. In the main method, define an integer array.
3. Call the method and print the result.

Example:
Input: [1, 2, 3, 1]
Output: true

Input: [1, 2, 3, 4]
Output: false
*/



public class ElementTwice {

    public static boolean elementTwice(int[] nums){
        for(int i=0; i<nums.length;i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return  false;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(elementTwice(nums));
    }
}
