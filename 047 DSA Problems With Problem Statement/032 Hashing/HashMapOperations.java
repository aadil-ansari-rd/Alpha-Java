/*
Problem Statement: Basic HashMap Operations in Java

Perform and demonstrate the following operations on a HashMap in Java:

1. Insert elements (put)
2. Update value for existing key
3. Retrieve value by key (get)
4. Retrieve value for a non-existing key
5. Remove a key
6. Check if a key exists (containsKey)
7. Check if a value exists (containsValue)
8. Find size of the map
9. Check if the map is empty (isEmpty)
10. Print all keys
11. Print all values
12. Print all key-value entries
13. Clear all entries (clear)

Example:
Input Operations:
put("apple", 10), put("banana", 20), put("cherry", 30)
put("banana", 25)
get("cherry"), get("mango")
remove("apple")
containsKey("banana"), containsKey("apple")
containsValue(25), containsValue(10)
size(), isEmpty()
keySet(), values(), entrySet()
clear()

Expected Output:
After inserting elements: {apple=10, banana=20, cherry=30}
After updating 'banana': {apple=10, banana=25, cherry=30}
Value of 'cherry': 30
Value of 'mango': null
After removing 'apple': {banana=25, cherry=30}
Contains key 'banana'? true
Contains key 'apple'? false
Contains value 25? true
Contains value 10? false
Size of map: 2
Is map empty? false
Keys: [banana, cherry]
Values: [25, 30]
Entries:
banana => 25
cherry => 30
After clearing: {}
Is map empty after clear()? true
*/

import java.util.HashMap;
import java.util.*;

public class HashMapOperations {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. Insert elements
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);
        System.out.println("After inserting elements: " + map);

        // 2. Update value for existing key
        map.put("banana", 25);  // Overwrites old value
        System.out.println("After updating 'banana': " + map);

        // 3. Get value by key
        System.out.println("Value of 'cherry': " + map.get("cherry")); // 30

        // 4. Get value for non-existing key
        System.out.println("Value of 'mango': " + map.get("mango")); // null

        // 5. Remove a key
        map.remove("apple");
        System.out.println("After removing 'apple': " + map);

        // 6. Check if key exists
        System.out.println("Contains key 'banana'? " + map.containsKey("banana")); // true
        System.out.println("Contains key 'apple'? " + map.containsKey("apple"));   // false

        // 7. Check if value exists
        System.out.println("Contains value 25? " + map.containsValue(25)); // true
        System.out.println("Contains value 10? " + map.containsValue(10)); // false

        // 8. Size of map
        System.out.println("Size of map: " + map.size()); // 2

        // 9. Check if empty
        System.out.println("Is map empty? " + map.isEmpty()); // false

        // 10. Print all keys
        System.out.println("Keys: " + map.keySet());

        // 11. Print all values
        System.out.println("Values: " + map.values());

        // 12. Print all entries
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 13. Clear all entries
        map.clear();
        System.out.println("After clearing: " + map);
        System.out.println("Is map empty after clear()? " + map.isEmpty()); // true
    }
}
