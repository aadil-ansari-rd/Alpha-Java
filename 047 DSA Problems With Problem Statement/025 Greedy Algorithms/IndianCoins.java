/*
Indian Coin Change Problem (Greedy)

Problem Statement:
Given an amount in rupees and an array representing Indian currency 
denominations, the task is to find the minimum number of coins/notes 
required to make the given amount. You can use any denomination multiple 
times. Always pick the largest possible denomination first to minimize 
the number of coins/notes.

Example 1:
Input: amount = 1219
Output: [500, 500, 200, 10, 5, 2, 2]

Example 2:
Input: amount = 93
Output: [50, 20, 20, 2, 1]

Example 3:
Input: amount = 1000
Output: [500, 500]
*/

import java.util.*;

public class IndianCoins {
    public static void minCoins(int amount) {
        int[] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        List<Integer> result = new ArrayList<>();

        // Step 1: Pick largest coin possible at each step
        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }

        // Step 2: Print coins used
        System.out.println("Coins/Notes used: " + result);
    }

    public static void main(String[] args) {
        int amount = 1219;
        minCoins(amount);
    }
}
