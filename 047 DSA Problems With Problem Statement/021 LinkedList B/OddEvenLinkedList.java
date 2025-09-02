/*
Problem Name: Segregate Even and Odd Nodes in Linked List
--------------------------------------------------------
Problem Statement:
-----------------
Given a singly linked list, rearrange it so that all even-valued nodes appear 
before all odd-valued nodes while maintaining the relative order of even and 
odd nodes from the original list. 

You need to:
1. Traverse the linked list.
2. Separate nodes into two lists: even and odd.
3. Append the odd list after the even list.
4. Return the head of the rearranged linked list.

Example:
--------
Input: 8 -> 12 -> 10 -> 5 -> 4 -> 1 -> 6 -> NULL
Output: 8 -> 12 -> 10 -> 4 -> 6 -> 5 -> 1 -> NULL
Explanation: All even numbers are grouped first followed by odd numbers, 
maintaining their original order.
*/


class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class OddEvenLinkedList {

    public static Node rearrangeEvenOdd(Node head) {
        if (head == null) return null;

        Node evenHead = new Node(0), oddHead = new Node(0);
        Node evenTail = evenHead, oddTail = oddHead;

        while (head != null) {
            if (head.data % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }

        // Combine even and odd lists
        evenTail.next = oddHead.next;
        oddTail.next = null;

        return evenHead.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = new Node(8);
        head.next = new Node(12);
        head.next.next = new Node(10);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList(head);

        head = rearrangeEvenOdd(head);

        System.out.println("After Even-Odd Rearrangement:");
        printList(head);
    }
}
