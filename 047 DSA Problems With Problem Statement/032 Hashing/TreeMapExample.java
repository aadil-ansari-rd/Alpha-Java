/*
Problem Statement: TreeMap Key-Value Ordering

Create a TreeMap to store key-value pairs where keys are strings and values are integers. The TreeMap should automatically maintain its keys in ascending (lexicographical) order. Demonstrate insertion of multiple key-value pairs and iterate over the TreeMap to print all entries in sorted key order.

Example Input:
Insert ("banana", 50), ("apple", 100), ("cherry", 75)

Example Output:
apple => 100
banana => 50
cherry => 75
*/

import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("banana", 50);
        map.put("apple", 100);
        map.put("cherry", 75);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
