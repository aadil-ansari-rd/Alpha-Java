/*
Problem Name: Reverse ArrayList Elements
Problem Statement:
-----------------
Reverse the elements of a given ArrayList of integers and print them. The original 
ArrayList should remain unchanged when iterating normally. The task is to display 
the ArrayList in reverse order without using built-in reverse functions.

You need to:
1. Traverse the ArrayList from the last index to the first.
2. Print each element during the reverse traversal.
3. Optionally, demonstrate normal traversal to show the original order is unchanged.

Example:
Input: list = [2, 3, 4, 5, 6, 7]
Output:
Array List   : [2, 3, 4, 5, 6, 7]
Reverse Array List   : 7 6 5 4 3 2
Array List with forEach loop : 2 3 4 5 6 7
Explanation: The ArrayList is displayed in reverse order without modifying the original list.
*/


import java.util.ArrayList;

public class ReverseArrayList{
    static void reverseArrayList(ArrayList<Integer>list){
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+ " ");
        }
    }
    public static void main(String[] args){
        ArrayList<Integer>  list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("Array List   :  "+ list);
        System.out.print("Reverse Array List   :  ");
        reverseArrayList(list);
        System.out.println();
        System.out.print("Array List with forEach loop : ");
        for(Integer val : list){
            System.out.print(val + " ");
        }

    }
}