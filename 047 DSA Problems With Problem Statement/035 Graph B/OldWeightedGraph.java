/*
Problem Statement: Graph Traversals and Path Detection in Weighted Undirected Graph

You are given a weighted undirected graph represented as a list of vertices and edges. Implement a graph data structure with the following functionalities:

1. Add an edge between two vertices with a given weight.
2. Print the adjacency list of the graph showing all connected vertices and edge weights.
3. Perform BFS (Breadth-First Search) traversal starting from a given vertex.
4. Perform DFS (Depth-First Search) traversal starting from a given vertex.
5. Check if there exists a path between two given vertices.

Example:

Input:
Vertices = 4
Edges = [
    {0, 1, 4},
    {0, 2, 5},
    {0, 3, 2},
    {1, 3, 1},
    {2, 3, 3}
]

Operations:
- Print Graph
- BFS Traversal starting from vertex 0
- DFS Traversal starting from vertex 0
- Check if a path exists from vertex 1 to vertex 3

Output:
Graph adjacency list:
Vertex 0 : -> ( Src : 0, Dest : 1, Weight : 4 ) -> ( Src : 0, Dest : 2, Weight : 5 ) -> ( Src : 0, Dest : 3, Weight : 2 )
Vertex 1 : -> ( Src : 1, Dest : 0, Weight : 4 ) -> ( Src : 1, Dest : 3, Weight : 1 )
Vertex 2 : -> ( Src : 2, Dest : 0, Weight : 5 ) -> ( Src : 2, Dest : 3, Weight : 3 )
Vertex 3 : -> ( Src : 3, Dest : 0, Weight : 2 ) -> ( Src : 3, Dest : 1, Weight : 1 ) -> ( Src : 3, Dest : 2, Weight : 3 )

BFS Traversal: 0 1 2 3
DFS Traversal: 0 1 3 2
Path exists from 1 to 3: true
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

public class OldWeightedGraph {
    int vertices;
    List<List<Edge>> adjList;

    public OldWeightedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        // Initialize empty list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest, int weight) {
        Edge e1 = new Edge(src, dest, weight);
        Edge e2 = new Edge(dest, src, weight);
        adjList.get(src).add(e1);
        adjList.get(dest).add(e2);
    }

    // Print the Graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " : ");
            for (Edge ver : adjList.get(i)) {
                System.out.print(" -> ( Src : " + ver.src + ", Dest : " + ver.dest + ", Weight : " + ver.weight + " )");
            }
            System.out.println();
        }
    }

    // BFS Traversal
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        System.out.print("BFS Traversal : ");
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Edge ed : adjList.get(curr)) {
                int neighbor = ed.dest;
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    // DFS Traversal
    public void dfs(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (Edge ed : adjList.get(curr)) {
            int neighbor = ed.dest;
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    // Has Path
    public boolean hasPath (int src , int dest){
        if(src>vertices) return false ;
        return hasPathHelper(src, dest, new boolean[vertices]);
    }
    private boolean hasPathHelper(int curr , int dest, boolean[] visited){
        visited[curr]= true;
        if(curr == dest )return true;
        for(Edge ed : adjList.get(curr)){
            int neighbor = ed.dest;
            if(!visited[neighbor]){
                return hasPathHelper(neighbor, dest, visited);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        OldWeightedGraph graph = new OldWeightedGraph(4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 3);

        graph.printGraph();
        graph.bfs(0);
        System.out.println();
        System.out.print("DFS Traversal : ");
        graph.dfs(0, new boolean[graph.vertices]);
        System.out.println();
        int src = 1 , dest =3;
        System.err.println("A path form " + src + " to " + dest + " exist :" + graph.hasPath(src , dest));
    }
}