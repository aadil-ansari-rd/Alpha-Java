/*
Problem: Cycle Detection in Directed Weighted Graph using DFS

Given a weighted directed graph, determine whether the graph contains any cycle. A cycle exists if there is a path starting and ending at the same vertex following the direction of edges.

You are required to:
1. Represent the graph using adjacency lists with edges containing source, destination, and weight.
2. Add directed edges to the graph.
3. Detect cycles in the graph using DFS and a recursion stack.

Example:

Vertices: 5
Edges:
0 → 1 weight 2
0 → 2 weight 3
1 → 3 weight 1
2 → 4 weight 4
4 → 3 weight 2

Expected Output (No cycle):
Has Cycle? false

If an edge 3 → 2 weight 5 is added:

Expected Output (Cycle exists):
Has Cycle? true
*/

import java.util.*;

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class DirectedGraphCycleDetect {
    int vertices;
    List<List<Edge>> adjList;

    public DirectedGraphCycleDetect(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight)); // Directed edge
    }

    public boolean dfs() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsUtil(int curr, boolean[] visited, boolean[] recStack) {
        visited[curr] = true;
        recStack[curr] = true;

        for (Edge edge : adjList.get(curr)) {
            int neighbor = edge.dest;

            if (!visited[neighbor]) {
                if (dfsUtil(neighbor, visited, recStack)) return true;
            } else if (recStack[neighbor]) {
                return true; // Found back edge → cycle
            }
        }

        recStack[curr] = false; // Remove from recursion stack
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycleDetect graph = new DirectedGraphCycleDetect(5);

        // Build sample graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 4);
        graph.addEdge(4, 3, 2);
        // Uncomment below to create a cycle:
        // graph.addEdge(3, 2, 5); // 3 → 2 creates cycle

        System.out.println("Has Cycle? " + graph.dfs());
    }
}
