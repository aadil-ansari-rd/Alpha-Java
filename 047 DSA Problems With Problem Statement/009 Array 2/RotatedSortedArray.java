/*
Search in Rotated Sorted Array
------------------------------
Write a Java program to search for a target value in a rotated sorted array using an efficient algorithm.

The program should:
1. Implement a method `search(int[] nums, int target)` that returns the index of `target` in the rotated sorted array `nums`.
   - A rotated sorted array is an array that was originally sorted in ascending order, but then rotated at some pivot unknown to you.
   - If the target is not found, return -1.
2. Use a modified binary search approach:
   - Determine which part (left or right) of the current subarray is sorted.
   - Narrow down the search range based on whether the target lies in the sorted portion.
3. Ensure the algorithm runs in O(log n) time complexity.

Example:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/


class RotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int st=0, end = nums.length-1;
        while(st<=end){
            int mid= st + (end-st)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[st]<=nums[mid]){
                //left part of nums is sorted
                if(nums[st]<=target && target<=nums[mid]){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }else{
                //right part of nums is sorted
                if(nums[mid]<=target && target<=nums[end]){
                    st = mid +1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;

    }
}