/*
Problem Statement: Priority Queue Basic Operations in Java

✅ Problem Statement:
Demonstrate the basic operations of a PriorityQueue in Java. Insert a set of integers into a min-heap PriorityQueue and repeatedly remove and print the smallest element until the queue is empty.

Example:
Input: [4, 3, 2, 1, 0]
Output:
0
1
2
3
4
Explanation: The PriorityQueue automatically arranges elements in ascending order (min-heap), so polling returns elements from smallest to largest.
*/

import java.util.PriorityQueue;
public class PriorityQueue1{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(4);
        pq.offer(3);
        pq.offer(2);
        pq.offer(1);
        pq.offer(0);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}