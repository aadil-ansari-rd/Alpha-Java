/*
Problem Name: Valid Parentheses (LeetCode 20)
---------------------------------------------

Problem Statement:
-----------------
Given a string containing only the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.

Approach:
---------
1. Initialize an empty stack.
2. Traverse each character:
   - If it is an opening bracket '(', '{', '[', push it onto the stack.
   - If it is a closing bracket ')', '}', ']':
     • If the stack is empty, return false (no matching opening).
     • Pop the top element from the stack and check if it matches the corresponding opening bracket.
       - If not matching, return false.
3. After traversal, check if the stack is empty:
   - If empty → valid parentheses.
   - Else → invalid parentheses.

Key Points:
-----------
- Stack preserves the correct order of nested brackets.
- Supports multiple types of brackets.
- Time Complexity: O(n)
- Space Complexity: O(n)

Example:
--------
Input: "([{}])"
Output: true
Explanation: All brackets are correctly matched and nested.
*/


import java.util.Stack;

public class ValidParenthesis {
    // public static boolean validParenthesis(String str){
    // Stack<Character> st = new Stack<>();
    // int n= str.length();
    // for(int i=0;i<n;i++){
    // char ch = str.charAt(i);
    // if(ch=='(' || ch=='[' ||ch=='{'){
    // st.push(ch);
    // }
    // if(ch==')' || ch == ']' || ch=='}'){
    // if(st.isEmpty()) return false;
    // char check = st.peek();
    // if(ch==')'){
    // if(check=='('){
    // st.pop();
    // }else{
    // return false;
    // }
    // }else if(ch==']'){
    // if(check=='['){
    // st.pop();
    // }else{
    // return false;
    // }
    // }else{
    // if(check=='{'){
    // st.pop();
    // }else{
    // return false;
    // }
    // }

    // }
    // }
    // if(st.isEmpty()){
    // return true;
    // }
    // return false;
    // }

    public static boolean validParenthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.isEmpty())
                    return false;
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("()[]{}]"));
    }
}
