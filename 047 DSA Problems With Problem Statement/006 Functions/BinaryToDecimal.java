/*
Binary to Decimal Conversion Using Method
-----------------------------------------
Write a Java program with a method to convert a binary number into its decimal equivalent.

The program should:
1. Implement a method `binaryToDecimal(long BiNum)` that takes a binary number as input and returns its decimal value.
2. Prompt the user to enter a binary number (consisting of digits 0 and 1).
3. Call the method and display the corresponding decimal number.

Example:
Input: 1011
Output: Decimal of 1011 = 11

Explanation: 1*2^3 + 0*2^2 + 1*2^1 + 1*2^0 = 11
*/


import java.util.Scanner;

public class BinaryToDecimal {

    public static int binaryToDecimal(long BiNum) {
        int dec = 0;
        int pow = 0;
        while (BiNum > 0) {
            int rem = (int)BiNum % 10;
            if (rem == 1) {
                dec = dec + (int) Math.pow(2, pow);

            }
            pow++;
            BiNum/=10;
        }

        return dec;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number : ");
        long BiNum = sc.nextLong();
        System.out.println("Decimal of "+ BiNum + " = "+ binaryToDecimal(BiNum));
        sc.close();
    }
}
