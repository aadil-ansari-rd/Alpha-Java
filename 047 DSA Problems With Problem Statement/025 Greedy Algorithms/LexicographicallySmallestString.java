/*
Lexicographically Smallest String with Given Numeric Value

Problem Statement:
You are given two integers N and K. Construct a string of length N 
consisting of lowercase letters ('a' to 'z') such that the sum of 
numeric values of its characters is equal to K. The numeric value of 
a character is its position in the alphabet: 'a' = 1, 'b' = 2, ..., 'z' = 26.

Return the lexicographically smallest string satisfying the above condition.

Example 1:
Input: N = 5, K = 42
Output: "aaszz"
Explanation: The numeric values sum up to 42 and the string is lexicographically smallest.

Example 2:
Input: N = 3, K = 25
Output: "aay"
Explanation: The numeric values sum up to 25 and the string is lexicographically smallest.

Example 3:
Input: N = 1, K = 26
Output: "z"
*/

public class LexicographicallySmallestString {

    // Function to generate lexicographically smallest string
    public static String getSmallestString(int N, int K) {
        char[] result = new char[N];
        for (int i = 0; i < N; i++) result[i] = 'a'; // initialize with 'a'
        K = K - N;  // since all are initialized to 'a'

        int index = N - 1;
        while (K > 0) {
            // We can increase max by 25 ('a' + 25 = 'z')
            int extra = Math.min(25, K);
            result[index] = (char)(result[index] + extra);
            K -= extra;
            index--;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(5, 42)); // Output: aamz
        System.out.println(getSmallestString(3, 25)); // Output: aaw
    }
}
