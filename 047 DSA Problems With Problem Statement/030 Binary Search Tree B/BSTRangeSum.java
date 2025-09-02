/*
✅ Java Program to Calculate Range Sum in a BST

**Explanation**:
1. **BST Property**: 
   - If `node.data < L` → all left nodes < L → skip left subtree.
   - If `node.data > R` → all right nodes > R → skip right subtree.
2. **Node in Range**: Sum node value + left subtree sum + right subtree sum.
3. **Recursion**: Traverses only relevant parts of BST for efficiency.

**Example**:
BST: 
        8
       / \
      5   11
     / \    \
    3   6    20

Range: [5, 11]  
Range Sum = 5 + 6 + 8 + 11 = 30
*/

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BSTRangeSum {

    // Function to calculate range sum in BST
    public int rangeSumBST(Node root, int L, int R) {
        if (root == null) return 0;

        // If node is less than L, explore right subtree only
        if (root.data < L) {
            return rangeSumBST(root.right, L, R);
        }

        // If node is greater than R, explore left subtree only
        if (root.data > R) {
            return rangeSumBST(root.left, L, R);
        }

        // If node is in range, add its value and explore both subtrees
        return root.data + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    // Sample BST builder for testing
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        BSTRangeSum bst = new BSTRangeSum();
        int L = 5, R = 11;
        int result = bst.rangeSumBST(root, L, R);
        System.out.println("Range Sum: " + result);  // Output: 30
    }
}
