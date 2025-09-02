/*
Topological Sort of Items by Groups (Java):

Problem: Sort items given group dependencies and item dependencies. Ungrouped items get unique group IDs.

Approach:
1. Assign unique group IDs to ungrouped items.
2. Build two graphs:
   - Group graph (dependencies between groups)
   - Item graph (dependencies between items)
3. Perform Kahn's algorithm (topological sort) on both graphs.
4. Arrange items in order of groups, preserving item-level dependencies.
5. Return final sorted list or empty if cycle detected.

Example Input:
n = 8, m = 2
group = [-1,-1,1,0,0,1,0,-1]
beforeItems = [[],[6],[5],[6],[3,6],[],[ ],[]]

Expected Output:
[6,3,4,5,2,0,7,1]
*/

import java.util.*;

public class SortItemsByGroups {
    
    // Function for Topological Sort using Kahn’s Algorithm
    private static List<Integer> topoSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        // Start with nodes having 0 indegree
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int neigh : graph.getOrDefault(node, new ArrayList<>())) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) q.add(neigh);
            }
        }
        
        return result.size() == indegree.length ? result : new ArrayList<>();
    }
    
    public static List<Integer> sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Step 1: Assign unique group IDs to ungrouped items
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = m++;
        }
        
        // Step 2: Build group and item graphs
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] groupIndegree = new int[m];
        int[] itemIndegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            groupGraph.putIfAbsent(group[i], new ArrayList<>());
            itemGraph.putIfAbsent(i, new ArrayList<>());
        }
        
        // Build edges
        for (int i = 0; i < n; i++) {
            for (int pre : beforeItems.get(i)) {
                itemGraph.get(pre).add(i);
                itemIndegree[i]++;
                
                if (group[i] != group[pre]) {
                    groupGraph.get(group[pre]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        
        // Step 3: Topo sort for groups and items
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree);
        
        if (groupOrder.isEmpty() || itemOrder.isEmpty()) return new ArrayList<>();
        
        // Step 4: Arrange items based on group order
        Map<Integer, List<Integer>> groupedItems = new HashMap<>();
        for (int item : itemOrder) {
            groupedItems.computeIfAbsent(group[item], x -> new ArrayList<>()).add(item);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int g : groupOrder) {
            result.addAll(groupedItems.getOrDefault(g, new ArrayList<>()));
        }
        
        return result;
    }
    
    // 🔥 Main function to test
    public static void main(String[] args) {
        int n = 8, m = 2;
        int[] group = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(Arrays.asList());       // item 0
        beforeItems.add(Arrays.asList(6));     // item 1
        beforeItems.add(Arrays.asList(5));     // item 2
        beforeItems.add(Arrays.asList(6));     // item 3
        beforeItems.add(Arrays.asList(3,6));   // item 4
        beforeItems.add(Arrays.asList());      // item 5
        beforeItems.add(Arrays.asList());      // item 6
        beforeItems.add(Arrays.asList());      // item 7
        
        List<Integer> result = sortItems(n, m, group, beforeItems);
        System.out.println(result); // Expected Output: [6,3,4,5,2,0,7,1]
    }
}
