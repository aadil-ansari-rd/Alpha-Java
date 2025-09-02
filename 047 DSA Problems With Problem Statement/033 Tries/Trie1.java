/*
Problem: Implement Trie (Prefix Tree) - LeetCode 208

Implement a trie with insert, search, and startsWith methods.

Methods:
1. insert(word): Inserts a word into the trie.
2. search(word): Returns true if the word exists in the trie.
3. startsWith(prefix): Returns true if there is any word in the trie that starts with the given prefix.

Example:

Input:
trie.insert("apple");
trie.search("apple");   // true
trie.search("app");     // false
trie.startsWith("app"); // true
trie.insert("app");
trie.search("app");     // true

Output:
true
false
true
true
*/

public class Trie1 {

    // Node definition for Trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26];  // 26 lowercase letters
        boolean isEndOfWord = false;             // Marks end of a word
    }

    private final TrieNode root;

    public Trie1() {
        root = new TrieNode();  // Initialize root node
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';  // Map character to index
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();  // Create new path
            }
            node = node.children[index];  // Move to child node
        }
        node.isEndOfWord = true;  // Mark end of inserted word
    }

    // Returns true if the word exists in Trie
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEndOfWord;
    }

    // Returns true if any word starts with given prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Helper to find the node for prefix/word
    private TrieNode findNode(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) return null;  // Path breaks
            node = node.children[index];
        }
        return node;
    }

    // 🧪 Main method to test Trie
    public static void main(String[] args) {
        Trie1 trie = new Trie1();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}
