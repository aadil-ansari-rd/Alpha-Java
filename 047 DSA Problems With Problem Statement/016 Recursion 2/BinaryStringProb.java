/*
Problem Name: Generate Binary Strings Without Consecutive 1s
Problem Statement:
-----------------
Write a Java program to generate all binary strings of length N such that no two consecutive 1s appear in the string.

The program should:
1. Take an integer 'num' representing the length of the binary string.
2. Use recursion to generate all valid binary strings.
3. Ensure that no two 1s are adjacent in any string.
4. Print each valid binary string.

Example:
Input: num = 3
Output:
000
001
010
100
101

Explanation:
The recursive function appends '0' in all cases.
It appends '1' only if the last digit added was '0' to avoid consecutive 1s.
*/


public class BinaryStringProb{
    public static void binaryStrings(int num , String str , int lastDigit){

        if(num==0){
            System.out.println(str);
            return;
        }

        //Add 0 in all cases
        binaryStrings(num-1, str+"0",0);
        if(lastDigit==0){
            binaryStrings(num-1, str+"1", 1);
        }
    }
    public static void main(String[] args){
        binaryStrings(3, "",0);
    }
}