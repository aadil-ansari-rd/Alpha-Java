/*
Problem Name: String Length using Recursion
Problem Statement:
-----------------
Write a Java program to find the length of a given string using recursion.

The program should:
1. Take a string 'str' as input.
2. Recursively calculate the length by removing the first character 
   and adding 1 for each recursive call.
3. Return the total length.

Example:
Input: "Aasdfjaferf"
Output: 11

Explanation:
The recursive function checks if the string is empty (base case). 
If not, it counts 1 for the first character and calls itself with the 
remaining substring.
*/



public class LengthOfString {

    public static int lengthOfString(String str) {
        if (str.equals("")) {
            return 0;
        }
        return 1 + lengthOfString(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(lengthOfString("Aasdfjaferf"));
    }
}
