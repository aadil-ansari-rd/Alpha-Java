/*
Problem Name: Increment Without Plus Operator
Problem Statement:
-----------------
Write a Java program to increment an integer by 1 without using the '+' operator.

The program should:
1. Accept an integer as input.
2. Return the value of the integer incremented by 1 using bitwise operations.

Example:
Input: 5
Output: 6

Input: -5
Output: -4

Input: 0
Output: 1

Explanation:
The program uses the bitwise NOT (~) operator in combination with negation 
to achieve the increment operation.
*/


public class Add1ToInt {
    public static int add1ToInt(int num){
        return  -~num;
    }
    public static void main(String[] args) {
        System.out.println(add1ToInt(5));
        System.out.println(add1ToInt(-5));
        System.out.println(add1ToInt(0));

    }
}
