/*
Leap Year Determination
-----------------------
Write a Java program to determine whether a given year is a leap year or not.

The program should:
1. Prompt the user to enter a year as an integer.
2. Check if the year satisfies the leap year conditions:
   - A year is a leap year if it is divisible by 400, or
   - It is divisible by 4 but not divisible by 100.
3. Print "This is a leap year." if the year is a leap year.
4. Print "This is not a leap year." otherwise.

Example:
Input: 2024
Output: This is a leap year.

Input: 1900
Output: This is not a leap year.
*/


import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Year : ");
        int year = sc.nextInt();
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println("This is a leap year .");

        } else {
            System.out.println("This is not a leap year .");

        }
        sc.close();

    }

}
