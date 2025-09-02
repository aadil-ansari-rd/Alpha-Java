/*
Problem Name: Delete N Nodes After M Nodes in Linked List
--------------------------------------------------------
Problem Statement:
-----------------
Given a singly linked list, delete N nodes after every M nodes of the list.

Example:
Input:  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null
M = 2, N = 3
Output: 1 -> 2 -> 6 -> 7 -> 10 -> null

Approach:
---------
1. Traverse the linked list with a pointer `curr`.
2. Skip M nodes.
3. Delete next N nodes by adjusting the `next` pointer.
4. Repeat until end of list.
5. Handle edge cases where remaining nodes are less than M or N.

Time Complexity: O(n) - Single traversal of the linked list.
Space Complexity: O(1) - In-place modification.
*/



// Node class for singly linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNAfterM {

    // Function to delete N nodes after M nodes
    public static ListNode deleteNafterM(ListNode head, int M, int N) {
        ListNode curr = head;

        while (curr != null) {
            // Skip M nodes
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            // If end reached during skip, stop
            if (curr == null) break;

            // Delete next N nodes
            ListNode temp = curr.next;
            for (int i = 1; i <= N && temp != null; i++) {
                temp = temp.next;
            }

            // Link current node to the node after N deletions
            curr.next = temp;

            // Move to next segment
            curr = temp;
        }

        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        // Create linked list: 1 → 2 → 3 → 4 → ... → 10
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        System.out.print("Original list: ");
        printList(head);

        int M = 2, N = 3;
        head = deleteNafterM(head, M, N);

        System.out.print("Modified list: ");
        printList(head);
    }
}
