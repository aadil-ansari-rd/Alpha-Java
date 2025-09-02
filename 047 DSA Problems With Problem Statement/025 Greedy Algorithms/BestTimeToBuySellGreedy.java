/*
Best Time to Buy and Sell Stock (LeetCode 121)

Problem Statement:
You are given an array prices where prices[i] is the price of a given stock on the i-th day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a 
different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

public class BestTimeToBuySellGreedy {

    // Function to calculate maximum profit using greedy approach
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0]; // Track lowest price to buy
        int maxProfit = 0; // Track maximum profit found

        for (int i = 1; i < prices.length; i++) {
            // Update minPrice if we find a lower price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if sold today
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1)); // Output: 0

        int[] prices2 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices2)); // Output: 5
    }
}
