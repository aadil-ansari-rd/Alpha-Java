/*
Sum of Odd and Even Numbers
---------------------------
Write a Java program to calculate the sum of odd and even numbers entered by the user.

The program should:
1. Continuously prompt the user to enter integers.
2. For each number:
   - If it is even, add it to the sum of even numbers.
   - If it is odd, add it to the sum of odd numbers.
3. Ask the user whether they want to continue or see the results:
   - Enter 1 to continue entering numbers.
   - Enter 0 to stop and display the results.
4. After the user chooses to stop, print the total sum of odd numbers and total sum of even numbers.

Example:
Input:
  3
  4
  5
  6
  0 (to stop)
Output:
  Sum of odd numbers : 8
  Sum of even numbers : 10
*/


import java.util.Scanner;

public class SumOFOddEven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // --------------
        int odd = 0, even = 0;
        int choice = 1;
        do {
            System.out.println("Enter your number : ");
            int num = sc.nextInt();
            if (num % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
            System.out.println("Enter 0 if you want results else press 1");
            choice = sc.nextInt();
        } while (choice != 0);
        System.out.println("Sum of odd numbers : " + odd);
        System.out.println("Sum of even numbers : " + even);
        sc.close();

    }
}
