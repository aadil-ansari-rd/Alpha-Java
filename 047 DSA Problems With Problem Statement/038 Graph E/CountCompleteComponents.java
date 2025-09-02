/*
Problem: Count the number of complete components in an undirected graph.

Approach:
1. Build adjacency list for all nodes.
2. Use DFS to explore each connected component:
   - Count number of nodes and sum of degrees (edgeCount).
3. For each component, actualEdges = edgeCount / 2 (each edge counted twice).
4. A complete component satisfies: actualEdges == n * (n-1)/2.
5. Increment result if the component is complete.

Example:
n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Components:
- {0,1,2} complete -> 1
- {3,4} complete -> 1
- {5} alone -> 1
Output: 3
*/

import java.util.*;

public class CountCompleteComponents {

    // DFS to explore a component and count nodes & edges
    private static void dfs(int node, boolean[] visited, List<List<Integer>> graph, int[] nodeCount, int[] edgeCount) {
        visited[node] = true;
        nodeCount[0]++; // count nodes
        edgeCount[0] += graph.get(node).size(); // sum degrees

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph, nodeCount, edgeCount);
            }
        }
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        // Step 2: Process each component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] nodeCount = {0};
                int[] edgeCount = {0};

                dfs(i, visited, graph, nodeCount, edgeCount);

                // Each edge counted twice in degrees, so divide by 2
                int actualEdges = edgeCount[0] / 2;
                int expectedEdges = nodeCount[0] * (nodeCount[0] - 1) / 2;

                if (actualEdges == expectedEdges) {
                    result++; // this component is complete
                }
            }
        }

        return result;
    }

    // Driver
    public static void main(String[] args) {
        int n1 = 6;
        int[][] edges1 = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(countCompleteComponents(n1, edges1)); // Output: 3

        int n2 = 6;
        int[][] edges2 = {{0,1},{0,2},{1,2},{3,4},{4,5}};
        System.out.println(countCompleteComponents(n2, edges2)); // Output: 1
    }
}
