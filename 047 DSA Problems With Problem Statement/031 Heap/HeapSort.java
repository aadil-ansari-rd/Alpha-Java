/*
Problem Statement: Heap Sort

✅ Problem Statement:
Given an array of integers, sort the array in ascending order using the Heap Sort algorithm. Heap Sort works by building a max-heap from the array and repeatedly extracting the maximum element from the heap to get a sorted array.

Example 1:
Input: arr = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]

Example 2:
Input: arr = [10, -2, 5, 0, 8]
Output: [-2, 0, 5, 8, 10]
*/

public class HeapSort {

    // Main heap sort method
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap (start from last non-leaf node)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract max element and heapify remaining heap
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index i (size is heapSize)
    private void heapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, heapSize, largest);
        }
    }

    // Main Method -----------------------------------------
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();

        int[] arr = { 4, 1, 3, 9, 7 };

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sorter.heapSort(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
