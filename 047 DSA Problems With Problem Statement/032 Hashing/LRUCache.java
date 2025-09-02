/*
Problem Statement: LRU Cache Implementation (LeetCode L146)

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
- LRUCache(int capacity) initializes the cache with positive size capacity.
- int get(int key) returns the value of the key if the key exists, otherwise returns -1.
- void put(int key, int value) update the value of the key if the key exists, or insert the key-value pair if not. 
  When the cache reaches its capacity, it should invalidate the least recently used item before inserting a new item.

Example:
Input:
LRUCache cache = new LRUCache(2);
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);
cache.put(3, 3);
cache.get(2);
cache.put(4, 4);
cache.get(1);
cache.get(3);
cache.get(4);

Output:
1
-1
-1
3
4
*/

import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail; // dummy head & tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Initialize dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node right after head (MRU)
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);              // Remove from current position
        insertAtFront(node);       // Move to front (MRU)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); // Remove old node
        }
        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            // Remove from back (LRU)
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // 🧪 Main method to test LRU Cache
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity = 2

        cache.put(1, 1); // cache: {1=1}
        cache.put(2, 2); // cache: {2=2, 1=1}
        System.out.println(cache.get(1)); // returns 1

        cache.put(3, 3); // evicts key 2, cache: {3=3, 1=1}
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1, cache: {4=4, 3=3}
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
