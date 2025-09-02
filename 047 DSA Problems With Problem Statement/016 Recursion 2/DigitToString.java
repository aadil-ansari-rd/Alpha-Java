/*
Problem Name: Convert Integer Digits to Words
Problem Statement:
-----------------
Write a Java program to convert the digits of a given integer into their 
corresponding English words using recursion.

The program should:
1. Take an integer 'num' as input.
2. Recursively process each digit from the most significant to the least significant.
3. Print each digit as its corresponding word (e.g., 0 → "Zero", 1 → "One", etc.).
4. Ignore leading zeros in the number.

Example:
Input: 19896
Output: One Nine Eight Nine Six

Explanation:
The recursive function divides the number by 10 to process higher digits first 
and then prints the English word for the last digit.
*/


public class DigitToString {
    static String[] str = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    public static void digitToString(int num) {
        if (num == 0) {
            return;
        }
        digitToString(num / 10);
        int lastDigit = num % 10;
        System.out.print(str[lastDigit]);
    }

    public static void main(String[] args) {
        digitToString(19896); // 0 can not come at the begining of the number
    }
}
