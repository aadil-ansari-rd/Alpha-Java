/*
Problem Name: Print Numbers from N to 1 Using Recursion
Problem Statement:
-----------------
Write a Java program to print numbers from N to 1 using recursion.

The program should:
1. Take an integer 'n' as input.
2. Print numbers from 'n' down to 1, each on a new line.
3. Use a recursive function to achieve this.

Example:
Input: 10
Output:
10
9
8
7
6
5
4
3
2
1

Explanation:
The function recursively prints the current number and then calls itself 
with the next lower number until it reaches 1.
*/


public class NtoOne {
    public static void nToOne(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        nToOne(n-1);
    }
    public static void main(String[] args) {
        nToOne(10);
    }
}
