/*
Product of Two Integers
-----------------------
Write a Java program to calculate the product of two integers.

The program should:
1. Prompt the user to enter the value of 'a'.
2. Prompt the user to enter the value of 'b'.
3. Compute the product of a and b using the formula: Product = a * b.
4. Display the result.

Example:
Input:
  a = 4
  b = 5
Output:
  Product of a & b = 20
*/


import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.println("Value of a = ");
        int a = sc.nextInt();
        System.out.println("Value of b = ");
        int b = sc.nextInt();
        System.out.println("Product of a & b =" + (a*b));
        sc.close();

    }
}
