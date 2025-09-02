/*
Balanced String Partitions

Problem Statement:
Given a string s consisting of characters 'L' and 'R'. 
A string is considered balanced if the number of 'L' characters 
is equal to the number of 'R' characters. 

Your task is to split the string into the maximum number of 
balanced substrings.

Return the maximum number of balanced substrings.

Example 1:
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: The string can be split as "RL", "RRLL", "RL", "RL".

Example 2:
Input: s = "RLRRRLLRLL"
Output: 2
Explanation: The string can be split as "RL", "RRRLLRLL".

Example 3:
Input: s = "LLLLRRRR"
Output: 1
Explanation: The string can be split as "LLLLRRRR".
*/

public class BalancedStringPartitions {

    // Function to count maximum balanced substrings
    public static int maxBalancedPartitions(String str) {
        int count = 0; // To count number of balanced substrings
        int balance = 0; // To track balance between L and R

        for (char ch : str.toCharArray()) {
            // Increment balance for 'L', decrement for 'R'
            if (ch == 'L') balance++;
            else if (ch == 'R') balance--;

            // Whenever balance becomes zero, we found a balanced substring
            if (balance == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalancedPartitions(str)); // Output: 3
    }
}
