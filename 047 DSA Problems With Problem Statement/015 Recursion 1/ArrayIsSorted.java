/*
Problem Name: Check if Array is Sorted Using Recursion
Problem Statement:
-----------------
Write a Java program to check if a given integer array is sorted in 
non-decreasing order using recursion.

The program should:
1. Take an integer array 'arr' and a starting index 'i'.
2. Recursively check if each element is less than or equal to the next element.
3. Return true if the array is sorted, otherwise return false.

Example:
Input: arr = [1, 2, 13, 5, 6, 9]
Output: false
Explanation: The array is not sorted because 13 > 5.

Input: arr = [1, 2, 3, 4, 5]
Output: true
Explanation: Each element is less than or equal to the next, so the array is sorted.
*/


public class ArrayIsSorted {
    public static boolean isSorted(int[] arr , int i){
        if(i == arr.length-1) return true;
        if(arr[i]>arr[i+1]) return false;
        return isSorted(arr, i+1);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 13 ,5,6,9};
        System.out.println(isSorted(arr, 0));
    }
}
