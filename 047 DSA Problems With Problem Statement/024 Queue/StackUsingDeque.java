/*
Problem: Implement Stack using Deque

Description:
Implement a stack data structure using a Deque. The top of the stack should be represented at the front of the deque. Implement the following operations:
- push(x): Insert element x onto the stack.
- pop(): Remove and return the element on the top of the stack.
- peek(): Get the top element without removing it.
- isEmpty(): Check if the stack is empty.
- display(): Print the stack elements from top to bottom.

Example:
Input:
push(10), push(20), push(30), display(), peek(), pop(), pop(), display(), isEmpty(), pop(), isEmpty()

Output:
Stack: [30, 20, 10]
Top element (peek): 30
Popped: 30
Popped: 20
Stack after pops: [10]
Is stack empty? false
Popped: 10
Is stack empty now? true
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Stack {
    // Using Deque to implement stack (top is at front)
    Deque<Integer> dq = new ArrayDeque<>();

    // Check if the stack is empty
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // Push an element onto the stack (add at front)
    public void push(int val) {
        dq.offerFirst(val);
    }

    // Pop the top element from the stack (remove from front)
    public int pop() {
        return dq.pollFirst();
    }

    // Peek at the top element without removing it
    public int peek() {
        return dq.peekFirst();
    }

    // Display all stack elements from top to bottom
    public void display() {
        System.out.println(dq);
    }
}

public class StackUsingDeque {
    public static void main(String[] args) {
        Stack st = new Stack();

        // Push elements
        st.push(10);
        st.push(20);
        st.push(30);

        // Display current stack
        System.out.print("Stack: ");
        st.display(); // Output: [30, 20, 10]

        // Peek at the top element
        System.out.println("Top element (peek): " + st.peek()); // 30

        // Pop elements
        System.out.println("Popped: " + st.pop()); // 30
        System.out.println("Popped: " + st.pop()); // 20

        // Display remaining stack
        System.out.print("Stack after pops: ");
        st.display(); // Output: [10]

        // Check if empty
        System.out.println("Is stack empty? " + st.isEmpty()); // false

        // Pop last element
        System.out.println("Popped: " + st.pop()); // 10
        System.out.println("Is stack empty now? " + st.isEmpty()); // true
    }
}
