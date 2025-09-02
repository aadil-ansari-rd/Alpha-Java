/*
Count Lowercase Letters in a String
----------------------------------
Write a Java program to count the number of lowercase letters in a given string.

Approach:
---------
1. Initialize a counter variable to 0.
2. Traverse the string character by character using a loop.
3. For each character, check if it lies between 'a' and 'z' using `ch >= 'a' && ch <= 'z'`.
4. If yes, increment the counter.
5. After the loop, return the counter as the total number of lowercase letters.

Time Complexity: O(n) where n = length of the string
Space Complexity: O(1)

Example:
Input: "Hello World!"
Output: 8  (letters: e, l, l, o, o, r, l, d)
*/


import java.util.Scanner;

public class CountLowercase {
    public static int countLowerCase(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str = sc.nextLine();
        System.out.println("No. of lowercase character : " + countLowerCase(str));


        sc.close();


    }
}
