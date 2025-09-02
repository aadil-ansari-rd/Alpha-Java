/*
Queue in Java Collections Framework (JCF)
-----------------------------------------

1. Implementations Used:
   - LinkedList: Implements Queue, allows null elements.
   - ArrayDeque: Implements Queue, faster, no capacity restriction, no nulls.

2. Basic Operations:
   - isEmpty(): Checks if queue is empty.
   - add(element): Adds element at rear. Unsafe → throws exception if fails.
   - offer(element): Adds element at rear. Safe → returns false if fails.
   - remove(): Removes element from front. Unsafe → throws exception if empty.
   - poll(): Removes element from front. Safe → returns null if empty.
   - clear(): Removes all elements.

3. Example Workflow:
   - Check if queue is empty.
   - Enqueue using add() and offer().
   - Dequeue using remove() and poll().
   - Check empty status.
   - Clear all elements and recheck empty status.

4. Notes:
   - LinkedList and ArrayDeque are commonly used for queues.
   - add()/remove() throw exceptions, offer()/poll() are safer.
   - Use ArrayDeque for better performance than LinkedList.
*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        //Is Empty
        System.out.println("Q1 : isEmpty() : " + q1.isEmpty());
        System.out.println("Q2 : isEmpty() : " + q2.isEmpty());

        // Enqueue
        System.out.println("Enqueue --------------------------------");
        System.out.println("By add() : Unsafe ");
        q1.add(11);
        q1.add(12);
        q1.add(13);
        q2.add(11);
        q2.add(12);
        q2.add(13);
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        System.out.println("By offer() : Safe");
        q1.offer(14);
        q1.offer(15);
        q1.offer(16);
        q2.offer(14);
        q2.offer(15);
        q2.offer(16);
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        System.out.println("Dequeue --------------------------------");
        System.out.println("By remove() : Unsafe");
        q1.remove();
        q2.remove();
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);
        System.out.println("By poll() : Safe");
        q1.poll();
        q2.poll();
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        //Is Empty
        System.out.println("Q1 : isEmpty() : " + q1.isEmpty());
        System.out.println("Q2 : isEmpty() : " + q2.isEmpty());

        //Clear All
        System.out.println("Clear All --------------------------------");

        q1.clear();
        q2.clear();
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        //Is Empty
        System.out.println("Q1 : isEmpty() : " + q1.isEmpty());
        System.out.println("Q2 : isEmpty() : " + q2.isEmpty());
    }
}
