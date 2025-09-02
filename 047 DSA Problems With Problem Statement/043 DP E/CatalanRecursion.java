/*
Problem: Catalan Number (Recursive Approach)

Given an integer n, compute the nth Catalan number using a simple recursive approach.

Catalan numbers are defined as:
C0 = 1, C1 = 1
Cn = sum(Ci * Cn-i-1) for i = 0 to n-1

Example:
Input: n = 4
Output: 14

Explanation: Using pure recursion, the 4th Catalan number is calculated as 14.
*/

public class CatalanRecursion {

    // Recursive function to find nth Catalan number
    public static int catalan(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 0;

        // Apply recursive formula: Cn = sum(Ci * Cn-i-1)
        for (int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n - i - 1);
        }

        return result;
    }

    // Driver method to test the recursion
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Catalan number for n = " + n + " is " + catalan(n));
    }
}
