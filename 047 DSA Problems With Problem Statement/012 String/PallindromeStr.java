/*
Check Palindrome String
----------------------
Write a Java program to check if a given string is a palindrome. A palindrome is a string 
that reads the same forward and backward.

Approach:
---------
Method 1 (isPallindrome):
1. Loop from start to middle of the string.
2. Compare characters at positions i and n-1-i.
3. If any pair differs, return false.
4. Otherwise, return true.

Method 2 (isPallindromePoint):
1. Use two pointers: st at start, end at last index.
2. While st < end, compare characters at st and end.
3. If they differ, return false; else increment st and decrement end.
4. Return true if all characters match.

Example:
Input: "noton"
Output: true

Time Complexity: O(n)
Space Complexity: O(1)
*/


public class PallindromeStr {

    public static boolean  isPallindrome(String str){
        int n = str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return  false;
            }
        }
        return  true;
    }

    public static boolean isPallindromePoint(String str){
        int st=0,end = str.length()-1;
        while(st<end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String name = "noton";
        System.out.println(isPallindromePoint(name));
        
    }
}