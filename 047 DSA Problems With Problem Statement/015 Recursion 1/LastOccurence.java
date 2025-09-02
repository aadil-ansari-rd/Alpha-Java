/*
Problem Name: Last Occurrence in Array Using Recursion
Problem Statement:
-----------------
Write a Java program to find the last occurrence of a given key in an 
integer array using recursion.

The program should:
1. Take an integer array 'arr', a key 'key', and a starting index 'i'.
2. Recursively check each element of the array from the end (index i) towards the start.
3. Return the index of the last occurrence of the key if found.
4. If the key is not found, return -1.

Example:
Input: arr = [1, 2, 13, 5, 6, 9], key = 13
Output: 2
Explanation: The last occurrence of 13 is at index 2.

Input: arr = [1, 2, 13, 5, 6, 9], key = 4
Output: -1
Explanation: 4 is not present in the array.
*/


public class LastOccurence {
    public static int lastOccurence(int[] arr , int key , int i){
        if(i<0) return  -1;
        if(arr[i]==key) return i;
        return  lastOccurence(arr, key, i-1);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 13 ,5,6,9};
        System.out.println(lastOccurence(arr, 13, arr.length-1));
    }
}
