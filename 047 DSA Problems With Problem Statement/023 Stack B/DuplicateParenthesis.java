/*
Problem Name: Duplicate Parentheses
-----------------------------------
Problem Statement:
-----------------
Given a valid expression containing parentheses, determine if the expression 
contains any duplicate parentheses. Duplicate parentheses occur when a sub-expression 
is enclosed within extra unnecessary parentheses.

You need to:
1. Use a stack to keep track of characters.
2. Traverse the string:
   - Push every character except ')'.
   - When ')' is encountered, count characters until '(' is found.
   - If no characters are between '(' and ')', it indicates duplicate parentheses.
3. Return true if duplicate parentheses exist; otherwise, return false.

Example:
--------
Input: "((a+b+(c+d)))"
Output: true
Explanation:
- The outermost parentheses around "(c+d)" are necessary, but the extra parentheses around the entire expression are duplicates.
*/

import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean duplicateParenthesis(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Push all characters except closing parenthesis ')'
            if (ch != ')') {
                st.push(ch);
            } else {
                int count = 0;
                // Count how many characters are between '(' and ')'
                while (st.peek() != '(') {
                    count++;
                    st.pop();
                }
                // Pop the matching opening '('
                st.pop();
                // If there were no characters between '()', it's a duplicate
                if (count < 1) {
                    return true;
                }
            }
        }
        // No duplicate parentheses found
        return false;
    }

    public static void main(String[] args) {
        System.out.println(duplicateParenthesis("((a+b+(c+d)))"));
    }
}
