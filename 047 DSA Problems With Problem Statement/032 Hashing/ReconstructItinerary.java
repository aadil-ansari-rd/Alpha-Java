/*
Problem Statement: Reconstruct Itinerary (LeetCode L332)

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from "JFK". Hence, the itinerary must begin with "JFK". If there are multiple valid itineraries, return the itinerary that has the smallest lexical order when read as a single string.

You must use all the tickets exactly once.

Example Input:
tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]

Example Output:
["JFK","MUC","LHR","SFO","SJC"]

Example Input 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]

Example Output 2:
["JFK","ATL","JFK","SFO","ATL","SFO"]
*/

import java.util.*;

public class ReconstructItinerary {

    // Adjacency list using min-heap for lexical order
    private Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            flightMap.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        // Start DFS from "JFK"
        dfs("JFK");

        // The result is built in reverse order, so we return it as is
        return itinerary;
    }

    // DFS traversal
    private void dfs(String airport) {
        PriorityQueue<String> destinations = flightMap.get(airport);

        // Visit all destinations from current airport in lexical order
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport);
        }

        // Add airport to the itinerary after visiting all its destinations
        itinerary.addFirst(airport);
    }

    // Main method to test
    public static void main(String[] args) {
        ReconstructItinerary solver = new ReconstructItinerary();

        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );

        List<String> result = solver.findItinerary(tickets);
        System.out.println("Itinerary: " + result); // Output: [JFK, MUC, LHR, SFO, SJC]
    }
}
