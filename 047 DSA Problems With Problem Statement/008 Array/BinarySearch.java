/*
Binary Search in a Sorted Array
-------------------------------
Write a Java program to perform binary search on a sorted integer array.

The program should:
1. Implement a method `binarySearch(int[] nums, int key)` that searches for `key` in the sorted array `nums`.
   - Use the binary search algorithm with start, end, and mid indices.
   - Return the index of `key` if found, otherwise return -1.
2. In the main method, define a sorted integer array.
3. Specify a key to search in the array.
4. Call the `binarySearch` method and display the index if the element is found, or a message indicating it was not found.

Example:
Array: {1, 3, 5, 6, 7, 8, 10}
Key: 6
Output: Your element is at index : 3
*/


public class BinarySearch {

    public static int binarySearch(int[] nums, int key) {
        int st = 0, end = nums.length-1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6, 7, 8, 10, 11, 12, 13, 16, 18, 19, 22, 25, 26, 28, 30, 34, 35, 36, 38, 39, 41, 43, 44, 45, 47, 48, 53, 55, 56, 60, 62, 63, 67, 73, 75, 78, 80, 81, 84, 85, 86, 88, 90, 91, 92, 97, 98};
        int key = 39;
        int index = binarySearch(nums, key);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Your element is at index : " + index);
        }

    }
}
