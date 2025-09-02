/*
Problem: Generate Binary Numbers from 1 to N

Explanation:
------------
1. Function `binary(int num)`:
   - Converts a decimal number to its binary representation as a string.
   - Uses repeated division by 2 and prepends remainder to build binary string.

2. Function `generateBinaryNumbers(int n)`:
   - Loops from 1 to n and prints binary representation of each number using `binary()`.

Example Output for N=10:
------------------------
1 10 11 100 101 110 111 1000 1001 1010
*/

// Q1
public class GenerateBinaryNumbers {

    public static String binary(int num){
        String ans = "";

        while (num!=0) {
            ans =  num%2 + ans;
            num/=2;
        }

        return ans;
    }
    public static void generateBinaryNumbers(int n){
        for(int i=1;i<=n;i++){
            System.out.print(binary(i) + " ");
        }
    }
    public static void main(String[] args) {
        generateBinaryNumbers(10);
    }
}
