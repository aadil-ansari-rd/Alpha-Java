/*
Problem Statement: Topological Sort of a Directed Weighted Graph

You are given a directed weighted graph represented as a set of vertices and directed edges. Implement a program to perform a topological sort of the vertices using DFS.

Functionalities:
1. Add a directed edge with a weight from a source vertex to a destination vertex.
2. Perform a topological sort of all vertices in the graph and print the order.

Example:

Input:
Vertices = 6
Edges = [
    {5, 2, 1},
    {5, 0, 2},
    {4, 0, 3},
    {4, 1, 2},
    {2, 3, 1},
    {3, 1, 4}
]

Operation:
- Topological Sort

Output:
Topological Sort: 5 4 2 3 1 0
*/

import java.util.*;

// Edge class with source, destination, and weight
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

public class TopoSortDirectedWeighted {
    int vertices;
    List<List<Edge>> adjList;

    public TopoSortDirectedWeighted(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
    }

    // Add directed edge with weight
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
    }

    // 🔄 Topological Sort using DFS
    public void topologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void dfs(int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for (Edge edge : adjList.get(curr)) {
            if (!visited[edge.dest]) {
                dfs(edge.dest, visited, stack);
            }
        }

        stack.push(curr); // Push after visiting all neighbors
    }

    // 🔍 Test Method
    public static void main(String[] args) {
        TopoSortDirectedWeighted g = new TopoSortDirectedWeighted(6);

        g.addEdge(5, 2, 1);
        g.addEdge(5, 0, 2);
        g.addEdge(4, 0, 3);
        g.addEdge(4, 1, 2);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 4);

        g.topologicalSort();
    }
}
