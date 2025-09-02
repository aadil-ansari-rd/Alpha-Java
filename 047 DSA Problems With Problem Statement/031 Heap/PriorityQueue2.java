/*
Problem Statement: Max-Heap using PriorityQueue in Java

✅ Problem Statement:
Demonstrate the use of Java's PriorityQueue as a max-heap. Insert a set of integers and repeatedly remove and print the largest element until the queue is empty.

Example:
Input: [2, 1, 0, 4, 3]
Output:
4
3
2
1
0
Explanation: Using a PriorityQueue with Comparator.reverseOrder(), the largest element is always at the front, so polling returns elements in descending order.
*/

import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueue2{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(2);
        pq.offer(1);
        pq.offer(0);
        pq.offer(4);
        pq.offer(3);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}