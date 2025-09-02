/*
Problem Statement: Largest BST in a Binary Tree

✅ Problem Statement:
Given a binary tree, find the size (number of nodes) of the largest subtree which is a Binary Search Tree (BST).

Example 1:
Input: root = [5,2,4,1,3]
Output: 3
Explanation: The largest BST subtree is:
       2
     /   \
    1     3
Size = 3

Example 2:
Input: root = [50,30,60,5,20,45,70,null,null,null,null,null,null,65,80]
Output: 5
Explanation: The largest BST subtree is:
       60
      /  \
    45    70
         /  \
        65   80
Size = 5
*/

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

class Info {
    boolean isBST;
    int size, min, max;

    Info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

public class LargestBSTinBT {

    int maxSize = 0;

    public int largestBST(Node root) {
        postorder(root);
        return maxSize;
    }

    private Info postorder(Node root) {
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info left = postorder(root.left);
        Info right = postorder(root.right);

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);
            return new Info(true, size,
                    Math.min(root.data, left.min),
                    Math.max(root.data, right.max));
        }

        return new Info(false, 0, 0, 0);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        LargestBSTinBT tree = new LargestBSTinBT();
        System.out.println("Size of Largest BST: " + tree.largestBST(root));  // Output: 3
    }
}
