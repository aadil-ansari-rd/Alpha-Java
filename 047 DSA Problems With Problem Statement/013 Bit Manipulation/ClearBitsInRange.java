/*
Problem Name: Clear Bits from i to j
Problem Statement:
-----------------
Write a Java program to clear (set to 0) all bits in an integer from index i 
to index j (inclusive) using bitwise operations.

The program should:
1. Take an integer 'num' and two indices 'i' and 'j'.
2. Clear all bits of 'num' from position i to j.
3. Return the modified integer.

Example:
Input: num = 10 (binary: 1010), i = 2, j = 4
Output: 2 (binary: 0010)
Explanation: Bits from position 2 to 4 are cleared, resulting in 0010.
*/


public class ClearBitsInRange{
    public static int clearBitsInRange(int num , int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        return num & (a|b);
    }
    public static void main(String[] args){
        System.out.println(clearBitsInRange(10, 2, 4));
    }
}