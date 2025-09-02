/*
 Problem: Generate Binary Numbers from 1 to N
 --------------------------------------------

 Approach (Using Queue):
 1. Initialize a queue and add the first binary number "1".
 2. Loop from 1 to N:
    - Dequeue the front element and print it.
    - Generate the next two numbers by appending "0" and "1" to the current string.
    - Enqueue these two new strings back into the queue.
 3. This ensures that numbers are generated in increasing order.

 Key Points:
 -----------
 - Uses level-order generation (BFS-like) of binary numbers.
 - Avoids converting decimal numbers to binary manually.
 - Time Complexity: O(N)
 - Space Complexity: O(N)
*/

import java.util.Queue;
import java.util.*;


public class BinaryNumberGenerator {

    // Function to generate binary numbers from 1 to N
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();

        // Start with "1" as the first binary number
        queue.add("1");

        for (int i = 1; i <= N; i++) {
            // Fetch and print the front element of the queue
            String current = queue.poll();
            System.out.print(current + " ");

            // Generate next two binary numbers and add to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        generateBinaryNumbers(N);
    }
}
