/*
Sum of Two Integers
-------------------
Write a Java program to calculate the sum of two integers.

The program should:
1. Prompt the user to enter the value of 'a'.
2. Prompt the user to enter the value of 'b'.
3. Compute the sum of a and b using the formula: Sum = a + b.
4. Display the result.

Example:
Input:
  a = 7
  b = 3
Output:
  Sum of a & b : 10
*/


import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Value of a = ");
        int a = sc.nextInt();
        System.out.println("Value of b = ");
        int b = sc.nextInt();
        System.out.println("Sum of a & b : " + (a+b));
        sc.close();

    }

}
