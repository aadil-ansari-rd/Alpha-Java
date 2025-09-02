/*
Problem: Check if a Weighted Undirected Graph is Bipartite

Given a weighted undirected graph, determine whether it is bipartite. A graph is bipartite if its vertices can be divided into two disjoint sets such that every edge connects a vertex from one set to a vertex from the other set.

You are required to:
1. Represent the graph using adjacency lists with edges containing source, destination, and weight.
2. Add edges to the graph.
3. Check if the graph is bipartite using BFS.

Example:

Vertices: 5
Edges:
0-1 weight 4
0-3 weight 3
1-2 weight 2
3-2 weight 1
2-4 weight 5

Expected Output:
Is graph bipartite? true
*/

import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class CheckBipartiteGraph {
    int vertices;
    List<List<Edge>> adj;

    public CheckBipartiteGraph(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(src, dest, weight));
        adj.get(dest).add(new Edge(dest, src, weight)); // Undirected
    }

    public boolean isBipartite() {
        int[] color = new int[vertices];
        Arrays.fill(color, -1); // -1 = unvisited

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, color)) return false;
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0; // Start with color 0

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge edge : adj.get(curr)) {
                int neighbor = edge.dest;

                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[curr]; // Alternate color
                    q.offer(neighbor);
                } else if (color[neighbor] == color[curr]) {
                    return false; // Conflict: same color
                }
            }
        }
        return true;
    }

    // 🔎 Test method
    public static void main(String[] args) {
        CheckBipartiteGraph g = new CheckBipartiteGraph(5);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 3, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(3, 2, 1);
        g.addEdge(2, 4, 5);

        System.out.println("Is graph bipartite? " + g.isBipartite());
    }
}
