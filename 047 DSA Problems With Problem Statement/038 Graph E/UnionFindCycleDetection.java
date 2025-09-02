/*
Union-Find (Disjoint Set) Approach for Cycle Detection in an Undirected Graph

Problem:
Given an undirected graph, detect whether it contains a cycle.

Approach:
1. Initialize a parent array for all vertices with -1 (each vertex is its own set).
2. For each edge (u, v):
   - Find roots of u and v using path compression.
   - If roots are same → cycle detected.
   - Otherwise, union the sets.
3. If all edges processed without root conflict → no cycle.

Example:
Graph edges: {0-1, 1-2, 2-0}
Output: Graph contains cycle: true

Key Points:
- Path compression optimizes the find operation.
- Union merges two sets, preventing cycle formation detection.
- Efficient for sparse graphs.
*/

import java.util.*;

public class UnionFindCycleDetection {

    // Find with path compression
    private static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) return vertex;
        parent[vertex] = find(parent, parent[vertex]); // path compression
        return parent[vertex];
    }

    // Union operation
    private static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }

    // Function to check for cycle
    public static boolean containsCycle(int V, int[][] edges) {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int uRoot = find(parent, u);
            int vRoot = find(parent, v);

            if (uRoot == vRoot) {
                return true; // cycle detected
            }
            union(parent, uRoot, vRoot);
        }
        return false; // no cycle
    }

    // Main method for testing
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0} // This edge creates a cycle
        };

        boolean hasCycle = containsCycle(V, edges);
        System.out.println("Graph contains cycle: " + hasCycle);
    }
}
