/*
Problem Name: Beautiful Array
Problem Statement:
-----------------
Construct a "Beautiful Array" of size n: An array is beautiful if for every 
triplet of indices i < j < k, the condition 2 * arr[j] != arr[i] + arr[k] holds. 
Given an integer n, generate any beautiful array containing numbers from 1 to n.

You need to:
1. Start with an initial array [1].
2. Iteratively generate new arrays by:
   - Mapping each number x to 2*x - 1 (odd numbers).
   - Mapping each number x to 2*x (even numbers).
   - Keep only numbers ≤ n.
3. Repeat until the array size reaches n.
4. Return or print the resulting beautiful array.

Example:
Input: n = 5
Output: [1, 3, 2, 5, 4]
Explanation: This arrangement ensures no triplet i < j < k satisfies 2*arr[j] == arr[i] + arr[k].
*/


import java.util.*;

public class BeautifulArrayList {

    public static List<Integer> beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();

            // Generate odd numbers from previous result
            for (int num : result) {
                if (2 * num - 1 <= n)
                    temp.add(2 * num - 1);
            }

            // Generate even numbers from previous result
            for (int num : result) {
                if (2 * num <= n)
                    temp.add(2 * num);
            }

            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5; // Change n value for testing
        List<Integer> beautiful = beautifulArray(n);
        System.out.println(beautiful);
    }
}
