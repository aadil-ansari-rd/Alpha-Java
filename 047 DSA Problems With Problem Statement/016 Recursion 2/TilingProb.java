/*
Problem Name: Tiling Problem using Recursion
Problem Statement:
-----------------
Write a Java program to solve the Tiling Problem using recursion.

The problem:
Given a 2 x n floor and tiles of size 2 x 1, count the number of ways to 
tile the floor completely.

The program should:
1. Take an integer 'n' representing the length of the floor.
2. Use recursion to calculate the total number of ways to tile the floor.
3. Return the result.

Example:
Input: n = 4
Output: 5
Explanation:
There are 5 ways to tile a 2x4 floor using 2x1 tiles:
- All vertical
- Two vertical + two horizontal
- Horizontal + two vertical + horizontal
- Two horizontal + two vertical
- All horizontal

Recurrence Relation:
tilingWays(n) = tilingWays(n-1) + tilingWays(n-2)
- tilingWays(n-1): Place one tile vertically and solve for remaining (n-1)
- tilingWays(n-2): Place two tiles horizontally and solve for remaining (n-2)
*/


public class TilingProb{

    static int tilingWays(int n){
        if(n==0||n==1)return 1;

        int verticalWays = tilingWays(n-1);
        int horizontalWays = tilingWays(n-2);

        int totalWays = verticalWays + horizontalWays ;
        return totalWays;
    }


    public static void main(String[] args) {
        System.out.println(tilingWays(4));
    }
}