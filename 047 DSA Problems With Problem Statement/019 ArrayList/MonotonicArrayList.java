/*
Problem Name: Monotonic Array
Problem Statement:
-----------------
Determine if a given ArrayList of integers is monotonic. An array is monotonic 
if it is either entirely non-increasing or non-decreasing. The function should 
return true if the array is monotonic, otherwise false.

You need to:
1. Traverse the array and check for increasing order violations.
2. Traverse the array and check for decreasing order violations.
3. Return true if the array is either non-decreasing or non-increasing.

Example:
Input: list = [2, 3, 4, 5, 6, 7]
Output: true
Explanation: The array is entirely non-decreasing.

Input: list = [7, 6, 5, 4, 3, 2]
Output: true
Explanation: The array is entirely non-increasing.

Input: list = [2, 7, 8, 3, 9, 1]
Output: false
Explanation: The array is neither non-increasing nor non-decreasing.
*/


import java.util.ArrayList;

public class MonotonicArrayList {
    static boolean isMonotonic(ArrayList<Integer>list){
        boolean incrSort = true, decrSort = true;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)) incrSort = false;
            if(list.get(i)<list.get(i+1)) decrSort = false;
        }
        return incrSort||decrSort;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(9);
        list.add(1);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(6);
        list2.add(5);
        list2.add(4);
        list2.add(3);
        list2.add(2);

        System.out.println("List is monotonic : " + isMonotonic(list));
        System.out.println("List1 is monotonic : " + isMonotonic(list1));
        System.out.println("List2 is monotonic : " + isMonotonic(list2));

    }
}
