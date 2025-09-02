/*
Problem Name: Remove Duplicates from String using Recursion
Problem Statement:
-----------------
Write a Java program to remove duplicate characters from a given string 
using recursion.

The program should:
1. Take a string 'str' as input.
2. Use a boolean array 'map' to track which characters have already been added.
3. Recursively process each character:
   - If the character is not seen before, append it to the result.
   - If it is a duplicate, skip it.
4. Print the resulting string with duplicates removed.

Example:
Input: "apnacollege"
Output: "apncolge"

Explanation:
The function traverses the string recursively and keeps only the first occurrence 
of each character. Subsequent duplicates are ignored.
*/


public class RemoveDuplicate{
    public static void removeDuplicates(String str , int i , StringBuilder newStr , boolean[] map){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        if(map[str.charAt(i) - 'a']){ //Duplicate
            removeDuplicates(str, i+1, newStr, map);
        }else{
            map[str.charAt(i)-'a']=true;
            removeDuplicates(str, i+1, newStr.append(str.charAt(i)),map);

        }
    }
    public static void main(String[] args){
        removeDuplicates("apnacollege", 0, new StringBuilder(""),new boolean[26]);
    }
}