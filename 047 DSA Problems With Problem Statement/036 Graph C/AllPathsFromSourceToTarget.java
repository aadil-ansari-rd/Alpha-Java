/*
Problem Statement: All Paths from Source to Target (LeetCode 797)

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n-1, find all possible paths from node 0 (source) to node n-1 (target). The graph is given as an adjacency list, where graph[i] is a list of all nodes j such that there is a directed edge from node i to node j.

Example:

Input:
graph = [[1,2],[3],[3],[]]

Output:
[
  [0,1,3],
  [0,2,3]
]

Explanation:
There are two paths from node 0 to node 3: 0→1→3 and 0→2→3.
*/

import java.util.*;

public class AllPathsFromSourceToTarget {

    // 🔧 Main function to find all paths from 0 to n-1
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(0, graph, currentPath, result);
        return result;
    }

    // 🔁 Recursive DFS function
    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        path.add(node); // Add current node to path

        // ✅ If we reached the target node, save the path
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            // 🔁 Recurse on all neighbors
            for (int neighbor : graph[node]) {
                dfs(neighbor, graph, path, result);
            }
        }

        // 🔙 Backtrack - remove current node before returning
        path.remove(path.size() - 1);
    }

    // 🧪 Driver code to test the implementation
    public static void main(String[] args) {
        // 📘 Input graph: adjacency list form
        int[][] graph = {
            {1, 2},  // Node 0 → 1 and 2
            {3},     // Node 1 → 3
            {3},     // Node 2 → 3
            {}       // Node 3 → no outgoing edges
        };

        // 🎯 Find all paths from node 0 to node 3
        AllPathsFromSourceToTarget solver = new AllPathsFromSourceToTarget();
        List<List<Integer>> allPaths = solver.allPathsSourceTarget(graph);

        // 🖨️ Print all paths
        System.out.println("All Paths from Source to Target:");
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }
    }
}
