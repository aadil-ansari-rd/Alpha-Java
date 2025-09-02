/*
Operator Precedence and Associativity Demonstration
---------------------------------------------------
Write a Java program to evaluate and demonstrate the difference in operator precedence 
and associativity in arithmetic expressions.

The program should:
1. Declare integer variables with given values.
2. Compute multiple expressions using combinations of addition, subtraction, multiplication, 
   division, and parentheses.
3. Highlight how parentheses and operator precedence affect the result of expressions.
4. Print the results of the evaluated expressions.

Example:
Input:
  x = 10, y = 5
Expressions:
  exp1 = y * (x / y + x / y)
  exp2 = y * x / y + y * x / y
Output:
  exp1 = 20
  exp2 = 30
Explanation:
  The difference arises due to operator precedence and the placement of parentheses.
*/


public class Assign {

    public static void main(String[] args) {
        // int x = 2, y = 5;
        // int exp1 = (x * y / x); //5
        // int exp2 = (x * (y / x)); //4
        // System.out.print(exp1 + ",");
        // System.out.print(exp2);

        // int x = 200, y = 50, z = 100;
        // if (x > y && y > z) {
        //     System.out.println("Hello");
        // }
        // if (z > y && z < x) {
        //     System.out.println("Java"); //Java
        // }
        // if ((y + 200) < x && (y + 150) < z) {
        //     System.out.println("Hello Java");
        // }
        // int x, y, z;
        // x = y = z = 2;
        // x += y; //4
        // y -= z; //0
        // z /= (x + y); //0
        // System.out.println(x + " " + y + " " + z);


        // int x = 9, y = 12;
        // int a = 2, b = 4, c = 6;
        // int exp = 4 / 3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b * y);
        // System.out.println(exp);

        int x = 10, y = 5;
        int exp1 = (y * (x / y + x / y));
        int exp2 = (y * x / y + y * x / y);
        System.out.println(exp1);
        System.out.println(exp2);
        
    }
}
