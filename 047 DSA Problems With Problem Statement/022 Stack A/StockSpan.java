/*
Problem Name: Stock Span Problem
--------------------------------
Problem Statement:
-----------------
Given an array of daily stock prices, calculate the Stock Span for each day. 
The stock span of a day is the maximum number of consecutive days just before 
the given day, for which the price of the stock was less than or equal to the 
price on the given day.

You need to:
1. Use a stack to efficiently keep track of indices of days with higher prices.
2. For each day's price, pop indices from the stack while the price at those 
   indices is less than or equal to the current day's price.
3. If the stack becomes empty, the span is the number of days from day 0 to current day.
4. Otherwise, the span is the difference between current day index and index on top of stack.
5. Push current day index onto the stack and continue.

Example:
--------
Input: prices = [100, 80, 60, 70, 60, 75, 85]
Output: [1, 1, 1, 2, 1, 4, 6]
Explanation: 
Day 0: 100 → span=1
Day 1: 80 → span=1
Day 2: 60 → span=1
Day 3: 70 → span=2
Day 4: 60 → span=1
Day 5: 75 → span=4
Day 6: 85 → span=6
*/

import java.util.Stack;

public class StockSpan {
    public static int[] stockSpan(int[] prices) {
        Stack<Integer> st = new Stack<>(); // Stack stores indices of days
        int n = prices.length;
        int[] span = new int[n]; // Result array to store span values

        for (int i = 0; i < n; i++) {
            int val = prices[i];

            // Pop elements from stack while current price is greater or equal to price at
            // stack's top index
            while (!st.isEmpty() && (prices[st.peek()] <= val)) {
                st.pop();
            }

            // If stack is empty, it means no greater element to the left → span = i+1
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Else, span = distance between current day and the last greater price day
                span[i] = i - st.peek();
            }

            // Push current index onto stack
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] stock = stockSpan(prices);
        for (int i : stock) {
            System.out.print(i + " ");
        }
    }
}
