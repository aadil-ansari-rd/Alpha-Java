/*
Multiplication Table
--------------------
Write a Java program to print the multiplication table of a given number.

The program should:
1. Prompt the user to enter an integer number.
2. Print the multiplication table of that number from 1 to 10.
3. Each line should follow the format: "number * multiplier = result".

Example:
Input: 5
Output:
  5 * 1 = 5
  5 * 2 = 10
  5 * 3 = 15
  5 * 4 = 20
  5 * 5 = 25
  5 * 6 = 30
  5 * 7 = 35
  5 * 8 = 40
  5 * 9 = 45
  5 * 10 = 50
*/


import java.util.Scanner;

public class Table {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number that you want to calculate the table of : ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + num * i);
        }
        sc.close();

    }

}
