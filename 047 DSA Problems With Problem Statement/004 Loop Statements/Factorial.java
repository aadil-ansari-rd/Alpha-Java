/*
Factorial Calculation
---------------------
Write a Java program to calculate the factorial of a given non-negative integer.

The program should:
1. Prompt the user to enter an integer number.
2. Compute the factorial using a loop. Factorial of a number n is defined as:
     n! = 1 * 2 * 3 * ... * n
     (For n = 0, factorial is 1)
3. Display the calculated factorial.

Example:
Input: 5
Output: Factorial of the given number is : 120
*/

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of the given number is : " + fact);
        sc.close();

    }

}
