/*
Problem Name: Pair Sum in Rotated Sorted ArrayList
Problem Statement:
-----------------
Given a rotated sorted ArrayList of integers and a target sum, find a pair of 
indices (i, j) such that list[i] + list[j] equals the target. If no such pair 
exists, return an empty list. Implement both a brute-force and an optimized solution.

You need to:
1. Brute-force approach: Check all possible pairs and return the first pair matching the target.
2. Optimized approach:
   - Identify the pivot where the rotation occurs.
   - Use two pointers: one at the smallest element (pivot + 1) and one at the largest element (pivot).
   - Move pointers in a circular manner using modular arithmetic to find a pair whose sum equals the target.

Example:
Input: list = [11, 15, 6, 8, 9, 10], target = 16
Output: [1, 2]
Explanation: The elements at indices 1 and 2 sum to 16. The optimized approach leverages the rotation to efficiently find the pair.
*/


import java.util.ArrayList;
import java.util.List;

public class PairSum {

    //Input Array is rotated sorted
    static List<Integer> bruteForce(ArrayList<Integer> list, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (sum == target) {
                    ans.add(i);
                    ans.add(j);
                    return ans;
                }
            }
        }
        return ans;
    }

    static List<Integer> optimised(ArrayList<Integer> list, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = list.size(); //Size of list
        int pivot = -1; //Pivot point to find exactly at what position array is rotated.
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int st = pivot + 1, end = pivot;
        //This will give partial sorted array that can be complete sorted with modular airthmatics.

        while (st != end) {
            int sum = list.get(st) + list.get(end);
            // Case : 1
            if (sum == target) {
                ans.add(st);
                ans.add(end);
                return ans;
            } else if (sum < target) { // Case : 2
                st = (st + 1) % n;
            } else { // Case : 3
                end = (n + end - 1) % n;
                //(n + end - 1) this expression uses 'n' because it will create problen 
                //when "end=0" => "end-1" will give negative index that is not valid
                //so 'n' is used . And 'n' is completely absorbed bu modulus when "end!=0"
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println("With Brute Force Approach : " + bruteForce(list, 16));
        System.out.println("With Optimised Approach : " + optimised(list, 16));
    }
}
