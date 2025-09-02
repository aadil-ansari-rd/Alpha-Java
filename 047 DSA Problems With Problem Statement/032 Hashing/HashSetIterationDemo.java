/*
Problem Statement: Iterating Through a HashSet in Java

Demonstrate multiple ways to iterate over a HashSet in Java:

1. Create a HashSet and add elements.
2. Iterate using a for-each loop.
3. Iterate using an Iterator.
4. Iterate using the forEach() method with a lambda expression.
5. Iterate using Java Stream API.

Example:
Input:
Add elements: "Apple", "Banana", "Mango", "Orange"

Expected Output:
HashSet: [Apple, Banana, Mango, Orange]

Iterating using for-each loop:
Apple
Banana
Mango
Orange

Iterating using Iterator:
Apple
Banana
Mango
Orange

Iterating using forEach (lambda):
Apple
Banana
Mango
Orange

Iterating using stream():
Apple
Banana
Mango
Orange
*/

import java.util.HashSet;
import java.util.Iterator;

public class HashSetIterationDemo {
    public static void main(String[] args) {

        // Creating HashSet and adding elements
        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("HashSet: " + fruits);

        // 1. Iteration using for-each loop
        System.out.println("\nIterating using for-each loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 2. Iteration using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 3. Iteration using forEach method (lambda)
        System.out.println("\nIterating using forEach (lambda):");
        fruits.forEach(fruit -> System.out.println(fruit));

        // 4. Iteration using stream API
        System.out.println("\nIterating using stream():");
        fruits.stream().forEach(System.out::println);
    }
}
