/*
Problem Name: Friends Pairing Problem
Problem Statement:
-----------------
Write a Java program to solve the Friends Pairing Problem using recursion.

The problem:
Given 'n' friends, each friend can remain single or be paired with another 
friend. The task is to count the total number of ways in which 'n' friends 
can remain single or pair up.

The program should:
1. Take an integer 'n' as input representing the number of friends.
2. Use recursion to calculate the number of ways friends can stay single 
   or form pairs.
3. Return the total count.

Example:
Input: n = 5
Output: 26
Explanation:
There are 26 ways 5 friends can remain single or pair up.

Recurrence Relation:
f(n) = f(n-1) + (n-1) * f(n-2)
- f(n-1): the first friend stays single.
- (n-1)*f(n-2): the first friend pairs up with any of the remaining (n-1) friends.
*/


public class FriendsPairingProb{
    public static int friendsPairing(int n){
        if(n==1||n==2){
            return n;
        }
        return friendsPairing(n-1) + (n-1)*friendsPairing(n-2);
    }
    public static void main(String[] args){
        System.out.println(friendsPairing(5));
    }
}