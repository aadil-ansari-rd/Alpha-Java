/*
Multi-Task Java Program
-----------------------
Write a Java program that performs multiple small tasks based on user input. 
Implement the following functionalities (any one at a time):

1. Average of Three Numbers:
   - Prompt the user to enter three integers.
   - Calculate and display their average.

2. Area of a Square:
   - Prompt the user to enter the side of a square.
   - Calculate and display its area using the formula: Area = side * side.

3. Billing System:
   - Prompt the user to enter the price of a pencil, a pen, and an eraser.
   - Compute the total cost of the items.
   - Also calculate the final payable amount including 18% GST.
   - Display both the total cost and the payable bill.

Example:
Input:
  Pencil = 10
  Pen = 20
  Eraser = 5
Output:
  Total Bill = 35 Rupees
  Payable Bill including 18% GST = 41.3 Rupees
*/


import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ans : 1,  Average of numbers
        // System.out.println("Enter first number = ");
        // int a = sc.nextInt();
        // System.out.println("Enter Second number = ");
        // int b = sc.nextInt();
        // System.out.println("Enter Third number = ");
        // int c = sc.nextInt();
        // System.out.println("Average of these three numbers are : " + (a+b+c)/3);


        // Ans : 2 , Area of square 
        // System.out.println("Enter the side of square : ");
        // int side = sc.nextInt();
        // int area = side * side;
        // System.out.println("Area of the square is : "+ area);


        // Billing
        // System.out.println("Enter the price of Pencil : ");
        // float pencil = sc.nextFloat();
        // System.out.println("Enter the price of Pen :");
        // float pen = sc.nextFloat();
        // System.out.println("Enter the price of Eraser :");
        // float eraser = sc.nextFloat();
        // System.out.println("Your total bill is : " + (pencil + pen + eraser) + "Rupees");
        // double payBill = (pencil + pen + eraser) + (pencil + pen + eraser)*18/100 ;
        // System.out.println("Your payable bill including 18% GST : " +  payBill);
        sc.close();

    }
}
