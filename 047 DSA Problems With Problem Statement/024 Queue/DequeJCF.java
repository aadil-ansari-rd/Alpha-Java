/*
Deque using Java Collection Framework (ArrayDeque)

Key Concepts:
-------------
1. Deque (Double-Ended Queue) allows insertion and deletion at both ends.
2. ArrayDeque is a resizable array implementation of Deque.
3. Common operations:
   - addFirst()/offerFirst(): insert at front
   - addLast()/offerLast(): insert at rear
   - removeFirst()/pollFirst(): remove from front
   - removeLast()/pollLast(): remove from rear
   - peekFirst()/peekLast(): view front/rear without removing

Notes:
------
- addX() throws exception if capacity exceeded; offerX() returns false.
- pollX() returns null if empty; removeX() throws exception.
- ArrayDeque is faster than LinkedList for Deque operations (no memory overhead of linked nodes).

Time Complexity:
----------------
- All deque operations are O(1) amortized.
- Space complexity: O(n)
*/

import java.util.*;

public class DequeJCF {
    public static void main(String[] args) {
        // Declare Deque using ArrayDeque
        Deque<Integer> dq = new ArrayDeque<>();

        // Add elements
        dq.addFirst(10); // add at front
        dq.addLast(20);  // add at rear
        dq.offerFirst(5); // add at front (alternative method)
        dq.offerLast(25); // add at rear

        // Display deque
        System.out.println("Deque: " + dq); // [5, 10, 20, 25]

        // Remove elements
        dq.removeFirst();  // removes 5
        dq.removeLast();   // removes 25

        // Peek elements
        System.out.println("Front: " + dq.peekFirst()); // 10
        System.out.println("Rear: " + dq.peekLast());   // 20

        // Final deque
        System.out.println("Final Deque: " + dq); // [10, 20]
    }
}
