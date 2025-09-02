/*
Problem Name: Pair Sum in Sorted ArrayList
Problem Statement:
-----------------
Given a sorted ArrayList of integers and a target sum, find a pair of indices 
(i, j) such that list[i] + list[j] equals the target. If no such pair exists, 
return an empty list. Implement both a brute-force and an optimized solution.

You need to:
1. Brute-force approach: Check all possible pairs and return the first pair matching the target.
2. Optimized approach: Use two pointers, one at the start and one at the end of the sorted list, 
   moving them towards each other until a pair with the target sum is found or pointers meet.

Example:
Input: list = [2, 3, 4, 5, 6, 7], target = 6
Output: [0, 2]
Explanation: Elements at indices 0 and 2 (2 + 4 = 6) form the target sum. The optimized approach finds it efficiently using two pointers.
*/


import java.util.*;

public class TwoSum {
    //Input Array is already sorted.
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

    static List<Integer> optimised(ArrayList<Integer> list , int target){
        List<Integer> ans = new ArrayList<>();
        int st= 0, end = list.size() -1;
        while(st<end){
            int sum = list.get(st) + list.get(end)  ;
            if(sum==target){
                ans.add(st);
                ans.add(end);
                return ans;
            }else if(sum<target){
                st++;
            }else{
                end--;
            }
        }
        return ans;
    }
   

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("With Brute Force Approach : " + bruteForce(list, 6));
        System.out.println("With Optimised Approach : " + optimised(list, 6));

       
    }
}
