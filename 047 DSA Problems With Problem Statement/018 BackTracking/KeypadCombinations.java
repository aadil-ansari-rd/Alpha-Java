/*
Problem Name: Letter Combinations of a Phone Number
Problem Statement:
-----------------
Given a string containing digits from 2 to 9, return all possible letter combinations 
that the number could represent based on a standard phone keypad mapping.

You need to:
1. Map each digit to its corresponding letters (as on a phone keypad).
2. Generate all possible combinations by choosing one letter per digit.
3. Print each combination.

Example:
Input: digits = "23"
Output:
ad
ae
af
bd
be
bf
cd
ce
cf

Explanation:
- Digit '2' maps to 'abc' and digit '3' maps to 'def'.
- All possible combinations of these letters are printed.
*/


import java.util.*;

public class KeypadCombinations {

    // Phone keypad mapping for digits 2-9
    static String[] mapping = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    // Function to generate all combinations
    public static void generateCombinations(String digits, int index, String current) {
        // Base case: all digits processed
        if (index == digits.length()) {
            if (!current.isEmpty()) System.out.println(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        // For each letter corresponding to current digit
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, index + 1, current + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits = "23";  // you can change input here

        if (digits.isEmpty()) {
            System.out.println("");
            return;
        }
        generateCombinations(digits, 0, "");
    }
}
