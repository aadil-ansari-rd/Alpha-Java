/*
Problem Name: Stack Using Singly Linked List
--------------------------------------------
Problem Statement:
-----------------
Implement a stack using a singly linked list in Java. The stack should support 
standard operations: push, pop, peek, and isEmpty, preserving the LIFO order.

You need to:
1. Define a Node class with `data` and `next` fields.
2. Use a `head` pointer to represent the top of the stack.
3. Implement `push(int data)` to add a new node at the head.
4. Implement `pop()` to remove and return the head node, with underflow check.
5. Implement `peek()` to return the data of the head node without removing it.
6. Implement `isEmpty()` to check if the stack is empty.

Example:
--------
Operations: push(12), push(16), push(23), peek(), pop(), peek()
Output:
23   // Top element after pushes
23   // Popped element
16   // Top element after pop
Explanation: The stack maintains LIFO order using linked list nodes.
*/


class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node head;

    // IsEmpty()
    public boolean isEmpty() {
        return head==null;
    }

    // push()
    public void push(int data) {
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // pop()
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        int val = head.data;
        head= head.next;
        return val;
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

}

public class StackLinkedList {
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