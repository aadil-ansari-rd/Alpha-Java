/*
Best Time to Buy and Sell Stock
-------------------------------
Write a Java program to solve the "Best Time to Buy and Sell Stock" problem.

The program should:
1. Implement a method `maxProfit(int[] prices)` that calculates the maximum profit from a single buy and sell operation.
   - You are given an array `prices` where `prices[i]` is the stock price on day `i`.
   - You must buy before you sell.
   - Return 0 if no profit is possible.
2. Iterate through the array, keeping track of the minimum price seen so far and the maximum profit achievable.
3. Return the maximum profit.

Example:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.

Input: [7, 6, 4, 3, 1]
Output: 0
Explanation: No transaction can give a positive profit.
*/


// class Solution {
//     public int maxProfit(int[] prices) {
//         int minBuy = prices[0];
//         int maxProfit = Integer.MIN_VALUE;
//         for (int i = 1; i < prices.length; i++) {
//             minBuy = Math.min(minBuy, prices[i]);
//             int profit = prices[i] - minBuy;
//             maxProfit = Math.max(maxProfit, profit);
//         }
//         if (maxProfit <= 0) {
//             return 0;
//         }
//         return maxProfit;

//     }
// }



class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minBuy < prices[i]) {
                int profit = prices[i] - minBuy;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                minBuy = prices[i];
            }
        }
        return maxProfit;

    }
}