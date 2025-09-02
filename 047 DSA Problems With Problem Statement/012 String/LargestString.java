/*
Find Lexicographically Largest String in Array
----------------------------------------------
Write a Java program to find the lexicographically largest string in an array of strings. 
Comparison should be case-insensitive.

Approach:
---------
1. Initialize the first string in the array as the largest.
2. Iterate through the array starting from the second element.
3. Use `compareToIgnoreCase()` to compare the current largest with the next string.
4. If the result is less than 0, update the largest string.
5. After the loop, return the largest string.

Time Complexity: O(n * m) where n = number of strings, m = average length of strings
Space Complexity: O(1)

Example:
Input: {"apple", "banana", "grapes", "cherry"}
Output: "grapes"
*/



public class LargestString {

    public static String largestString(String[] names){
        String largest = names[0];
        for(int i=1;i<names.length;i++){
            int cmp = largest.compareToIgnoreCase(names[i]);
            if(cmp<0){
                largest = names[i];
            }
        }
        return largest;
    }

    public static void main(String[] args){
        String[] names = {"apple", "banana", "grapes", "cherry"};
        System.out.println(largestString(names));
    }
}
