/*
Print All Prime Numbers in a Range
----------------------------------
Write a Java program to print all prime numbers within a given range from 2 to a user-specified maximum number.

The program should:
1. Implement a method `isPrime(int num)` that returns `true` if `num` is prime and `false` otherwise.
   - A prime number is greater than 1 and divisible only by 1 and itself.
   - Use an efficient check up to the square root of the number.
2. Prompt the user to enter the maximum number in the range.
3. Iterate through numbers from 2 to the maximum number and print all prime numbers.

Example:
Input: 10
Output: Prime Numbers in the given range are : 2 3 5 7
*/


import java.util.Scanner;

public class PrimeRange {
    public static boolean isPrime(int num) {
        if(num<2){
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
        System.out.println("Enter max number in range : ");
        int num = sc.nextInt();
        System.out.println("Prime Numbers in the given range are : ");
        for (int i=2; i<=num ;i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
        sc.close();
        
    }
}
