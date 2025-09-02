/*
Problem Statement: PriorityQueue of Custom Objects with Normal and Reverse Order

✅ Problem Statement:
Implement a PriorityQueue in Java for custom objects (Student) with a rank field. Demonstrate two cases: 
1. Normal order (ascending by rank)
2. Reverse order (descending by rank)

Example:
Input:
Students: [("Aadil",2), ("Afjal",3), ("Anaya",1)]

Output:
Normal Order:
Anaya : 1
Aadil : 2
Afjal : 3

Reverse Order:
Afjal : 3
Aadil : 2
Anaya : 1
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue3 {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        String  print(){
            return this.name + " : " + this.rank; 
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank ;
        }
    }

    public static void normalorder (){
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Aadil", 2));
        pq.add(new Student("Afjal", 3));
        pq.add(new Student("Anaya", 1));
        System.out.println("Normal Order");
        while(!pq.isEmpty()){
            System.out.println(pq.poll().print());
        }
    }
    public static void reverseOrder (){
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Aadil", 2));
        pq.add(new Student("Afjal", 3));
        pq.add(new Student("Anaya", 1));
        System.out.println("Reverse Order");
        while(!pq.isEmpty()){
            System.out.println(pq.poll().print());
        }
    }
    public static void main(String[] args) {
        normalorder();
        reverseOrder();
    }
}
