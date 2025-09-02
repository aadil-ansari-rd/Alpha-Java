/*
Problem Name: Uppercase to Lowercase and Vice Versa Using Bitwise
Problem Statement:
-----------------
Write a Java program to convert uppercase letters to lowercase and lowercase 
letters to uppercase using bitwise operations.

The program should:
1. Print all uppercase letters from 'A' to 'Z' converted to lowercase.
2. Print all lowercase letters from 'a' to 'z' converted to uppercase.
3. Use bitwise OR ('|') and AND ('&') operations with appropriate masks 
   instead of built-in functions.

Example Output:
Uppercase to Lowercase.....
a b c d e f g h i j k l m n o p q r s t u v w x y z

Lowercase to Uppercase.....
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

Explanation:
- 'i | ' '' converts uppercase to lowercase.
- 'i & '_'' converts lowercase to uppercase.
*/


public class UpperCasetoLowerCase {

    public static void main(String[] args) {
        System.out.println("Uppercase to Lowercase.....");
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print((char) (i | ' '));
        }
        System.out.println();
        System.out.println();
        System.out.println("Lowercase to Uppercase.....");
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print((char) (i & '_'));
        }
    }
}
