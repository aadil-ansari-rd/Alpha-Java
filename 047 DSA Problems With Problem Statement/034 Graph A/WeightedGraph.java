/*
Problem: Weighted Undirected Graph Representation

You are required to represent a weighted undirected graph using adjacency lists. Each edge has a source vertex, a destination vertex, and a weight. 

Implement the following:
1. Add an edge between two vertices (undirected) with a given weight.
2. Print the adjacency list of the graph, displaying for each vertex all connected edges in the format: (src, dest, weight).

Example:

Vertices: 4
Edges:
0-1 weight 4
0-2 weight 5
0-3 weight 2
1-3 weight 1
2-3 weight 3

Expected adjacency list output:

Vertex 0: -> (src=0, dest=1, w=4) -> (src=0, dest=2, w=5) -> (src=0, dest=3, w=2)
Vertex 1: -> (src=1, dest=0, w=4) -> (src=1, dest=3, w=1)
Vertex 2: -> (src=2, dest=0, w=5) -> (src=2, dest=3, w=3)
Vertex 3: -> (src=3, dest=0, w=2) -> (src=3, dest=1, w=1) -> (src=3, dest=2, w=3)
*/

import java.util.*;

// Edge with source, destination, and weight
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

public class WeightedGraph {
    int vertices;
    List<List<Edge>> adjList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        // Initialize empty list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest, int weight) {
        Edge e1 = new Edge(src, dest, weight); // src → dest
        Edge e2 = new Edge(dest, src, weight); // dest → src (undirected)

        adjList.get(src).add(e1);
        adjList.get(dest).add(e2);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("-> (src=" + edge.src + ", dest=" + edge.dest + ", w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
    /*          4
            0-------1
            | \     |
           5|  \2   |1
            |    \  |
            2-------3
                3
    */


        WeightedGraph graph = new WeightedGraph(4);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 3);

        graph.printGraph();
    }
}
