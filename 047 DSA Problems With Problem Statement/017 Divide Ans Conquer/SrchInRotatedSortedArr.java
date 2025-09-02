/*
Problem Name: Search in Rotated Sorted Array
Problem Statement:
-----------------
Given a rotated sorted array of unique integers and a target value, implement an 
algorithm to find the index of the target in the array. If the target is not present, 
return -1. The array was originally sorted in ascending order and then rotated at 
some pivot unknown beforehand.

You need to implement both:
1. Recursive search using modified binary search.
2. Iterative search using modified binary search.

Example:
Input: arr = [4, 5, 6, 7, 0, 1, 2], target = 0
Output: 4

Explanation:
- The array [4,5,6,7,0,1,2] is rotated at pivot 7.
- Using modified binary search, the target value 0 is located at index 4.
- Both recursive and iterative approaches should return the same index if the target exists.
*/


public class SrchInRotatedSortedArr {

    public static int search(int[] arr, int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        if (arr[mid] == tar) {
            return mid;
        }
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                return search(arr, tar, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static int iterativeSearch(int[] arr, int tar) {
        int st = 0, end = arr.length - 1;
        while (st <= end) {
        int mid = st + (end - st) / 2;

            if (arr[mid] == tar) {
                return mid;
            } else if (arr[st] <= arr[mid]) {
                if (arr[st] <= tar && tar <= arr[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if (arr[mid] <= tar && tar <= arr[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Recursive : " + search(arr, 0, 0, arr.length - 1));
        System.out.println("Iterative : " + iterativeSearch(arr, 0));
    }
}
