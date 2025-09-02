/*
Problem Statement: Group Anagrams (LeetCode 49)

Given an array of strings, group the anagrams together. You can return the answer in any order. An anagram is a word formed by rearranging the letters of another word.

Example Input:
["eat", "tea", "tan", "ate", "nat", "bat"]

Example Output:
[
  ["eat","tea","ate"],
  ["tan","nat"],
  ["bat"]
]

Approach:
1. Use a Trie to store sorted characters of each word.
2. Each leaf node stores original words that are anagrams of each other.
3. Traverse the Trie to collect all anagram groups.
*/

import java.util.*;

public class GroupAnagramsTrie {

    // Trie Node Definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> anagrams = new ArrayList<>();  // Store original words at leaf
    }

    TrieNode root = new TrieNode();

    // Insert a word by its sorted version into Trie
    private void insert(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        TrieNode node = root;

        for (char ch : chars) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }

        node.anagrams.add(word);  // Store original word at leaf
    }

    // DFS traversal to collect anagram groups
    private void collectAnagrams(TrieNode node, List<List<String>> result) {
        if (node == null) return;

        if (!node.anagrams.isEmpty())
            result.add(new ArrayList<>(node.anagrams));

        for (int i = 0; i < 26; i++)
            if (node.children[i] != null)
                collectAnagrams(node.children[i], result);
    }

    // Main function to group anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String word : strs)
            insert(word);

        List<List<String>> result = new ArrayList<>();
        collectAnagrams(root, result);
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        GroupAnagramsTrie solution = new GroupAnagramsTrie();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> grouped = solution.groupAnagrams(input);
        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }
}
