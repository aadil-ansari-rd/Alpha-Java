/*
Circle Area Calculation
-----------------------
Write a program to calculate the area of a circle.

The program should:
1. Prompt the user to enter the radius of a circle.
2. Read the radius as input.
3. Compute the area of the circle using the formula: Area = π * radius * radius.
   (Use π = 3.14 for calculation).
4. Print the calculated area as output.

Example:
Input: 5
Output: Area of Circle = 78.5
*/

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle");
        float rad = sc.nextFloat();
        System.out.println("Area of Circle = " + (3.14*rad*rad));
        sc.close();
    }    
} 
