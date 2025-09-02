/*
Problem Name: Tower of Hanoi using Recursion
Problem Statement:
-----------------
Write a Java program to solve the Tower of Hanoi problem using recursion.

The problem:
Given 'n' disks and three rods (source, helper, destination), move all disks 
from the source rod to the destination rod following these rules:
1. Only one disk can be moved at a time.
2. A disk can only be placed on top of a larger disk or an empty rod.
3. Use the helper rod as needed.

The program should:
1. Take the number of disks 'n' and labels for the three rods.
2. Recursively print the steps to move all disks from source to destination.

Example:
Input: n = 3, source = 'a', helper = 'b', destination = 'c'
Output:
Move Disk 1 from a to c
Move Disk 2 from a to b
Move Disk 1 from c to b
Move Disk 3 from a to c
Move Disk 1 from b to a
Move Disk 2 from b to c
Move Disk 1 from a to c

Explanation:
The recursive solution moves n-1 disks to the helper, moves the largest disk 
to the destination, and then moves n-1 disks from helper to destination.
*/

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char source , char helper , char destination){
        if(n==1){
            System.out.println( "Move Disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Move Disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n-1,  helper,source, destination);
    }
    public static void main(String[] args) {
        towerOfHanoi(3, 'a', 'b', 'c');
    }
}
