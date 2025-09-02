/*
Problem Statement: Word Ladder (Shortest Transformation Sequence) — LeetCode 127

Given two words, beginWord and endWord, and a dictionary wordList, find the length of the shortest transformation sequence from beginWord to endWord, such that:
1. Only one letter can be changed at a time.
2. Each transformed word must exist in the word list.

Return 0 if no such transformation sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: The shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog", length = 5.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, so no valid transformation exists.

Constraints:
- 1 <= beginWord.length <= 10
- endWord.length == beginWord.length
- 1 <= wordList.length <= 5000
- wordList[i].length == beginWord.length
- All words contain only lowercase English letters.
- beginWord != endWord
- All words in wordList are unique.
*/

import java.util.*;

public class WordLadderLengthFinder {

    // 🔍 BFS-based function to find shortest transformation sequence length
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // To check presence in O(1)
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;  // Start with beginWord

        while (!queue.isEmpty()) {
            int size = queue.size();  // Current level size
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try changing each character of the word
                for (int j = 0; j < word.length(); j++) {
                    char[] wordChars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        // Check if it is the end word
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If new word is in wordSet, add to queue and mark visited
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark visited
                        }
                    }
                }
            }
            level++;
        }

        return 0; // If no path exists
    }

    // ✅ Main function for testing
    public static void main(String[] args) {
        WordLadderLengthFinder solver = new WordLadderLengthFinder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = solver.ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + result);
    }
}
