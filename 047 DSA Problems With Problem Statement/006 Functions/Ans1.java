/*
Average of Three Integers Using Method
--------------------------------------
Write a Java program with a method to compute the average of three integers.

The program should:
1. Implement a method `avg3(int a, int b, int c)` that takes three integer inputs and returns their average as a float.
2. Prompt the user to enter three integer numbers.
3. Call the method with the input numbers and display the calculated average.

Example:
Input: 5 10 15
Output: Average of the given three numbers are : 10.0
*/


import java.util.Scanner;

public class Ans1 {
    public static float  avg3(int a , int b , int c ){
        return (a+b+c)/3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Average of the given three numbers are : " + avg3(a, b, c));
        sc.close();
    }
}
