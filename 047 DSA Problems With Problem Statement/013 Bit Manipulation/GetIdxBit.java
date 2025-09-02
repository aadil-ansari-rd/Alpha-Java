/*
Problem Name: Get Bit at Index
Problem Statement:
-----------------
Write a Java program to get the value of a bit at a specific index in an integer 
using bitwise operations.

The program should:
1. Take an integer 'num' and an index 'idx'.
2. Return the value of the bit at position 'idx' (0 or 1).

Example:
Input: num = 15 (binary: 1111), idx = 0
Output: 1
Explanation: The bit at index 0 in 1111 is 1.
*/


public class GetIdxBit {
    public static int getIdxBit(int num , int idx){
        return  (num & (1<<idx))>>idx;
    }
    public static void main(String[] args) {
        System.out.println(getIdxBit(15, 0));
    }
}
