/*
Problem Statement: LeetCode 124 - Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.  
A path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Function Signature:
int maxPathSum(Node root)

Example Input:
Binary Tree:
       -10
       /  \
      9   20
         /  \
        15   7

Example Output:
42

Explanation:
- The maximum path sum is 15 → 20 → 7, totaling 42.
- The path can start and end at any node and must follow parent-child links.
*/

// ✅ Java program to find Maximum Path Sum in Binary Tree
class Node {
    int data;
    Node left, right;
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class MaxPathSumBinaryTree {
    static int maxPathSum;

    // Function to calculate max path sum
    public static int findMaxPath(Node root) {
        if (root == null) return 0;

        // Recursively get max sum on left and right subtree, ignore negatives
        int leftMax = Math.max(0, findMaxPath(root.left));
        int rightMax = Math.max(0, findMaxPath(root.right));

        // Current node's max path sum = node + left + right
        int currentPathSum = root.data + leftMax + rightMax;

        // Update global maximum path sum
        maxPathSum = Math.max(maxPathSum, currentPathSum);

        // Return to parent: node + max(left or right gain)
        return root.data + Math.max(leftMax, rightMax);
    }

    public static int maxPathSum(Node root) {
        maxPathSum = Integer.MIN_VALUE; // Reset before use
        findMaxPath(root);
        return maxPathSum;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("Maximum Path Sum: " + maxPathSum(root));  // Output: 42
    }
}
