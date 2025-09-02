/*
Problem Name: String Permutations
Problem Statement:
-----------------
Given a string of unique characters, generate and print all possible permutations 
of the string using recursion. Each permutation should use all characters exactly once.

You need to:
1. Select each character in the string one by one.
2. Remove the selected character from the remaining string.
3. Append the selected character to the current answer string.
4. Recursively repeat the process until all characters are used and print the permutation.

Example:
Input: str = "abc"
Output:
abc
acb
bac
bca
cab
cba

Explanation:
- All possible arrangements of the characters 'a', 'b', and 'c' are printed.
- The recursive function builds permutations by choosing each character in turn and exploring all combinations of the remaining characters.
*/


public class FindPermutation{
    public static void findPermutation(String str , String ans){ //O(n*n!)
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //Recursion
        for(int i=0;i<str.length();i++){ //O(n)
            char curr = str.charAt(i);
            //"abcde" => "ab" + "de" = "abde"
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr); //O(n!)

        }
    }
    public static void main(String[] args){
        String str = "abc";
        findPermutation(str, "");
    }
}