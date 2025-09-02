/*
Problem Name: Push Element at Bottom of Stack
--------------------------------------------
Problem Statement:
-----------------
Given a stack and an integer value, implement a function to push the value 
at the bottom of the stack using recursion, without using any extra data structures.

You need to:
1. Check if the stack is empty. If yes, push the new value and return.
2. Otherwise, pop the top element and recursively call the function to push the value at the bottom.
3. After the recursive call returns, push back the popped element to maintain original order.

Example:
--------
Input Stack: [4, 5, 6, 7, 8, 9], data = 3
Output Stack after pushAtBottom: [3, 4, 5, 6, 7, 8, 9]
Explanation: The new value 3 is added at the bottom, and the order of existing elements is preserved.
*/


import java.util.Stack;
public class PushAtBottom {
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
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        System.out.println(st);
        pushAtBottom(st, 3);
        System.out.println(st);
    }
}
