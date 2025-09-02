/*
Shortest Distance from Origin Based on Directions
-------------------------------------------------
Given a sequence of directions (N, S, E, W), calculate the shortest straight-line distance
from the starting point to the ending point.

Approach:
---------
1. Initialize coordinates (x=0, y=0).
2. Loop through the string:
   - 'N' → y++
   - 'S' → y--
   - 'E' → x++
   - 'W' → x--
3. Use the distance formula from origin to (x, y):
   distance = sqrt(x^2 + y^2)
4. Return the distance as float.

Example:
Input: "ns"
Output: 0.0

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class ShortestPath {
    public static float shortestPath(String str){
        int x=0,y=0;
        int n= str.length();
        str=str.toLowerCase();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch=='e'){
                x++;
            }else if(ch=='w'){
                x--;
            }else if(ch=='n'){
                y++;
            }else{
                y--;
            }
        }

        int x2 = x*x;
        int y2 = y*y;
        int x2plusY2 = x2+y2;
        float path = (float) Math.sqrt(x2plusY2);
        return path;
    }
    public static void main(String[] args){
        String path = "ns";
        System.out.println(shortestPath(path));
    }
}
