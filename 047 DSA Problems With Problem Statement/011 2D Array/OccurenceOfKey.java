/*
Count Occurrences of a Key in a 2D Array
----------------------------------------
Write a Java program to count the number of occurrences of a given key in a 2D array.

Approach:
---------
1. Initialize a counter variable to 0.
2. Iterate over each element of the 2D array using nested loops.
3. If the element matches the key, increment the counter.
4. Return the counter after traversing the entire array.

Time Complexity: O(n*m) where n = rows, m = columns
Space Complexity: O(1)

Example:
Input:  arr = {{1,3,7},{5,6,7}}, key = 7
Output: 2
*/


public class OccurenceOfKey {

    static int occurenceOfKey(int[][] arr, int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr ={{1,3,7},{5,6,7}};
        System.out.println(occurenceOfKey(arr,7));
    }
}
