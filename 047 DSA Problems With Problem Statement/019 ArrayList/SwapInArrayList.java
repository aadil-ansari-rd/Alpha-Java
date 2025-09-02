/*
Problem Name: Swap Elements in ArrayList
Problem Statement:
-----------------
Swap two elements in a given ArrayList of integers at specified indices. Display 
the ArrayList before and after the swap operation.

You need to:
1. Take two indices idx1 and idx2.
2. Swap the elements at these indices using a temporary variable.
3. Print the ArrayList before and after the swap.

Example:
Input: list = [2, 3, 4, 5, 6, 7], idx1 = 2, idx2 = 4
Output:
Before Swap : [2, 3, 4, 5, 6, 7]
After Swap : [2, 3, 6, 5, 4, 7]
Explanation: Elements at indices 2 and 4 (values 4 and 6) are swapped.
*/


import java.util.ArrayList;

public class SwapInArrayList {
    static void swap(ArrayList<Integer>list , int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("Before Swap : " + list);
        swap(list, 2,4);
        System.out.println("After Swap : " + list);

    }
}
