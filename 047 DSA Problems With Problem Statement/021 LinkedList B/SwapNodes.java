/*
Problem Name: Swap Nodes in Linked List Without Swapping Data
------------------------------------------------------------
Problem Statement:
-----------------
Given a singly linked list and two values x and y, swap the nodes containing 
these values by changing the links (not just swapping data). If either x or y 
is not present, the list should remain unchanged.

You need to:
1. Locate the nodes with values x and y along with their previous nodes.
2. Update the previous nodes to point to the opposite node.
3. Swap the next pointers of the x and y nodes.
4. Return the head of the modified linked list.

Example:
--------
Input: 1 -> 2 -> 3 -> 4 -> NULL, x = 2, y = 4
Output: 1 -> 4 -> 3 -> 2 -> NULL
Explanation: Nodes containing 2 and 4 are swapped by updating links, maintaining the original order of other nodes.
*/


class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class SwapNodes {

    // Function to swap nodes by links
    public static Node swapNodes(Node head, int x, int y) {
        if (x == y) return head;

        Node prevX = null, currX = head;
        Node prevY = null, currY = head;

        // Find X and its previous node
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Find Y and its previous node
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either X or Y is not present, no swap
        if (currX == null || currY == null) return head;

        // Update previous pointers
        if (prevX != null) prevX.next = currY;
        else head = currY;

        if (prevY != null) prevY.next = currX;
        else head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }

    // Function to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        head = swapNodes(head, 2, 4);

        System.out.println("List after swapping 2 and 4:");
        printList(head);
    }
}
