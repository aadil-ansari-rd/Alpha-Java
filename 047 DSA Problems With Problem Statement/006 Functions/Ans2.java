/*
Check Even Number Using Method
-------------------------------
Write a Java program with a method named `isEven` that checks whether a given integer is even.

The program should:
1. Implement the method `isEven(int n)` that returns `true` if `n` is even, and `false` otherwise.
2. Prompt the user to enter an integer number.
3. Call the `isEven` method with the input and print the result.

Example:
Input: 8
Output: true

Input: 7
Output: false
*/


import java.util.Scanner;

public class Ans2 {
    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.err.println(isEven(n));
        sc.close();
    }
}
