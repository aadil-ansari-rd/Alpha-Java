/*
Prime Number Check Using Method
-------------------------------
Write a Java program with a method to check whether a given integer is a prime number.

The program should:
1. Implement a method `isPrime(int num)` that returns `true` if `num` is prime, and `false` otherwise.
   - A prime number is greater than 1 and divisible only by 1 and itself.
   - Use an efficient check up to the square root of the number.
2. Prompt the user to enter an integer number.
3. Call the method and display whether the number is prime or not.

Example:
Input: 17
Output: 17 is Prime Number.

Input: 18
Output: 18 is not a Prime Number.
*/


import java.util.*;

class Prime {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        if (isPrime(num)) {
            System.out.println(num + " is Prime Number .");
        } else {
            System.out.println(num + " is not a Prime Number");

        }
        sc.close();

    }
}
