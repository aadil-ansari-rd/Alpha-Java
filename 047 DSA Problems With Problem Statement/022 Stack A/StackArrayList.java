/*
Problem Name: Stack Implementation Using ArrayList
-------------------------------------------------
Problem Statement:
-----------------
Implement a stack using an ArrayList in Java. The stack should support the 
basic operations: push, pop, peek, and isEmpty, simulating the behavior of a 
standard stack data structure.

You need to:
1. Use an ArrayList to store stack elements.
2. Implement `push(int data)` to add elements to the top of the stack.
3. Implement `pop()` to remove and return the top element, with underflow check.
4. Implement `peek()` to return the top element without removing it, with empty check.
5. Implement `isEmpty()` to check if the stack has no elements.

Example:
--------
Operations: push(12), push(16), push(23), peek(), pop(), peek()
Output:
23   // Top element after pushes
23   // Popped element
16   // Top element after pop
Explanation: Stack maintains LIFO order using ArrayList internally.
*/


import java.util.*;

class Stack {
    ArrayList<Integer> stack = new ArrayList<>();

    // IsEmpty()
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    // push()
    public void push(int data) {
        stack.add(data);
    }

    // pop()
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

}

public class StackArrayList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(16);
        s.push(23);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());

    }

}