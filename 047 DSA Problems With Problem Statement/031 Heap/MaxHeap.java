/*
Problem Statement: Implement Max Heap using ArrayList

✅ Problem Statement:
Implement a Max Heap data structure using a dynamic array (ArrayList) that supports the following operations:
1. `add(int data)`: Insert a new element into the heap.
2. `peek()`: Return the maximum element without removing it.
3. `remove()`: Remove and return the maximum element.
4. `isEmpty()`: Check whether the heap is empty.

Example:
Input:
Operations: add(40), add(10), add(30), add(50), add(20)
peek() -> returns 50
remove() -> returns 50
remove() -> returns 40
remove() -> returns 30
remove() -> returns 20
remove() -> returns 10
isEmpty() -> returns true

Constraints:
- Heap must maintain the max-heap property after every insertion and removal.
- `peek()` and `remove()` on an empty heap should handle exceptions appropriately.
*/

import java.util.ArrayList;

// Max Heap implementation using ArrayList
class Heap2 {
    ArrayList<Integer> arr = new ArrayList<>(); // Underlying dynamic array for heap elements

    // -------------------- Insert Element into Heap (Upheapify) --------------------
    public void add(int data) {
        arr.add(data); // Step 1: Add new element at the end
        int x = arr.size() - 1; // Index of newly added element
        int pIdx = (x - 1) / 2; // Parent index

        // Step 2: Upheapify - Swap while child is greater than parent
        while (x > 0 && arr.get(x) > arr.get(pIdx)) {
            // Swap child and parent
            int temp = arr.get(x);
            arr.set(x, arr.get(pIdx));
            arr.set(pIdx, temp);

            // Move up
            x = pIdx;
            pIdx = (x - 1) / 2;
        }
    }

    // -------------------- Get Maximum Element (Root) --------------------
    public int peek() {
        return arr.get(0); // Root element is always the maximum in max heap
    }

    // -------------------- Remove Maximum Element --------------------
    public int remove() {
        int data = arr.get(0); // Step 1: Store max element (root)

        // Step 2: Replace root with last element
        int lastIdx = arr.size() - 1;
        arr.set(0, arr.get(lastIdx));
        arr.remove(lastIdx); // Remove the last element

        // Step 3: Restore heap property using downheapify
        heapify(0);

        return data; // Return removed max
    }

    // -------------------- Heapify (Downheapify) --------------------
    private void heapify(int i) {
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index
        int maxIdx = i;        // Assume current node is largest

        // Compare with left child
        if (left < arr.size() && arr.get(maxIdx) < arr.get(left)) {
            maxIdx = left;
        }

        // Compare with right child
        if (right < arr.size() && arr.get(maxIdx) < arr.get(right)) {
            maxIdx = right;
        }

        // If a larger child exists, swap and continue downheapify
        if (maxIdx != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(maxIdx));
            arr.set(maxIdx, temp);

            // Recursive call
            heapify(maxIdx);
        }
    }

    // -------------------- Check if Heap is Empty --------------------
    public boolean isEmpty() {
        return arr.size() == 0;
    }
}


public class MaxHeap {
    public static void main(String[] args) {
        Heap2 heap = new Heap2();

        // Test 1: isEmpty() before any insertion
        System.out.println("Is heap empty? " + heap.isEmpty());  // Expected: true

        // Test 2: Add elements to the heap
        int[] input = {40, 10, 30, 50, 20};
        for (int val : input) {
            heap.add(val);
        }

        // Test 3: Peek max element
        System.out.println("Maximum element (peek): " + heap.peek());  // Expected: 50

        // Test 4: Remove all elements one by one
        System.out.print("Heap elements in sorted (descending) order: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }
        // Expected Output: 50 40 30 20 10

        // Test 5: Check heap after all elements are removed
        System.out.println("\nIs heap empty after removals? " + heap.isEmpty());  // Expected: true

        // Test 6: Edge case - peek/remove on empty heap
        try {
            heap.peek();
        } catch (Exception e) {
            System.out.println("Peek on empty heap threw: " + e.getClass().getSimpleName());
        }

        try {
            heap.remove();
        } catch (Exception e) {
            System.out.println("Remove on empty heap threw: " + e.getClass().getSimpleName());
        }
    }
}
