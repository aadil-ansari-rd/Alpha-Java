/*
Problem Statement: Basic HashSet Operations in Java

Perform and demonstrate the following operations on a HashSet in Java:

1. Create a HashSet
2. Add elements using add()
3. Handle duplicate elements (duplicates are ignored)
4. Print the HashSet
5. Check if an element exists using contains()
6. Get the size using size()
7. Check if the set is empty using isEmpty()
8. Remove an element using remove()
9. Iterate through elements using Iterator
10. Iterate using for-each loop
11. Clear all elements using clear()
12. Check isEmpty() after clear()

Example:
Input Operations:
add("Apple"), add("Banana"), add("Cherry"), add("Date"), add("Apple")
contains("Banana"), contains("Grape")
remove("Date")
iterate using Iterator and for-each
clear()

Expected Output:
Initial HashSet: [Apple, Banana, Cherry, Date]
Contains 'Banana'? true
Contains 'Grape'? false
Size of set: 4
Is set empty? false
After removing 'Date': [Apple, Banana, Cherry]
Iterating using Iterator: Apple Banana Cherry 
Iterating using for-each: Apple Banana Cherry 
After clear(): []
Is set empty now? true
*/

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

    public static void main(String[] args) {
        // 1. Create a HashSet of Strings
        HashSet<String> set = new HashSet<>();

        // 2. add() - Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Date");
        set.add("Apple"); // duplicate, will not be added

        // 3. Print the HashSet
        System.out.println("Initial HashSet: " + set);

        // 4. contains() - Check if an element exists
        System.out.println("Contains 'Banana'? " + set.contains("Banana"));
        System.out.println("Contains 'Grape'? " + set.contains("Grape"));

        // 5. size() - Get number of elements
        System.out.println("Size of set: " + set.size());

        // 6. isEmpty() - Check if set is empty
        System.out.println("Is set empty? " + set.isEmpty());

        // 7. remove() - Remove an element
        set.remove("Date");
        System.out.println("After removing 'Date': " + set);

        // 8. iterator() - Iterate through elements
        System.out.print("Iterating using Iterator: ");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 9. for-each loop
        System.out.print("Iterating using for-each: ");
        for (String fruit : set) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 10. clear() - Remove all elements
        set.clear();
        System.out.println("After clear(): " + set);

        // 11. isEmpty() again
        System.out.println("Is set empty now? " + set.isEmpty());
    }
}
