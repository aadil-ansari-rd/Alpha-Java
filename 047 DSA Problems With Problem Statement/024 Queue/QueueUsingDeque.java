/*
Queue Implementation Using Deque
--------------------------------

1. Concept:
   - A Queue is FIFO: First In First Out.
   - Deque (Double Ended Queue) allows insertion/removal at both ends.
   - We use front = head and rear = tail to implement queue behavior.

2. Operations:
   a. enqueue(int val):
      - Adds element to the rear of the queue using dq.offerLast(val)
      - Time Complexity: O(1)
   b. dequeue():
      - Removes element from front using dq.pollFirst()
      - Returns null if empty
      - Time Complexity: O(1)
   c. peek():
      - Returns front element without removing: dq.peekFirst()
      - Time Complexity: O(1)
   d. isEmpty():
      - Checks if queue is empty: dq.isEmpty()
      - Time Complexity: O(1)
   e. display():
      - Prints queue elements from front to rear

3. Advantages:
   - Efficient O(1) enqueue and dequeue
   - Flexible as Deque allows extensions (e.g., double-ended queue operations)

4. Example:
   Enqueue: 10, 20, 30 → Queue: [10, 20, 30]
   Dequeue: 10 → Queue: [20, 30]
   Peek: 20
   Dequeue: 20 → Queue: [30]
   Dequeue: 30 → Queue: []
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Queue1 {
    // Using Deque to implement Queue (FIFO: front = head, rear = tail)
    Deque<Integer> dq = new ArrayDeque<>();

    // Check if the queue is empty
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // Enqueue: Add element to the rear of the queue
    public void enqueue(int val) {
        dq.offerLast(val);
    }

    // Dequeue: Remove and return element from the front of the queue
    public int dequeue() {
        return dq.pollFirst();
    }

    // Peek: Return the front element without removing it
    public int peek() {
        return dq.peekFirst();
    }

    // Display all elements from front to rear
    public void display() {
        System.out.println(dq);
    }
}

public class QueueUsingDeque {
    public static void main(String[] args) {
        Queue1 q = new Queue1();

        // Enqueue some elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Display current queue
        System.out.print("Queue: ");
        q.display();  // Output: [10, 20, 30]

        // Peek at front element
        System.out.println("Front element (peek): " + q.peek()); // 10

        // Dequeue two elements
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Dequeued: " + q.dequeue()); // 20

        // Display queue after dequeues
        System.out.print("Queue after dequeues: ");
        q.display(); // Output: [30]

        // Check if empty
        System.out.println("Is queue empty? " + q.isEmpty()); // false

        // Dequeue last element
        System.out.println("Dequeued: " + q.dequeue()); // 30
        System.out.println("Is queue empty now? " + q.isEmpty()); // true
    }
}
