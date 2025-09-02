/*
Decimal to Binary Conversion Using Method
-----------------------------------------
Write a Java program with a method to convert a decimal number into its binary equivalent.

The program should:
1. Implement a method `decimalToBinary(int DecNum)` that takes a decimal integer as input and returns its binary representation as a long integer.
2. Prompt the user to enter a decimal number.
3. Call the method and display the corresponding binary number.

Example:
Input: 13
Output: Binary Number of 13 is : 1101

Explanation: 13 in decimal = 1101 in binary.
*/


import java.util.Scanner;

public class DecimalToBinary {

    public static long decimalToBinary(int DecNum) {
        int BiNum = 0;
        int pow = 0;
        while (DecNum > 0) {
            int rem = DecNum % 2;
            if (rem == 1) {
                BiNum = BiNum + (int)Math.pow(10, pow);

            }
            pow++;
            DecNum/=2;
        }
        return  BiNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number : ");
        int DecNum = sc.nextInt();
        System.out.println("Binary Number of " + DecNum + " is : " + decimalToBinary(DecNum));
        sc.close();
    }

}
