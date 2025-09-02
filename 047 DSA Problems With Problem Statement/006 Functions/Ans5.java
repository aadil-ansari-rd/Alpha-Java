/*
Sum of Digits Using Method
--------------------------
Write a Java program with a method to compute the sum of the digits of a given integer.

The program should:
1. Implement a method `digitSum(int n)` that calculates and returns the sum of all digits of `n`.
2. Prompt the user to enter an integer number.
3. Call the method and display the sum of its digits.

Example:
Input: 1234
Output: Digit sum of 1234 is : 10

Explanation: 1 + 2 + 3 + 4 = 10
*/


import java.util.Scanner;

public class Ans5 {
    public static int digitSum(int n ){
        int digitSum = 0;
        while(n>0){
            digitSum += n%10;
            n/=10;
        }
        return  digitSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        System.out.println("Digit sum of " + num + "is : " + digitSum(num));
        sc.close();
    }
}
