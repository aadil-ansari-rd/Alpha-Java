/*
Conditional Statements and Switch-Case Demonstration
----------------------------------------------------
Write a Java program that demonstrates the use of conditional statements (if-else, else-if) 
and switch-case statements to handle multiple scenarios based on user input.

The program should implement the following functionalities:

1. Check if a number is positive, negative, or zero:
   - Prompt the user to enter an integer.
   - Print whether the number is positive, negative, or zero.

2. Body Temperature Check:
   - Prompt the user to enter their body temperature (double).
   - If temperature > 100, print "You have fever."
   - Otherwise, print "You are all set."

3. Day of the Week:
   - Prompt the user to enter a number between 1 and 7.
   - Use a switch statement to print the corresponding day of the week.
   - If the number is outside 1-7, print "This is not a right number."

Example:
Input:
  Number = -5
  Temperature = 102.5
  Day = 3
Output:
  The given number is a negative number.
  You have fever.
  Wednesday
*/


import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //     System.out.println("Enter a number : ");
        //     int num = sc.nextInt();
        //     if (num < 0) {
        //         System.out.println("The given number is a negative number.");
        //     } else if (num == 0) {
        //         System.out.println("The given number is a 0");
        //     } else {
        //         System.out.println("The given number is a positive number.");

        //     }
        // }
        // ------------------
        // System.out.println("Enter your body temperature : ");
        // double temp = sc.nextDouble();
        // if(temp>100){
        //     System.out.println("You have fever.");
        // }else{
        //     System.out.println("You are all set");
        // }
        // ------------------
        // System.out.println("Enter day number : ");
        // int day = sc.nextInt();
        // switch (day) {
        //     case 1:
        //         System.out.println("Monday");
        //         break;
        //     case 2:
        //         System.out.println("Tuesday");
        //         break;
        //     case 3:
        //         System.out.println("Wednesday");
        //         break;
        //     case 4:
        //         System.out.println("Thrusday");
        //         break;
        //     case 5:
        //         System.out.println("Friday");
        //         break;
        //     case 6:
        //         System.out.println("Satrday");
        //         break;
        //     case 7:
        //         System.out.println("Sunday");
        //         break;
        //     default:
        //         System.out.println("This is not a right number");
        // }
        // ------------------
        sc.close();

    }
}
