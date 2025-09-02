/*
Problem Statement: Iterating Over a HashMap in Java

Given a HashMap with key-value pairs, demonstrate different ways to iterate over its entries and print both keys and values.

Example:
Input: HashMap = {"apple":10, "banana":20, "cherry":30}
Output (any iteration method):
Key: apple, Value: 10
Key: banana, Value: 20
Key: cherry, Value: 30

Different iteration methods to demonstrate:
1. Using keySet()
2. Using entrySet()
3. Using forEach() with lambda
4. Using Iterator with entrySet()
*/

import java.util.*;

public class HashMapIterationMethods {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Add elements
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        System.out.println("Original Map: " + map);
        System.out.println("----- Iteration Methods -----\n");

        // 1. Iterate using keySet()
        System.out.println("1. Using keySet():");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // 2. Iterate using entrySet()
        System.out.println("\n2. Using entrySet():");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 3. Iterate using forEach() + lambda
        System.out.println("\n3. Using forEach() with lambda:");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 4. Iterate using Iterator with entrySet()
        System.out.println("\n4. Using Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
