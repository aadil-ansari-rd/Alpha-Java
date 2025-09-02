/*
Maximum Length Chain of Pairs

Problem Statement:
Given a set of pairs of numbers, a pair (a, b) can follow another pair (c, d) 
if b < c. The task is to find the length of the longest chain which can be 
formed from a given set of pairs.

Example 1:
Input: pairs = [(5,24), (15,25), (27,40), (50,60)]
Output: 3
Explanation: The longest chain is (5,24) -> (27,40) -> (50,60).

Example 2:
Input: pairs = [(1,2), (2,3), (3,4)]
Output: 2
Explanation: The longest chain is (1,2) -> (3,4).

Example 3:
Input: pairs = [(10,20), (1,2), (2,30)]
Output: 2
Explanation: The longest chain is (1,2) -> (10,20).
*/

import java.util.Arrays;

public class MaxLengthChain {
    // Pair class for convenience
    static class Pair implements Comparable<Pair> {
        int start, end;
        Pair(int a, int b) {
            start = a;
            end = b;
        }

        // Sort based on end time
        public int compareTo(Pair other) {
            return this.end - other.end;
        }
    }

    // Method to get maximum chain length
    public static int maxChainLength(Pair[] pairs) {
        Arrays.sort(pairs); // Step 1: sort by end time
        int chainLength = 1;
        int lastEnd = pairs[0].end;

        // Step 2: iterate through sorted pairs
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].start > lastEnd) {
                chainLength++;
                lastEnd = pairs[i].end;
            }
        }
        return chainLength;
    }

    public static void main(String[] args) {
        Pair[] pairs = { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
        System.out.println("Maximum Chain Length: " + maxChainLength(pairs));
    }
}
