/*
Kth Largest Odd Number in a Range

Problem Statement:
You are given two integers L and R representing a range [L, R], and an 
integer K. Find the Kth largest odd number within this range.

If there are fewer than K odd numbers in the range, return 0.

Example 1:
Input: L = -3, R = 3, K = 1
Output: 3
Explanation: Odd numbers in range = [-3, -1, 1, 3]. The 1st largest is 3.

Example 2:
Input: L = -3, R = 3, K = 2
Output: 1
Explanation: The 2nd largest odd number is 1.

Example 3:
Input: L = 4, R = 4, K = 1
Output: 0
Explanation: There are no odd numbers in this range.
*/

public class KthLargestOddNumber {

    // Function to find Kth largest odd number between L and R
    public static int kthLargestOdd(int L, int R, int K) {
        // Find largest odd number in the range
        int largestOdd = (R % 2 == 1) ? R : R - 1;

        // Find smallest odd number in the range
        int smallestOdd = (L % 2 == 1) ? L : L + 1;

        // Total odd numbers in range
        int totalOdds = ((largestOdd - smallestOdd) / 2) + 1;

        // If K is greater than total odd numbers, return 0
        if (K > totalOdds) return 0;

        // Else return Kth largest odd number
        return largestOdd - (K - 1) * 2;
    }

    public static void main(String[] args) {
        int L = -3, R = 3, K = 1;
        System.out.println(kthLargestOdd(L, R, K)); // Output: 3
    }
}
