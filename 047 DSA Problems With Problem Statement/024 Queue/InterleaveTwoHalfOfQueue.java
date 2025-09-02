/*
Problem Name: Interleave Queue

Problem Statement:
-----------------
Given a queue of even length, rearrange it by interleaving the first half with the second half. For a queue [a1, a2, ..., an, b1, b2, ..., bn], the interleaved queue should be [a1, b1, a2, b2, ..., an, bn].

Approach:
---------
1. Determine the size of the queue (assume even length 2n).
2. Extract the first half (n elements) into a temporary queue.
3. For each element in the temporary queue:
   - Dequeue from the first half queue and enqueue it back to the original queue.
   - Dequeue from the remaining original queue (second half) and enqueue it.
4. Repeat until all elements are interleaved.

Key Points:
-----------
- Requires O(n) extra space for the temporary queue.
- Time Complexity: O(n)
- Space Complexity: O(n)
- Preserves the relative order within each half.

Example:
--------
Input: [1, 2, 3, 4, 5, 6]
Output: [1, 4, 2, 5, 3, 6]
Explanation: First half [1, 2, 3], second half [4, 5, 6], interleaved as 1-4, 2-5, 3-6.
*/


import java.util.ArrayDeque;
import java.util.Queue;
public class InterleaveTwoHalfOfQueue{
    public static void interleave(Queue<Integer> q){
        int n = q.size();
        Queue<Integer> firstHalf = new ArrayDeque<>();
        int halfLen = n/2;
        while(halfLen>=1){
            firstHalf.offer(q.poll());
            halfLen--;
        }
        while (!firstHalf.isEmpty()) {
            q.offer(firstHalf.poll());
            q.offer(q.poll());
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
        interleave(q);
        
    }
}