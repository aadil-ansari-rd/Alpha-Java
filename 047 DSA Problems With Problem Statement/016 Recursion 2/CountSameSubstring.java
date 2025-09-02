/*
Problem Name: Count Substrings with Same First and Last Character
Problem Statement:
-----------------
Write a Java program to count the number of substrings in a given string 
where the first and last characters of the substring are the same.

The program should:
1. Take a string 's' as input.
2. Use recursion to check all possible substrings.
3. Count each substring where the first and last character are equal.
4. Return the total count.

Example:
Input: "abcab"
Output: 7
Explanation: The valid substrings are:
"a", "b", "c", "a", "b", "abca", "bcab"

Input: "aba"
Output: 4
Explanation: The valid substrings are:
"a", "b", "a", "aba"
*/


public class CountSameSubstring {
    public static int countSameSubstring(String s , int st , int end){
        if(st==s.length())return  0;
        if(end == s.length()){
            return countSameSubstring(s, st+1, st+1);
        }
        int count = s.charAt(st)==s.charAt(end)?1:0;
        return count + countSameSubstring(s, st, end+1);
    }
    public static void main(String[] args) {
        System.out.println(countSameSubstring("abcab", 0, 0));
        System.out.println(countSameSubstring("aba", 0, 0));
    }
}
