/*
Problem Name: Count Set Bits
Problem Statement:
-----------------
Write a Java program to count the number of set bits (1s) in the binary 
representation of a given non-negative integer.

The program should:
1. Take an integer 'n' as input.
2. Iterate through each bit of 'n'.
3. Count how many bits are set to 1.
4. Return the count.

Example:
Input: 5 (binary: 101)
Output: 2
Explanation: The binary representation of 5 has two set bits.
*/

public class CountSetBits {
    public static  int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n= n>>1;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSetBits(5));
    }
}
