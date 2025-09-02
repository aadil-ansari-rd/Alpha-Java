/*
Problem Statement: LinkedHashSet Operations and Iteration

Create a LinkedHashSet to store a collection of unique Strings while maintaining insertion order. 
Perform operations like add, contains, size, isEmpty, remove, iteration (for-each and Iterator), and clear, demonstrating how duplicates are ignored.

Example:
Input: Add "Apple", "Banana", "Mango", "Orange", "Apple"
Output:
Initial LinkedHashSet: [Apple, Banana, Mango, Orange]
Contains 'Mango'? true
Contains 'Pineapple'? false
Size of set: 4
After removing 'Orange': [Apple, Banana, Mango]
Iterating using Iterator: Apple Banana Mango
Iterating using for-each: Apple Banana Mango
After clear(): []
Is set empty now? true
*/

import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        // 1. Create LinkedHashSet
        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        // 2. add() - Add elements (duplicates are ignored)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Apple");  // duplicate

        // 3. Print the LinkedHashSet (maintains insertion order)
        System.out.println("Initial LinkedHashSet: " + fruits);

        // 4. contains()
        System.out.println("Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("Contains 'Pineapple'? " + fruits.contains("Pineapple"));

        // 5. size()
        System.out.println("Size of set: " + fruits.size());

        // 6. isEmpty()
        System.out.println("Is set empty? " + fruits.isEmpty());

        // 7. remove()
        fruits.remove("Orange");
        System.out.println("After removing 'Orange': " + fruits);

        // 8. iterator()
        System.out.print("Iterating using Iterator: ");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 9. for-each loop
        System.out.print("Iterating using for-each: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 10. clear()
        fruits.clear();
        System.out.println("After clear(): " + fruits);

        // 11. isEmpty() again
        System.out.println("Is set empty now? " + fruits.isEmpty());
    }
}
