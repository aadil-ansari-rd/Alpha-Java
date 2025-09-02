/*
Problem Statement: Check if a Binary Tree is Univalued

A binary tree is univalued if every node in the tree has the same value. Implement a function that checks whether a given binary tree is univalued.

Example:

Input Tree:
        1
       / \
      1   1
     / \
    1   1

Output:
true

Approach:
1. If the tree is empty, it's univalued → return true.
2. Recursively check each node:
   - If node is null → return true.
   - If node's value differs from root's value → return false.
   - Otherwise, recursively check left and right children.

Time Complexity: O(N), where N is the number of nodes.
Space Complexity: O(H), recursion stack (H = height of tree).
*/

// ✅ Java Program to check if a Binary Tree is Univalued
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class UnivaluedBinaryTree {

    // Function to check if tree is univalued
    public static boolean isUnivalued(Node root) {
        if (root == null) return true; // Empty tree is univalued
        return isSameValue(root, root.data);
    }

    // Helper recursive function to check each node
    private static boolean isSameValue(Node node, int value) {
        if (node == null) return true; // Null node doesn't violate condition
        
        if (node.data != value) return false; // If any value differs
        
        // Check left and right subtree recursively
        return isSameValue(node.left, value) && isSameValue(node.right, value);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);

        System.out.println(isUnivalued(root)); // Output: true
    }
}
