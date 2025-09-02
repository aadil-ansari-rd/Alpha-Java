/*
String Compression (Consecutive Character Count)
------------------------------------------------
Write a Java program to perform basic string compression using the counts 
of repeated characters.

The program should:
1. Traverse the input string.
2. For each group of consecutive repeating characters, append the character 
   followed by the number of times it repeats (if more than once) to the result.
3. Return the compressed string.

Example:
Input: "aaaahhhhidddd"
Output: "a4h4i1d4"
Explanation: 
- 'a' repeats 4 times → "a4"
- 'h' repeats 4 times → "h4"
- 'i' appears once → "i1"
- 'd' repeats 4 times → "d4"
Final compressed string: "a4h4i1d4"
*/


public class StringCompression {

    public static String compressStrings(String str) {
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            ans.append(str.charAt(i));
            if (count > 1) {
                ans.append(count.toString());

            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressStrings("aaaahhhhidddd"));
    }
}
