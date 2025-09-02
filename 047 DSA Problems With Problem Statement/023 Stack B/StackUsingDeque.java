/*
Problem Name: Stack Using Deque
--------------------------------
Problem Statement:
-----------------
Implement a stack using a Deque (Double-Ended Queue) with the following operations:

Key Points:
-----------
- Deque allows insertion/removal from both ends in O(1).
- Using `offerFirst` for push and `pollFirst` for pop makes the front of the deque act as the top of the stack.
- `peekFirst` checks the top element without removing it.
- Deque-based stack avoids resizing overhead and is more efficient than ArrayList/Stack-based implementations.

Operations:
-----------
1. push(val): Add element to the top → dq.offerFirst(val)
2. pop(): Remove top element → dq.pollFirst()
3. peek(): Return top element → dq.peekFirst()
4. isEmpty(): Check if stack is empty → dq.isEmpty()
5. display(): Show all elements from top to bottom → print dq

Example:
--------
Operations: push(10), push(20), push(30), peek(), pop(), display()
Output:
30   // Top element after pushes
30   // Popped element
[20, 10] // Remaining stack from top to bottom
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
