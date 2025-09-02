/*
Problem Name: Print Numbers from 1 to N Using Recursion
Problem Statement:
-----------------
Write a Java program to print numbers from 1 to N using recursion.

The program should:
1. Take an integer 'n' as input.
2. Print numbers from 1 up to 'n', each on a new line.
3. Use a recursive function to achieve this.

Example:
Input: 10
Output:
1
2
3
4
5
6
7
8
9
10

Explanation:
The recursive function first calls itself with n-1, 
and then prints the current number, ensuring numbers 
are printed in ascending order.
*/


public class OneToN{
    public static void oneToN(int n){
        if(n<1){
            return ;
        }
        oneToN(n-1);
        System.out.println(n);
    }
    public static void main(String[] args){
        oneToN(10);
    }

}