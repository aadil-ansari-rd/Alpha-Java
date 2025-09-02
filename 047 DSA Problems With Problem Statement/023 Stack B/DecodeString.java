/*
Problem Name: Decode String
---------------------------
Problem Statement:
-----------------
Given an encoded string where patterns of the form k[encoded_string] indicate 
that the encoded_string inside the square brackets is repeated exactly k times, 
decode the string and return the fully expanded version.

You need to:
1. Use two stacks: one to store repeat counts and another to store previous strings.
2. Traverse the input string character by character.
   - If a digit is found, build the repeat count.
   - If '[' is found, push the current count and current string onto stacks and reset them.
   - If ']' is found, pop a count and previous string, repeat the current string, and append to previous string.
   - If a letter is found, append it to the current string.
3. Return the fully decoded string after traversal.

Example:
--------
Input: "3[b2[v]]"
Output: "bvvbvvbvv"
Explanation:
- Inner "2[v]" becomes "vv"
- Outer "3[bvv]" becomes "bvvbvvbvv"
*/

import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int count = countStack.pop();
                while (count-- > 0) decoded.append(current);
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[cv]"));      // Output: cvcv
        System.out.println(decodeString("3[b2[v]]"));   // Output: bvvbvvbvv
    }
}
