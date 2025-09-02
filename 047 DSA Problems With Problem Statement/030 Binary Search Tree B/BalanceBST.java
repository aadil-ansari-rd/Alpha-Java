/*
✅ Java Program to Balance an Unbalanced BST

**Approach**:
1. Perform **inorder traversal** of the BST to get nodes in sorted order.
2. Use the sorted list to **reconstruct a balanced BST** recursively by picking the middle element as root.
3. Utilities included:
   - `printInorder` → Prints BST inorder (sorted order)
   - `printPreorder` → Prints BST preorder (structure view)

**Time Complexity**: O(N)  
**Space Complexity**: O(N) (for storing nodes in list and recursion stack)

**Example Usage**:
- Original BST (skewed): 1 → 2 → 3 → 4
- Balanced BST:
    - Inorder: 1 2 3 4
    - Preorder Structure: 2 1 3 4
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BalanceBST {

    // ✅ Step 1: Inorder traversal to collect nodes in sorted order
    private void inorder(Node root, List<Node> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    // ✅ Step 2: Build balanced BST from sorted list of nodes
    private Node buildBalancedBST(List<Node> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = list.get(mid);

        root.left = buildBalancedBST(list, start, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, end);
        return root;
    }

    // ✅ Main function to balance the BST
    public Node balanceBST(Node root) {
        List<Node> list = new ArrayList<>();
        inorder(root, list);
        return buildBalancedBST(list, 0, list.size() - 1);
    }

    // ✅ Utility: Inorder print of BST
    public void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // ✅ Utility: Preorder print to show structure
    public void printPreorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // ✅ Main function to test the solution
    public static void main(String[] args) {
        BalanceBST sol = new BalanceBST();

        // 🔻 Creating an unbalanced BST
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);

        System.out.println("Original BST (Inorder):");
        sol.printInorder(root);

        Node balancedRoot = sol.balanceBST(root);

        System.out.println("\n\nBalanced BST (Inorder):");
        sol.printInorder(balancedRoot);

        System.out.println("\n\nBalanced BST (Preorder Structure):");
        sol.printPreorder(balancedRoot);
    }
}
