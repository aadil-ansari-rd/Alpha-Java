/*
Problem Name: Merge K Sorted Linked Lists
-----------------------------------------
Problem Statement:
-----------------
Merge k sorted linked lists into one sorted linked list.

Approach:
---------
1. Use a min-heap (PriorityQueue) to efficiently get the smallest current node among the k lists.
2. Push the head of each non-empty list into the heap.
3. Repeatedly extract the minimum node from the heap and append it to the merged list.
4. If the extracted node has a next node, push it into the heap.
5. Continue until the heap is empty.

Time Complexity:
----------------
- Let N be the total number of nodes across all k lists.
- Heap operations take O(log k), so overall complexity is O(N log k).

Space Complexity:
-----------------
- O(k) for the priority queue.

Example:
--------
Input:
List 1: 1 -> 4 -> 5
List 2: 1 -> 3 -> 4
List 3: 2 -> 6

Output:
1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
*/

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    // Merge K sorted lists
    public static ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to store nodes based on their value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();         // Get the smallest node
            tail.next = curr;                  // Add to result
            tail = tail.next;

            if (curr.next != null) {
                pq.add(curr.next);             // Push next node of current list
            }
        }

        return dummy.next;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create List 1: 1 → 4 → 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // Create List 2: 1 → 3 → 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Create List 3: 2 → 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        System.out.println("Merged Sorted List:");
        ListNode merged = mergeKLists(lists);
        printList(merged);
    }
}
