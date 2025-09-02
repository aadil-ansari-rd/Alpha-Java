/*
✅ Java Program: Convert BST to Greater Sum Tree (GST)

**Explanation**:
1. Traverse BST **in reverse inorder** (Right → Node → Left) to accumulate values in descending order.
2. Maintain a **running sum** (`sum`) of all visited nodes.
3. For each node:
   - Add its original value to `sum`.
   - Update node value = `sum`.
4. Inorder traversal of the resulting tree gives increasing order of GST values.

**Example**:
Original BST: 
        5
       / \
      3   8
     / \    \
    2   4    10

After GST Conversion (Inorder): 32 30 27 23 18 10
*/

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BSTToGreaterSumTree {

    int sum = 0; // running cumulative sum

    // Function to convert BST to Greater Sum Tree
    public void convertToGST(Node root) {
        if (root == null) return;

        // Traverse right subtree first (greater values)
        convertToGST(root.right);

        // Update current node
        sum += root.data;
        root.data = sum;

        // Traverse left subtree
        convertToGST(root.left);
    }

    // Inorder traversal to print updated tree
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Main to test
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(10);

        BSTToGreaterSumTree tree = new BSTToGreaterSumTree();
        tree.convertToGST(root);

        // After conversion
        System.out.print("Inorder of Greater Sum Tree: ");
        tree.inorder(root);  // Output should show descending accumulation
    }
}
