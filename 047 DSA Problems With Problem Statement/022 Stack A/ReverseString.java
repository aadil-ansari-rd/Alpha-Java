/*
Problem Name: Reverse String Using Stack
----------------------------------------
Problem Statement:
-----------------
Given a string, reverse it using a stack. The characters of the string 
should be pushed onto a stack and then popped to form the reversed string.

You need to:
1. Traverse the input string and push each character onto a stack.
2. Pop characters from the stack one by one and append them to a new string.
3. Return the reversed string.

Example:
--------
Input: "irasna lidaa"
Output: "aadil ansari"
Explanation: Using the stack, characters are reversed, producing the string in reverse order.
*/


import java.util.Stack;


public class ReverseString {
    public static String reverseString(String str) {
        Stack<Character> st = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            st.push(str.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "irasna lidaa";
        System.out.println(reverseString(str));
    }
}
