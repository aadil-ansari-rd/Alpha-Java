/*
Problem Name: Find All Occurrences of Key in Array
Problem Statement:
-----------------
Write a Java program to find all occurrences of a given key in an integer array 
using recursion.

The program should:
1. Take an integer array 'arr' and an integer 'key' as input.
2. Recursively traverse the array.
3. Print all indices where the array element is equal to the key.

Example:
Input: arr = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
Output: 1 5 7 8

Explanation:
The key '2' occurs at indices 1, 5, 7, and 8 in the array.
The recursive function prints each index as it finds a match.
*/


public class FindAllOccurence{
    static void findAllOccurence(int[] arr, int key , int i){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i + " ");
        }
        findAllOccurence(arr, key, i+1);
    }
    public static void main(String[] args){
        int[] arr = {3,2,4,5,6,2,7,2,2};
        findAllOccurence(arr, 2, 0);
    }
}