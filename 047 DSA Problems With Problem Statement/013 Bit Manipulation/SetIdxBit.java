/*
Problem Name: Set Bit at Specific Index Using Bitwise
Problem Statement:
-----------------
Write a Java program to set (make 1) the bit at a specific index in an integer 
using bitwise operations.

The program should:
1. Take an integer 'num' and an index 'idx'.
2. Set the bit at position 'idx' to 1.
3. Return the modified integer.

Example:
Input: num = 11 (binary: 1011), idx = 2
Output: 11 (binary: 1011)
Explanation: The bit at index 2 is already 1, so the number remains 11.

Input: num = 8 (binary: 1000), idx = 1
Output: 10 (binary: 1010)
Explanation: The bit at index 1 is set to 1, changing 1000 to 1010.
*/


public class SetIdxBit {

    public static int setIdxBit(int num, int idx) {
        return (num | (1 << idx));
    }

    public static void main(String[] args) {
        System.out.println(setIdxBit(11, 2));
    }
}
