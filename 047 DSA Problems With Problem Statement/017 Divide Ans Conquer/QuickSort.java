/*
Problem Name: Quick Sort using Recursion
Problem Statement:
-----------------
Implement the Quick Sort algorithm to sort an array of integers in ascending order.
Given an integer array, your task is to rearrange the elements so that each element 
is in its correct position according to the sorted order using the Quick Sort technique.

You need to:
1. Choose a pivot element.
2. Partition the array such that elements less than the pivot come before it and 
   elements greater than the pivot come after it.
3. Recursively apply the same process to the left and right subarrays until the 
   entire array is sorted.

Example:
Input: arr = [2, 34, 657, 2, 564, 57, 234, 756, 67]
Output: arr = [2, 2, 34, 57, 67, 234, 564, 657, 756]

Explanation:
- Quick Sort selects a pivot and partitions the array around it.
- The left subarray contains elements less than the pivot; the right subarray contains elements greater.
- The process is applied recursively until the array is fully sorted in ascending order.
*/


public class QuickSort {

    public static void quickSort(int[] arr, int st, int end) {
        if (st < end) {
            int pivotIdx = partitionFunction(arr, st, end);
            quickSort(arr, st, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, end);
        }
    }

    public static int partitionFunction(int[] arr, int st, int end) {
        int pivot = arr[end];
        int i = st - 1;
        for (int j = st; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1]= arr[end];
        arr[end] = temp;
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 34, 657, 2, 564, 57, 234, 756, 67};
        System.out.println("Before sort : ");
        for (int num : arr) {
            System.out.print(num + " , ");
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println("\nAfter sort : ");
        for (int num : arr) {
            System.out.print(num + " , ");
        }
    }
}
