/*
Problem Statement: Closest Value in BST

✅ Problem Statement:
Given the root of a Binary Search Tree (BST) and a target value K, find the value in the BST that is closest to K.

Example 1:
Input: root = [9,4,17,3,6,15,22], K = 18
Output: 17
Explanation: The value 17 is the closest to 18 in the BST.

Example 2:
Input: root = [8,5,11,3,6,20], K = 10
Output: 11
Explanation: The value 11 is the closest to 10 in the BST.
*/

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class ClosestInBST {

    // Function to find the value closest to target K
    public int findClosest(Node root, int K) {
        int closest = root.data;

        while (root != null) {
            // Update closest if current node is closer to K
            if (Math.abs(K - root.data) < Math.abs(K - closest)) {
                closest = root.data;
            }

            // Move left or right depending on comparison
            if (K < root.data) {
                root = root.left;
            } else if (K > root.data) {
                root = root.right;
            } else {
                // Exact match found
                return root.data;
            }
        }

        return closest;
    }

    // Sample BST builder and test
    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(15);
        root.right.right = new Node(22);

        ClosestInBST bst = new ClosestInBST();
        int target = 18;
        int result = bst.findClosest(root, target);
        System.out.println("Closest value to " + target + " is: " + result);  // Output: 17
    }
}
