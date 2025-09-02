/*
0/1 Knapsack Problem (Recursive / Brute-Force)

Problem:
Given weights[] and values[] of n items and a knapsack of capacity W, 
find the maximum total value that can be put in the knapsack. 
Each item can be picked at most once.

Approach (Recursion):
1️⃣ Base Case:
   - If no items left (n==0) or capacity == 0 → return 0
2️⃣ For current item at index n-1:
   a) If weight > remaining capacity → cannot include → move to next item
   b) Else → two choices:
       i) Include item → add its value + recurse on remaining capacity and items
       ii) Exclude item → recurse without including item
3️⃣ Return max(include, exclude)

Time Complexity: O(2^n)  
Space Complexity: O(n) (recursion stack)

Example:
values = [3,4,5,6], weights = [2,3,4,5], capacity = 5
Output: 4 (only item 2, weight 3, value 4)
*/

public class KnapsackRecursive {

    // Recursive function to solve 0-1 Knapsack
    public static int knapSack(int capacity, int[] weights, int[] values, int n) {
        // Base case: no items left or capacity is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // If weight of the current item is more than capacity, skip it
        if (weights[n - 1] > capacity) {
            return knapSack(capacity, weights, values, n - 1);
        }

        // Case 1: Include the item
        int include = values[n - 1] + knapSack(capacity - weights[n - 1], weights, values, n - 1);

        // Case 2: Exclude the item
        int exclude = knapSack(capacity, weights, values, n - 1);

        // Return the max of including or excluding
        return Math.max(include, exclude);
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] values = {3, 4, 5, 6};
        int[] weights = {2, 3, 4, 5};
        int capacity = 5;
        int n = values.length;

        int maxValue = knapSack(capacity, weights, values, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
