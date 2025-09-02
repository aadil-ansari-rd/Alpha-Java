/*
Palindrome Number Check Using Method
------------------------------------
Write a Java program with a method to check whether a given integer is a palindrome.

The program should:
1. Implement a method `isPallindrome(int num)` that returns `true` if the number reads the same forwards and backwards, otherwise returns `false`.
2. Prompt the user to enter an integer number.
3. Call the method and display whether the entered number is a palindrome.

Example:
Input: 121
Output: 121 is a Palindrome Number.

Input: 123
Output: 123 is not a Palindrome Number.
*/



import java.util.Scanner;

public class Ans3 {

    public static boolean isPallindrome(int num) {
        int cpy = num;
        int newNum = 0;
        while (num > 0) {
            int rem = num % 10;
            newNum = newNum * 10 + rem;
            num /= 10;
        }
        if (cpy == newNum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        if (isPallindrome(num)) {
            System.out.println(num + " is a Pallindrome Number.");
        } else {
            System.out.println(num + " is a Pallindrome Number.");

        }
        sc.close();
    }
}
