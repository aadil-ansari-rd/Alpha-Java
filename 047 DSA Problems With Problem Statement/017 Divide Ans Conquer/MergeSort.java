/*
Problem Name: Merge Sort using Recursion
Problem Statement:
-----------------
Write a Java program to sort an integer array using the Merge Sort algorithm 
with recursion.

The program should:
1. Take an integer array 'arr' as input.
2. Recursively divide the array into two halves until each subarray has one element.
3. Merge the sorted halves back together in sorted order.
4. Print the array before and after sorting.

Example:
Input: arr = {2, 34, 657, 2, 564, 57, 234, 756, 67}
Output:
Before sort : 2 , 34 , 657 , 2 , 564 , 57 , 234 , 756 , 67 ,
After sort : 2 , 2 , 34 , 57 , 67 , 234 , 564 , 657 , 756 ,

Explanation:
- The mergeSort function recursively splits the array into halves.
- The merge function combines two sorted subarrays into one sorted array.
- The process continues until the entire array is sorted.
*/


public class MergeSort {

    public static void mergeSort(int[] arr, int st, int end) {
        if (st >= end) {
            return;
        }
        int mid = st + (end - st) / 2;

        //Assuming left part is sorted 
        mergeSort(arr, st, mid);
        //Assuming right part is sorted 
        mergeSort(arr, mid + 1, end);

        //Merge left sort and right sort
        merge(arr, st, mid, end);

    }

    public static void merge(int[] arr, int st, int mid, int end) {
        int[] merge = new int[end - st + 1];
        int i = st, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                merge[k++] = arr[i++];
            } else {
                merge[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            merge[k++] = arr[i++];
        }
        while (j <= end) {
            merge[k++] = arr[j++];
        }

        //Copy merge array to original array
        for (int x = 0; x < merge.length; x++) {
            arr[st + x] = merge[x];
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 34, 657, 2, 564, 57, 234, 756, 67};
        System.out.println("Before sort : ");
        for (int num : arr) {
            System.out.print(num + " , ");
        }
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("\nAfter sort : ");
        for (int num : arr) {
            System.out.print(num + " , ");
        }
    }
}
