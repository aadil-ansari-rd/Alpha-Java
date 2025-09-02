/*
Problem Statement: LinkedHashMap Insertion Order Demonstration

Create a LinkedHashMap that stores key-value pairs of Strings and Integers. 
Insert elements and print all entries in the order they were inserted.

Example:
Input: Insert ("apple", 100), ("banana", 50), ("cherry", 75)
Output:
apple => 100
banana => 50
cherry => 75
*/

import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("apple", 100);
        map.put("banana", 50);
        map.put("cherry", 75);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
