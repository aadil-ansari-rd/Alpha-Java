/*
Queue Reversal Using Stack
--------------------------

1. Concept:
   - A queue follows FIFO (First In First Out), but reversing requires LIFO order.
   - Stack is LIFO, so we can use it to reverse the order of queue elements.

2. Steps:
   a. Dequeue all elements from the queue and push them onto a stack.
      - This reverses their order because stack pops elements in reverse.
   b. Pop all elements from the stack and enqueue them back into the queue.
      - The queue now has elements in reversed order.

3. Time & Space Complexity:
   - Time: O(n) for moving elements to stack + O(n) for moving back = O(n)
   - Space: O(n) extra space for the stack.

4. Example:
   Input Queue: 1 2 3 4 5 6
   Stack after pushing: 6 5 4 3 2 1
   Queue after popping from stack: 6 5 4 3 2 1

5. Notes:
   - Works for any Queue implementation: ArrayDeque, LinkedList, etc.
   - Can be done recursively as well without an explicit stack.
*/

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        reverse(q);
    }
}
