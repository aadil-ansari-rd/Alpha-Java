/*
Problem Statement: Alien Dictionary Character Order

Given a sorted dictionary of an alien language with N words, and total K unique characters, determine a valid order of characters in the language.

Input:
- words[]: Array of strings sorted lexicographically in the alien language
- N: Number of words
- K: Number of unique characters (assume lowercase 'a' to 'z')

Output:
- One possible string representing character order
- Empty string if cycle exists (no valid order)

Algorithm:
1. Compare adjacent words to find first differing character → create directed edge (from → to).
2. Build adjacency list for K characters.
3. Compute in-degree for each node.
4. Perform Kahn's BFS-based topological sort:
   - Add all 0 in-degree characters to queue
   - Process queue and reduce in-degree of neighbors
5. If topological order contains all K characters, return it; else return "" (cycle exists).

Example:
Input: words = {"baa","abcd","abca","cab","cad"}, N=5, K=4
Output: One possible order of characters: "bdac"
*/

import java.util.*;

public class AlienDictionary {

    // Function to find one valid order of characters
    public static String findOrder(String[] words, int N, int K) {
        // Step 1: Build adjacency list for characters
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < K; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int from = word1.charAt(j) - 'a';
                    int to = word2.charAt(j) - 'a';
                    graph.get(from).add(to); // Edge: from -> to
                    break; // Only first differing character counts
                }
            }
        }

        // Step 2: Compute in-degree of each node
        int[] indegree = new int[K];
        for (int u = 0; u < K; u++) {
            for (int v : graph.get(u)) indegree[v]++;
        }

        // Step 3: BFS / Kahn's topological sort
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) if (indegree[i] == 0) q.add(i);

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.append((char)(u + 'a'));

            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        // Step 4: Check for cycle
        if (order.length() != K) return ""; // cycle exists

        return order.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] words = {"baa","abcd","abca","cab","cad"};
        int N = words.length;
        int K = 4;

        String order = findOrder(words, N, K);
        System.out.println("One possible order of characters: " + order);
    }
}
