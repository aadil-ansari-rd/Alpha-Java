/*
Scanner Class Input Demonstration
---------------------------------
Write a Java program to demonstrate the usage of the Scanner class for 
reading different types of inputs from the user.

The program should:
1. Read a string input from the user and print it.
2. Read a boolean value from the user and print it.

Example:
Input:
  Hello
  true
Output:
  Hello
  true
*/


import  java.util.*;
public class Scannerr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        System.out.println(num);
        System.out.println(sc.nextBoolean());//Working
        sc.close();
    }
}
