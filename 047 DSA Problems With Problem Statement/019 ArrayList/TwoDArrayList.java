/*
Problem Name: 2D ArrayList of Multiples
Problem Statement:
-----------------
Create and manipulate a 2D ArrayList (ArrayList of ArrayLists) of integers. Populate 
the 2D ArrayList with multiples of row numbers and print the elements row-wise.

You need to:
1. Initialize a 2D ArrayList with a given number of rows.
2. For each row, create an inner ArrayList and populate it with multiples of the row index.
3. Add the inner ArrayLists to the main 2D ArrayList.
4. Print the elements row by row.
5. Demonstrate two methods of populating and printing a 2D ArrayList.

Example:
Input: 3 rows, each containing multiples of 1, 2, and 3 up to 10
Output:
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
3 6 9 12 15 18 21 24 27 30
Explanation: Each inner ArrayList represents multiples of the row number. Both manual and loop-based methods are demonstrated.
*/


import java.util.*;
public class TwoDArrayList {
    static  void twoDArrayListEasy(){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            list.add(new ArrayList<>());  // Initialize inner ArrayList
            for(int j=1;j<=10;j++){
                list.get(i).add((i+1)*j);
            }
        }

        for(ArrayList<Integer> l : list ){
            for(Integer val : l){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();

        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=1;i<=10;i++){
            list0.add(i*1);
            list1.add(i*2);
            list2.add(i*3);
        }
        main.add(list0);
        main.add(list1);
        main.add(list2);
        for(int i=0;i<main.size();i++){
            for(int j=0;j<main.get(i).size();j++){
                System.out.print(main.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("Second Method To handle : ");
        twoDArrayListEasy();
    }
}
