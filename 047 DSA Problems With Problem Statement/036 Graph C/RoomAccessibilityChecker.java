/*
Problem Statement: Keys and Rooms (LeetCode 841)

You are given a list of rooms, where rooms[i] contains the list of keys in room i. Each key is an integer representing another room. Initially, you are in room 0. Determine if you can visit all rooms.

Example 1:
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: Start in room 0 with key 1 → go to room 1 with key 2 → go to room 2 with key 3 → go to room 3. All rooms are visited.

Example 2:
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: Room 2 cannot be visited.
*/

import java.util.*;

public class RoomAccessibilityChecker {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(0, rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }

    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        for (int neighborRoom : rooms.get(currentRoom)) {
            if (!visited[neighborRoom]) {
                visited[neighborRoom] = true;
                dfs(neighborRoom, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        RoomAccessibilityChecker checker = new RoomAccessibilityChecker();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        boolean result = checker.canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + result); // Output: true
    }
}
