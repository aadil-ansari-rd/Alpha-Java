/*
Problem: Tribonacci Number with Plain Recursion

Definition:
- T(0) = 0, T(1) = 1, T(2) = 1
- T(n) = T(n-1) + T(n-2) + T(n-3) for n >= 3

Approach:
1. Direct recursive function without memoization.
2. Base cases:
   - n == 0 → return 0
   - n == 1 or n == 2 → return 1
3. Recursive case:
   - return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3)
4. Time Complexity: O(3^n) → exponential (inefficient for large n)
5. Space Complexity: O(n) for recursion stack
*/

public class TribonacciRecursion {

    // Recursive function to calculate nth Tribonacci number
    public int tribonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Recursive relation: T(n) = T(n-1) + T(n-2) + T(n-3)
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // Testing the function
    public static void main(String[] args) {
        TribonacciRecursion obj = new TribonacciRecursion();

        System.out.println("Tribonacci(4): " + obj.tribonacci(4));  // Output: 4
        System.out.println("Tribonacci(25): " + obj.tribonacci(25)); // Output: 1389537
    }
}
