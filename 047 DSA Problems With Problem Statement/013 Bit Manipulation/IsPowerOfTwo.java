/*
Problem Name: Check Power of Two Using Bitwise
Problem Statement:
-----------------
Write a Java program to determine whether a given integer is a power of two 
using bitwise operations.

The program should:
1. Take an integer 'num' as input.
2. Return false if the number is less than or equal to 0.
3. Use the property that a number is a power of two if and only if 
   (num & (num - 1)) == 0.
4. Return true if the number is a power of two, otherwise false.

Example:
Input: 128
Output: true
Explanation: 128 = 2^7, so it is a power of two.

Input: 20
Output: false
Explanation: 20 is not a power of two.
*/


public class IsPowerOfTwo {
    public static boolean  isPowerOfTwo(int num){
        if(num<=0) return  false;
        if((num &(num-1))==0){
            return  true;
        }
        return  false;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(128));
    }
}
