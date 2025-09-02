/*
Problem Statement: Topological Sort using BFS (Kahn's Algorithm)

Given a directed acyclic graph (DAG) with V vertices and a list of edges, return one possible topological ordering of the vertices. Topological ordering of a DAG is a linear ordering of vertices such that for every directed edge u → v, vertex u comes before vertex v in the ordering. If the graph contains a cycle, topological sort is not possible.

Example 1:
Input: V = 6, edges = [[5,0],[4,0],[5,2],[2,3],[3,1],[4,1]]
Output: [4,5,0,2,3,1] or [5,4,2,3,1,0]
Explanation: There may be multiple valid topological orders.

Example 2:
Input: V = 4, edges = [[0,1],[0,2],[1,2],[2,3]]
Output: [0,1,2,3]
Explanation: Only one valid topological order exists.

Constraints:
- 1 <= V <= 10^4
- 0 <= number of edges <= 10^5
- The graph is directed and may contain cycles; if a cycle exists, topological sort is not possible.
*/

import java.util.*;

// Edge class for weighted graph support (if needed)
class Edge {
    int src, dest;
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

public class TopoSortBFS {
    // 🔧 Function to perform topological sort using BFS (Kahn's Algorithm)
    public static List<Integer> topoSort(int V, List<Edge> edges) {
        // Step 1: Build Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (Edge e : edges) graph.get(e.src).add(e.dest);

        // Step 2: Calculate indegree of each node
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        // Step 3: Add all 0-indegree nodes to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // Step 4: Process queue and build result
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        // Optional: Check for cycle
        if (topoOrder.size() != V) {
            throw new RuntimeException("Cycle detected. Topological sort not possible.");
        }

        return topoOrder;
    }

    // 🔍 Sample usage
    public static void main(String[] args) {
        int V = 6;
        List<Edge> edges = Arrays.asList(
            new Edge(5, 0),
            new Edge(4, 0),
            new Edge(5, 2),
            new Edge(2, 3),
            new Edge(3, 1),
            new Edge(4, 1)
        );

        List<Integer> result = topoSort(V, edges);
        System.out.println("Topological Sort: " + result);
    }
}
