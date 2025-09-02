/*
Problem Statement: Minimum Time to Fill Slots (LeetCode Variant)

✅ Problem Statement:
You are given N slots in a row, numbered from 1 to N. Some slots are initially filled, and in one unit of time, the filled slots can fill their adjacent empty slots (both left and right). Determine the minimum time required to fill all slots.

Example 1:
Input: N = 6, filledSlots = [2,6]
Output: 2
Explanation:
- Time 1: Slots 1 and 3 get filled by slot 2, slot 5 gets filled by slot 6
- Time 2: Slot 4 gets filled
All slots are now filled in 2 units of time.

Example 2:
Input: N = 10, filledSlots = [1,10]
Output: 5
Explanation:
The filling spreads symmetrically from slots 1 and 10, taking 5 units of time to fill all slots.
*/

import java.util.*;

public class FillSlots {

    public static int minTimeToFillSlots(int N, int[] arr) {
        boolean[] filled = new boolean[N + 1];  // Index 1 to N
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize queue with already filled positions
        for (int pos : arr) {
            if (!filled[pos]) {
                queue.add(pos);
                filled[pos] = true;
            }
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyNewFill = false;

            // Process current level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // Check left neighbor
                if (curr - 1 >= 1 && !filled[curr - 1]) {
                    filled[curr - 1] = true;
                    queue.add(curr - 1);
                    anyNewFill = true;
                }

                // Check right neighbor
                if (curr + 1 <= N && !filled[curr + 1]) {
                    filled[curr + 1] = true;
                    queue.add(curr + 1);
                    anyNewFill = true;
                }
            }

            // Increase time only if new fill happened
            if (anyNewFill) time++;
        }

        return time;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {2, 6};  // Initially filled slots
        System.out.println(minTimeToFillSlots(N, arr));  // Output: 2

        int N2 = 10;
        int[] arr2 = {1, 10};  // Output: 5
        System.out.println(minTimeToFillSlots(N2, arr2));
    }
}
