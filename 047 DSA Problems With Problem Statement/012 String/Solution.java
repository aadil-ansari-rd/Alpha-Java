/*
Palindrome Check (Alphanumeric, Case-Insensitive)
-------------------------------------------------
Write a Java program to determine if a given string is a palindrome, considering 
only alphanumeric characters and ignoring cases.

The program should:
1. Convert the input string to lowercase.
2. Remove all non-alphanumeric characters from the string.
3. Check if the resulting string reads the same forwards and backwards.
4. Return true if it is a palindrome, otherwise return false.

Example:
Input: "A man, a plan, a canal: Panama"
Output: true
Explanation: Ignoring spaces, punctuation, and case, the string becomes 
"amanaplanacanalpanama", which is a palindrome.

Input: "race a car"
Output: false
Explanation: The cleaned string "raceacar" is not a palindrome.
*/


class Solution {
    public static boolean isAlphanumeric(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        int n =s.length();
        System.out.println(s);
        for(int i=0;i<n;i++){
            char ch = s.charAt(i) ;
            if(isAlphanumeric(ch)){
                str+=ch;
            }
        }
        System.out.println(str);
        int m = str.length();
        for(int i=0;i<m/2;i++){
            if(str.charAt(i)!=str.charAt(m-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ts = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(ts));
    }
}
