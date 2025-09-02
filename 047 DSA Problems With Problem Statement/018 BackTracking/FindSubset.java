/*
Problem Name: String Subsets (Power Set)
Problem Statement:
-----------------
Given a string of unique characters, generate and print all possible non-empty 
subsets (also known as the power set) of the string using recursion.

You need to:
1. At each character, decide whether to include it in the current subset or not.
2. Recursively process the next character.
3. Print the subset when all characters have been considered. If the subset is empty, 
   print "null".

Example:
Input: str = "abc"
Output:
abc
ab
ac
a
bc
b
c
null

Explanation:
- All combinations of characters are generated, including the empty subset.
- The recursive function explores both choices (include or exclude) for each character to generate all subsets.
*/


public class FindSubset {

    public static void findSubset(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null"); 
                return;
            } else {
                System.out.println(ans);
                return;
            }

        }
        char ch = str.charAt(i);
        findSubset(str, ans + ch, i + 1);
        findSubset(str, ans, i + 1);

    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, "", 0);
    }
}
