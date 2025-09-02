/*
Problem Name: Check Even Using Bitwise
Problem Statement:
-----------------
Write a Java program to determine whether a given integer is even using 
bitwise operations.

The program should:
1. Take an integer 'num' as input.
2. Use the bitwise AND operator to check the least significant bit.
3. Return true if the number is even, otherwise return false.

Example:
Input: 20
Output: true
Explanation: 20 in binary is 10100, the least significant bit is 0, so it is even.

Input: 15
Output: false
Explanation: 15 in binary is 1111, the least significant bit is 1, so it is odd.
*/


public class IsEven {
    public static boolean isEven(int num){
        if((num&1)==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isEven(20));   
    }
}
