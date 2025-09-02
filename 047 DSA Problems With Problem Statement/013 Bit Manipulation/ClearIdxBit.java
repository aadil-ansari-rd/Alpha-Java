/*
Problem Name: Clear Specific Bit
Problem Statement:
-----------------
Write a Java program to clear (set to 0) the bit at a specific index in an integer 
using bitwise operations.

The program should:
1. Take an integer 'num' and an index 'idx'.
2. Clear the bit at position 'idx' in 'num'.
3. Return the modified integer.

Example:
Input: num = 10 (binary: 1010), idx = 1
Output: 8 (binary: 1000)
Explanation: The bit at index 1 is cleared, changing 1010 to 1000.
*/


public class ClearIdxBit {
    public static int clearIdxBit(int num , int idx){
        return num & (~(1<<idx));
    }
    public static void main(String[] args ){
        System.out.println(clearIdxBit(10,1));
    }
}
