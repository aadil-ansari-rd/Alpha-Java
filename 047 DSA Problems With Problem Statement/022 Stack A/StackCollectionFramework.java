/*
Problem Name: Demonstration of Java Built-in Stack
--------------------------------------------------
Problem Statement:
-----------------
Demonstrate the use of Java's built-in Stack class from the Collection Framework. 
Perform basic stack operations: push, pop, and peek to understand the LIFO behavior.

You need to:
1. Create a Stack of integers using `java.util.Stack`.
2. Use `push()` to add elements to the top of the stack.
3. Use `pop()` to remove and return the top element.
4. Use `peek()` to view the top element without removing it.
5. Print the results of these operations to verify correct stack behavior.

Example:
--------
Operations: push(12), push(16), push(23), peek(), pop(), peek()
Output:
23   // Top element after pushes
23   // Popped element
16   // Top element after pop
Explanation: Demonstrates LIFO order using Java's built-in Stack.
*/


import java.util.Stack;
public class StackCollectionFramework {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(12);
        s.push(16);
        s.push(23);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
