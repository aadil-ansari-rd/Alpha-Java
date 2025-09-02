/*
Problem: Representing a Weighted Graph with Multiple Components

You are given a weighted undirected graph consisting of three disconnected components. Each edge is defined by a triplet {source, destination, weight}. The task is to represent the graph as an adjacency list or edge list and visualize its components.

Graph Components:

Component 1:
Vertices: 0, 1, 2
Edges:
0 --1--> 1 weight 4
1 --2--> 2 weight 7
0 --2--> 2 weight 1 (if included)

Component 2:
Vertices: 3, 4, 5, 6
Edges:
3 --4--> 4 weight 2
3 --6--> 6 weight 1
4 --5--> 5 weight 3
5 --6--> 6 weight 5
3 --5--> 5 weight 6 (diagonal)

Component 3:
Vertices: 7, 8, 9
Edges:
7 --8--> 8 weight 8
8 --9--> 9 weight 2
9 --7--> 7 weight 9

Example Input (as array of edges):
int[][] edges = {
    {0, 1, 4}, {1, 2, 7},
    {3, 4, 2}, {3, 6, 1}, {4, 5, 3}, {5, 6, 5}, {3, 5, 6},
    {7, 8, 8}, {8, 9, 2}, {9, 7, 9}
};

Expected Output:
- A representation of all three components with their vertices and weighted edges.
- Optional: visual diagram showing connectivity and edge weights for each component.
*/

public class GraphDiagram {


int[][] edges = {
    // Component 1
    {0, 1, 4},
    {1, 2, 7},

    // Component 2
    {3, 4, 2},
    {3, 6, 1},
    {4, 5, 3},
    {5, 6, 5},
    {3, 5, 6},  // Diagonal

    // Component 3
    {7, 8, 8},
    {8, 9, 2},
    {9, 7, 9}
};


    
//   Component 1:        Component 2:         Component 3:
//
//                            2
//   0                   3 ------- 4               7
//   |                   |  \      |              / \
//  4|                  1|    \6   |3           9/   \8
//   |                   |      \  |            /     \
//   1 ------- 2         6 ------- 5           9-------8
//        7                   5                    2
//        


// ............................................................
// ...Component-1.........Component-2...........Component-3....
// ............................................................
// ............................2...............................
// ...0...................3_________4...............7..........
// ...|...................|..\......|............../.\.........
// ..4|..................1|....\6...|3...........9/...\8.......
// ...|...................|......\..|............/.....\.......
// ...1________2..........6_________5...........9_______8......
// ........7...................5....................2..........
// ............................................................



}


