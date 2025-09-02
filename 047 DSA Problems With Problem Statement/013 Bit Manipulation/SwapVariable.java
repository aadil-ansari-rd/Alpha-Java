/*
Problem Name: Swap Two Integers Using XOR
Problem Statement:
-----------------
Write a Java program to swap two integers without using a temporary variable, 
using bitwise XOR operations.

The program should:
1. Take two integers 'n' and 'm'.
2. Swap their values using the XOR (^) operator.
3. Print the values before and after the swap.

Example:
Input: n = 3, m = 4
Output:
Variables before swap :- 
First Number : 3 , Second Number : 4
Variables after swap :-
First Number : 4 , Second Number : 3

Explanation:
The XOR operator allows swapping two numbers without using extra space.
*/


public class SwapVariable {

    public static void swap(int n, int m) {
        System.out.println("Variables before swap :- ");
        System.out.println("First Number : " + n + " , Second Number : " + m);
        n = n ^ m;
        m = n ^ m;
        n = n ^ m;
        System.out.println("First Number : " + n + " , Second Number : " + m);

    }

    public static void main(String[] args) {
        swap(3, 4);
    }
}
