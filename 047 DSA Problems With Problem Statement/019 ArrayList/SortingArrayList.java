/*
Problem Name: Sort ArrayList Ascending and Descending
Problem Statement:
-----------------
Sort a given ArrayList of integers in both ascending and descending order using built-in functions. 
Display the original list, the list sorted in ascending order, and the list sorted in descending order.

You need to:
1. Print the original ArrayList.
2. Use Collections.sort() to sort the list in ascending order and print it.
3. Use Collections.sort() with Collections.reverseOrder() to sort the list in descending order and print it.

Example:
Input: list = [2, 7, 8, 3, 9, 1]
Output:
Normal ArrayList(Without Sorting) : [2, 7, 8, 3, 9, 1]
ArrayList After Sorting : [1, 2, 3, 7, 8, 9]
ArrayList After Reverse Sorting : [9, 8, 7, 3, 2, 1]
Explanation: The ArrayList is displayed in original order, ascending order, and descending order.
*/


import java.util.ArrayList;
import java.util.Collections;

public class SortingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(9);
        list.add(1);
        System.out.println("Normal ArrayList(Without Sorting) : " + list);
        Collections.sort(list);
        System.out.println("ArrayList After Sorting : " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("ArrayList After Reverse Sorting : " + list);
    }
}
