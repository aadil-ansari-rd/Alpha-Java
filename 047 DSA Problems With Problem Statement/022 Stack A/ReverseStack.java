/*
Problem Name: Reverse Stack Using Recursion
------------------------------------------
Problem Statement:
-----------------
Given a stack of integers, reverse the stack using recursion without using 
any extra data structures (like another stack or array). The goal is to reverse 
the order of elements so that the top becomes the bottom and vice versa.

You need to:
1. Implement a helper function `pushAtBottom` to insert an element at the bottom of the stack recursively.
2. Recursively pop elements from the stack until it becomes empty.
3. Use `pushAtBottom` to place each popped element at the bottom during the unwind phase of recursion.
4. The stack should be completely reversed after the recursive calls finish.

Example:
--------
Input Stack: [4, 5, 6, 7, 8, 9]
Output Stack after reversal: [9, 8, 7, 6, 5, 4]
Explanation: The top element 9 becomes the bottom, and the bottom element 4 becomes the top.
*/


import java.util.Stack;
public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> st , int data){
        //Base Case
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int currVal = st.pop();
        pushAtBottom(st, data);
        st.push(currVal);
    }
    static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int data = st.pop();
        reverseStack(st);
        pushAtBottom(st, data);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
}
