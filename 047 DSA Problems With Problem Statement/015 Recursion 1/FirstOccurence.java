/*
Problem Name: First Occurrence in Array Using Recursion
Problem Statement:
-----------------
Write a Java program to find the first occurrence of a given key in an 
integer array using recursion.

The program should:
1. Take an integer array 'arr', a key 'key', and a starting index 'i'.
2. Recursively check each element of the array starting from index 'i'.
3. Return the index of the first occurrence of the key if found.
4. If the key is not found, return -1.

Example:
Input: arr = [1, 2, 13, 5, 6, 9], key = 9
Output: 5
Explanation: The first occurrence of 9 is at index 5.

Input: arr = [1, 2, 13, 5, 6, 9], key = 4
Output: -1
Explanation: 4 is not present in the array.
*/


public class FirstOccurence {
    public static int firstOccurence(int[] arr , int key , int i){
        if(i==arr.length) return  -1;
        if(arr[i]==key) return i;
        return  firstOccurence(arr, key, i+1);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 13 ,5,6,9};
        System.out.println(firstOccurence(arr, 9, 0));
    }
}
