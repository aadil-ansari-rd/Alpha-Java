/*
Problem: Weighted Undirected Graph BFS Traversal

You are required to represent a weighted undirected graph using adjacency lists. Each edge has a source vertex, a destination vertex, and a weight.

Implement the following:
1. Add an edge between two vertices (undirected) with a given weight.
2. Perform BFS traversal starting from a given vertex and print the order of vertices visited.

Example:

Vertices: 4
Edges:
0-1 weight 4
0-2 weight 5
0-3 weight 2
1-3 weight 1
2-3 weight 3
Start Vertex: 0

Expected BFS Traversal Output:
BFS Traversal: 0 1 2 3
*/

import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class WeightedGraphBFS {
    int vertices;
    List<List<Edge>> adjList;

    public WeightedGraphBFS(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight)); // undirected
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS Traversal: ");

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (Edge edge : adjList.get(curr)) {
                int neighbor = edge.dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

    /*          4
            0-------1
            | \     |
           5|  \2   |1
            |    \  |
            2-------3
                3
    */

        WeightedGraphBFS graph = new WeightedGraphBFS(4);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 3);

        graph.bfs(0);  // Starting from vertex 0
    }
}
